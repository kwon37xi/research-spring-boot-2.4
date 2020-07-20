package kr.pe.kwonnam.researchspringboot23.jackson_json.customizer;

import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import java.util.Locale;
import java.util.TimeZone;

@Configuration
public class Jackson2ObjectMapperBuilderCustomizerConfig implements Jackson2ObjectMapperBuilderCustomizer {
    /**
     * 일관성있는 JSON Date/Time 포매팅 설정. 항상 ISO_DATE_TIME 표준을 사용하여 날짜/시간을 직렬화한다.
     * <p>
     * SpringBoot 2 부터는 {@code WRITE_DATES_AS_TIMESTAMPS=false}가 기본값이라서 모든 날짜 데이터를 ISO 포맷으로 기본 출력한다.
     * {@code java.util.Date}에 대해서만 다른 포맷과 비슷하게 맞춰준다.
     *
     * <pre>
     * "localDateTime":"2018-07-18T15:11:49.693",
     * "localDate":"2018-07-18",
     * "localTime":"15:11:49.693",
     * "offsetDateTime, java.util.Date":"2018-07-18T15:11:49.693+09:00",
     * "zonedDateTime":"2018-07-18T15:11:49.693+09:00" -- [Asia/Seoul] 는 붙지 않는다. [Asia/Seoul]붙는 것은 표준포맷이 아니다.
     * </pre>
     * <p>
     */
    @Override
    public void customize(Jackson2ObjectMapperBuilder jacksonObjectMapperBuilder) {
        jacksonObjectMapperBuilder
            .timeZone(TimeZone.getDefault()) // 지정하지 않으면 UTC
            .locale(Locale.getDefault())
            .simpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
    }
}
