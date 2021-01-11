package kr.pe.kwonnam.researchspringboot.jackson_json.masking.annotationdetector;


import kr.pe.kwonnam.researchspringboot.jackson_json.masking.maskers.DefaultMasker;
import kr.pe.kwonnam.researchspringboot.jackson_json.masking.Masker;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Masking 하고자 하는 Field 를 지정한다.
 */
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Maskable {
    /**
     * 필드 값 Masking 을 수행하는 클래스 지정
     */
    Class<? extends Masker> value() default DefaultMasker.class;
}
