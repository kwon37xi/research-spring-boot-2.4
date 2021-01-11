package kr.pe.kwonnam.researchspringboot.jackson_json.masking.maskers;

import kr.pe.kwonnam.researchspringboot.jackson_json.masking.Masker;

/**
 * 기본 마스킹 클래스.
 * {@code maskedString} 으로 필드 값을 대체해버린다.
 */
public class DefaultMasker implements Masker {
    public static final String DEFAULT_MASKED_STRING = "--masked--";

    public final String maskedString;

    public DefaultMasker() {
        this(DEFAULT_MASKED_STRING);
    }

    public DefaultMasker(String maskedString) {
        this.maskedString = maskedString;
    }

    @Override
    public String doMask(Object fieldValue) {
        return maskedString;
    }
}
