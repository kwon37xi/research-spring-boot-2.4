package kr.pe.kwonnam.researchspringboot.profilegroup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigurationProperties
public class ProfileGroupWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProfileGroupWebApplication.class, args);
    }

    @Bean
    public ProfileGroupModule1Properties profileGroupModule1Properties() {
        return new ProfileGroupModule1Properties();
    }

    @Bean
    public ProfileGroupModule2Properties profileGroupModule2Properties() {
        return new ProfileGroupModule2Properties();
    }
}
