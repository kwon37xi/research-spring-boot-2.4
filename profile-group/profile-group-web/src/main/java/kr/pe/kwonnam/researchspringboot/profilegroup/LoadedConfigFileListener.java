package kr.pe.kwonnam.researchspringboot.profilegroup;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.config.ConfigFileApplicationListener;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.Ordered;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertySource;
import org.springframework.stereotype.Component;

import java.util.Iterator;

@Slf4j
@Component
public class LoadedConfigFileListener implements ApplicationListener<ApplicationReadyEvent>, Ordered {

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        MutablePropertySources propertySources = event.getApplicationContext().getEnvironment().getPropertySources();
        Iterator<PropertySource<?>> propertySourceIterator = propertySources.iterator();
        propertySourceIterator.forEachRemaining(propertySource -> log.info("Successfully loaded: \"{}\" ({}) into application context", propertySource.getName(), propertySource.getSource()));
    }

    @Override
    public int getOrder() {
        return ConfigFileApplicationListener.DEFAULT_ORDER + 1;
    }
}
