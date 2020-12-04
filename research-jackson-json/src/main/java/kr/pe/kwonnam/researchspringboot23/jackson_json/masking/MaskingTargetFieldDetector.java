package kr.pe.kwonnam.researchspringboot23.jackson_json.masking;

import com.fasterxml.jackson.databind.ser.PropertyWriter;

/**
 * 특정 필드를 마스킹 할지 여부를 결정하고, 해당 필드에 사용할 {@link Masker}를 결정해준다.
 */
public interface MaskingTargetFieldDetector {
    boolean include(PropertyWriter propertyWriter);

    Masker getMasker(PropertyWriter propertyWriter);
}
