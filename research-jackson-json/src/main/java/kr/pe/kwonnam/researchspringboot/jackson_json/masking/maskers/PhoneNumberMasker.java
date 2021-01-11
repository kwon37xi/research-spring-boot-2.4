package kr.pe.kwonnam.researchspringboot.jackson_json.masking.maskers;

import kr.pe.kwonnam.researchspringboot.jackson_json.masking.Masker;

/**
 * {@code 010-xxxx-yyyy}, {@code 031-xxxx-yyyy} 형태의 전화 번호를 마스킹한다.
 * <p/>
 * 그 외의 비정규적인 포맷의 전화번호에 대해서도 대응한다.
 */
public class PhoneNumberMasker implements Masker {
    @Override
    public String doMask(Object fieldValue) {
        return null;
    }
}
