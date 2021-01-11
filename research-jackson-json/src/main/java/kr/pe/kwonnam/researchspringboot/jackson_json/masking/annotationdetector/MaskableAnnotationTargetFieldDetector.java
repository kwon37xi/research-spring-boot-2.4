package kr.pe.kwonnam.researchspringboot.jackson_json.masking.annotationdetector;

import com.fasterxml.jackson.databind.ser.PropertyWriter;
import kr.pe.kwonnam.researchspringboot.jackson_json.masking.Masker;
import kr.pe.kwonnam.researchspringboot.jackson_json.masking.MaskingTargetFieldDetector;

import java.lang.reflect.InvocationTargetException;

/**
 * {@link Maskable} 애노테이션을 필드에 지정하는 방식으로 마스킹 대상 필드를 선택한다.
 *
 * @see Maskable
 */
public class MaskableAnnotationTargetFieldDetector implements MaskingTargetFieldDetector {
    @Override
    public boolean include(PropertyWriter propertyWriter) {
        final Maskable maskable = propertyWriter.findAnnotation(Maskable.class);
        return maskable != null;
    }

    @Override
    public Masker getMasker(PropertyWriter propertyWriter) {
        final Maskable maskable = propertyWriter.findAnnotation(Maskable.class);
        final String fieldFullName = propertyWriter.getFullName().getSimpleName();

        if (maskable == null) {
            // 실제로 include 에서 미리 걸러졌으므로 Maskable이 존재하지 않는 상태는 있을 수 없다.
            throw new IllegalStateException(String.format("@Maskable annotation does not exists for field %s.", fieldFullName));
        }

        final Class<? extends Masker> maskerClass = maskable.value();
        try {
            return maskerClass.getConstructor().newInstance();
        } catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
            throw new IllegalArgumentException(String.format("Cannot instantiate %s class for field %s.", maskerClass.getCanonicalName(), fieldFullName));
        }
    }
}
