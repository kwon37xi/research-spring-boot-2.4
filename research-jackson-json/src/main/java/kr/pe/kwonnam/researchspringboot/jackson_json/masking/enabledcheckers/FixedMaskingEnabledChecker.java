package kr.pe.kwonnam.researchspringboot.jackson_json.masking.enabledcheckers;

import kr.pe.kwonnam.researchspringboot.jackson_json.masking.MaskingEnabledChecker;

/**
 * 특정값으로 고정된 MaskingEnabledChecker
 */
public class FixedMaskingEnabledChecker implements MaskingEnabledChecker {
    private final boolean maskingEnabled;

    public FixedMaskingEnabledChecker(boolean maskingEnabled) {
        this.maskingEnabled = maskingEnabled;
    }

    @Override
    public boolean maskingEnabled() {
        return maskingEnabled;
    }
}
