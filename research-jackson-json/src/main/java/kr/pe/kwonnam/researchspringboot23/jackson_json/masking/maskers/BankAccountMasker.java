package kr.pe.kwonnam.researchspringboot23.jackson_json.masking.maskers;

import kr.pe.kwonnam.researchspringboot23.jackson_json.masking.Masker;

/**
 * 은행 계좌 번호를 마스킹한다.
 *
 */
public class BankAccountMasker implements Masker {
    @Override
    public String doMask(Object fieldValue) {
        return null;
    }
}
