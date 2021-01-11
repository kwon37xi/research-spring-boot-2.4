package kr.pe.kwonnam.researchspringboot.resttemplate;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.AutoConfigureMockRestServiceServer;
import org.springframework.boot.test.autoconfigure.web.client.AutoConfigureWebClient;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * {@link RestClientTest} 는  {@link org.springframework.boot.web.client.RestTemplateBuilder} 를 사용하는 Bean들에 대한 테스트이다.
 * {@link RestTemplate}을 직접 생성하는 경우에 대한 테스트가 아니다.
 *
 * {@link RestTemplate} 을 직접 테스트하고자 한다면, {@code @AutoConfigureWebClient(registerRestTemplate = true)} 설정이 필요하다.
 * <p>
 * {@link org.springframework.test.web.client.MockRestServiceServer} 가 기본 설정되기 때문에 실제 요청은 서버로 전달이 안되는데,
 * 실 서버로 요청을 하려면 {@code @AutoConfigureMockRestServiceServer(enabled = false)}가 필요하다.
 *
 * @see RestClientTest
 */
@Slf4j
@DisplayName("RestTemplateConfigTest")
@RestClientTest
@AutoConfigureWebClient(registerRestTemplate = true)
@AutoConfigureMockRestServiceServer(enabled = false)
class RestTemplateConfigTest {

    @Autowired
    private RestTemplate restTemplate;

    @Test
    void simpleGet() {
        ResponseEntity<? extends HashMap> res = restTemplate.getForEntity(HttpBinRestClient.TARGET_HOST + "/get", new HashMap<String, Object>().getClass());
        assertThat(res.getStatusCode()).isEqualTo(HttpStatus.OK);
        HashMap body = res.getBody();
        log.info("body : {}", body);
    }
}