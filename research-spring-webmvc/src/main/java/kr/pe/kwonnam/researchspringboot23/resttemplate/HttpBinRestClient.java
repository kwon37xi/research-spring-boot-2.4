package kr.pe.kwonnam.researchspringboot23.resttemplate;

import lombok.SneakyThrows;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@Component
public class HttpBinRestClient {
    public static final String TARGET_HOST = "https://httpbin.org";

    private RestTemplate restTemplate;

    public HttpBinRestClient(RestTemplateBuilder restTemplateBuilder) {
        restTemplate = restTemplateBuilder.build();
    }

    @SneakyThrows
    public ResponseEntity<HashMap<String, Object>> simpleGet() {
        ParameterizedTypeReference<HashMap<String, Object>> responseType = new ParameterizedTypeReference<HashMap<String, Object>>() {
        };
        var requestEntity = RequestEntity.get(new URI(TARGET_HOST + "/get"))
            .accept(MediaType.APPLICATION_JSON)
            .build();
        return restTemplate.exchange(requestEntity, responseType);
    }
}
