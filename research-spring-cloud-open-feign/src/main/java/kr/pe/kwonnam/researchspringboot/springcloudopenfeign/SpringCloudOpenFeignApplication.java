package kr.pe.kwonnam.researchspringboot.springcloudopenfeign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SpringCloudOpenFeignApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudOpenFeignApplication.class, args);
	}

}
