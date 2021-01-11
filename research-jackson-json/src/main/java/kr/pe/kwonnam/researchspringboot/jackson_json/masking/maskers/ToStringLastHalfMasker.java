package kr.pe.kwonnam.researchspringboot.jackson_json.masking.maskers;


import kr.pe.kwonnam.researchspringboot.jackson_json.masking.Masker;

/**
 * 문자열의 마지막 반을 마스킹 처리한다.
 */
public class ToStringLastHalfMasker implements Masker {
    public static final String DEFAULT_MASKING_STRING = "***";

    private final String maskingString;

    public ToStringLastHalfMasker() {
        this(DEFAULT_MASKING_STRING);
    }

    public ToStringLastHalfMasker(String maskingString) {
        this.maskingString = maskingString;
    }


    @Override
    public String doMask(Object fieldValue) {
        return null;
    }
}
