package kr.pe.kwonnam.researchspringboot23.jackson_json.masking;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.PropertyWriter;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import lombok.extern.slf4j.Slf4j;

/**
 * Masking을 관장하는 필터.
 */
@Slf4j
public class PropertyMaskingFilter extends SimpleBeanPropertyFilter {
    public static final String MASKING_FILTER_ID = "jacksonMaskingFilter";

    private final MaskingTargetFieldDetector maskingTargetFieldDetector;
    private final MaskingEnabledChecker maskingEnabledChecker;

    public PropertyMaskingFilter(MaskingTargetFieldDetector maskingTargetFieldDetector,
                                 MaskingEnabledChecker maskingEnabledChecker) {
        if (maskingTargetFieldDetector == null) {
            throw new IllegalArgumentException("maskingTargetFieldDetector must not be null.");
        }

        if (maskingEnabledChecker == null) {
            throw new IllegalArgumentException("maskingEnabledChecker must not be null.");
        }

        this.maskingTargetFieldDetector = maskingTargetFieldDetector;
        this.maskingEnabledChecker = maskingEnabledChecker;
    }

    @Override
    protected boolean include(PropertyWriter writer) {
        return isMaskable(writer);
    }

    private boolean isMaskable(PropertyWriter writer) {
        if (!maskingEnabledChecker.maskingEnabled()) {
            return false;
        }

        return maskingTargetFieldDetector.include(writer);
    }

    @Override
    public void serializeAsField(Object pojo, JsonGenerator jgen, SerializerProvider provider, PropertyWriter writer) throws Exception {
        if (!isMaskable(writer)) {
            super.serializeAsField(pojo, jgen, provider, writer);
            return;
        }

        final Masker masker = maskingTargetFieldDetector.getMasker(writer);
        super.serializeAsField(masker.doMask(pojo), jgen, provider, writer);
    }


    /**
     * {@link ObjectMapper}에 Masking 필터를 적용한다.
     */
    public static ObjectMapper init(ObjectMapper objectMapper, PropertyMaskingFilter propertyMaskingFilter) {
        SimpleFilterProvider simpleFilterProvider;
        final FilterProvider filterProvider = objectMapper.getSerializationConfig().getFilterProvider();

        if (filterProvider instanceof SimpleFilterProvider) {
            simpleFilterProvider = (SimpleFilterProvider) filterProvider;
        } else if (filterProvider == null) {
            simpleFilterProvider = new SimpleFilterProvider();
            objectMapper.setFilterProvider(simpleFilterProvider);
        } else {
            throw new IllegalStateException("Unable to register MaskingPropertyFilter with FilterProvider of type "
                + filterProvider.getClass().getName()
                + ". You'll have to register the filter manually.");
        }

        simpleFilterProvider.addFilter(PropertyMaskingFilter.MASKING_FILTER_ID, propertyMaskingFilter);
        objectMapper.addMixIn(Object.class, PropertyMaskingFilterMixIn.class);

        return objectMapper;
    }

    public static void init(Iterable<ObjectMapper> objectMappers, PropertyMaskingFilter propertyMaskingFilter) {
        for (ObjectMapper objectMapper : objectMappers) {
            init(objectMapper, propertyMaskingFilter);
        }
    }
}
