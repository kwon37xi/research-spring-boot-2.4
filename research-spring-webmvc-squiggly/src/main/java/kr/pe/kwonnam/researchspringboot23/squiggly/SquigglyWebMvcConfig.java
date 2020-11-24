package kr.pe.kwonnam.researchspringboot23.squiggly;

import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.github.bohnman.squiggly.web.SquigglyRequestFilter;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

@Configuration
public class SquigglyWebMvcConfig implements Jackson2ObjectMapperBuilderCustomizer, WebMvcConfigurer {
    @Override
    public void customize(Jackson2ObjectMapperBuilder jacksonObjectMapperBuilder) {
        // 설정값 변경이 먹는지 확인하기 위한 고의적 포맷 변경
        LocalDateSerializer localDateSerializer = new LocalDateSerializer(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일"));

        jacksonObjectMapperBuilder
            .timeZone(TimeZone.getDefault())
            .locale(Locale.getDefault())
            .serializerByType(LocalDate.class, localDateSerializer);
    }

    @Bean
    public FilterRegistrationBean squigllyRequestFilter() {
        FilterRegistrationBean filter = new FilterRegistrationBean();
        filter.setFilter(new SquigglyRequestFilter());
        filter.setUrlPatterns(List.of("/squiggly/*"));
        return filter;
    }

}
