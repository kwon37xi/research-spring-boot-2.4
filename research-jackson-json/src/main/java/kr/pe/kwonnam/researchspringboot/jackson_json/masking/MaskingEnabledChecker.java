package kr.pe.kwonnam.researchspringboot.jackson_json.masking;

/**
 * 마스킹이 활성화 됐는지 여부를 결정한다.
 */
public interface MaskingEnabledChecker {
    boolean maskingEnabled();
}
