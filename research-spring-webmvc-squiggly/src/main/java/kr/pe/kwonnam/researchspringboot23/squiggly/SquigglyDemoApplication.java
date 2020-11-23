package kr.pe.kwonnam.researchspringboot23.squiggly;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.bohnman.squiggly.Squiggly;
import com.github.bohnman.squiggly.web.RequestSquigglyContextProvider;
import com.github.bohnman.squiggly.web.SquigglyRequestFilter;
import kr.pe.kwonnam.researchspringboot23.squiggly.model.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.Map;

@Slf4j
@SpringBootApplication
public class SquigglyDemoApplication {

    public static final String JSON_RESPONSE_FILTER_QUERY_PARAM_NAME = "_fields";

    public static void main(String[] args) {
        final ConfigurableApplicationContext context = SpringApplication.run(SquigglyDemoApplication.class, args);

        for (MappingJackson2HttpMessageConverter converter : context.getBeansOfType(MappingJackson2HttpMessageConverter.class).values()) {
            final ObjectMapper objectMapper = converter.getObjectMapper();
            converter.setObjectMapper(Squiggly.init(objectMapper, new RequestSquigglyContextProvider(JSON_RESPONSE_FILTER_QUERY_PARAM_NAME, null) {
                @Override
                protected String customizeFilter(String filter, HttpServletRequest request, Class beanClass) {
                    log.info("current filter : {}, beanClass : {}", filter, beanClass);
                    if (filter != null && ErrorResponse.class.isAssignableFrom(beanClass)) {
                        return "";
                    }
                    return filter;
                }
            }));
        }
    }
}
