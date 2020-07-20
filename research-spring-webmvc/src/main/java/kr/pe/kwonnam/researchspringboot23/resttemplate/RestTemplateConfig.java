package kr.pe.kwonnam.researchspringboot23.resttemplate;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {
    /**
     * RestTemplateBuilder 에 setConnectTimeout, setReadTimeout 을 지정하면,
     * Reflection 으로 ClientHttpRequestFactory 에서 동일 메소드를 찾아서 설정을 해준다.
     * ClientHttpRequestFactory 자체에 설정을 해둘것이라면 불필요한 중복으로 보인다.
     *
     * @param restTemplateBuilder
     * @return
     * @see RestTemplateBuilder.RequestFactoryCustomizer#accept(org.springframework.http.client.ClientHttpRequestFactory)
     */
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {
        var okHttp3ClientHttpRequestFactory = new OkHttp3ClientHttpRequestFactory();
        okHttp3ClientHttpRequestFactory.setReadTimeout(10000);
        okHttp3ClientHttpRequestFactory.setWriteTimeout(10000);
        okHttp3ClientHttpRequestFactory.setConnectTimeout(1000);

        return restTemplateBuilder
            .requestFactory(() -> okHttp3ClientHttpRequestFactory)
            .build();
    }
}
