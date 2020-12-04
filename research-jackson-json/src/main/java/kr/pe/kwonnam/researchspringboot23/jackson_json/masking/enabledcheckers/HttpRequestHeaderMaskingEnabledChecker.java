package kr.pe.kwonnam.researchspringboot23.jackson_json.masking.enabledcheckers;

import kr.pe.kwonnam.researchspringboot23.jackson_json.masking.MaskingEnabledChecker;

/**
 * HTTP Request Header 의 값에 따라 마스킹을 활성화한다.
 * <p/>
 * 보통 Servlet/Spring Web MVC 로 만들어진 API 에서 사용한다.
 */
public class HttpRequestHeaderMaskingEnabledChecker implements MaskingEnabledChecker {
    public final String headerName;

    public HttpRequestHeaderMaskingEnabledChecker(String headerName) {
        this.headerName = headerName;
    }

    @Override
    public boolean maskingEnabled() {
        // TODO
        return false;
    }
}
