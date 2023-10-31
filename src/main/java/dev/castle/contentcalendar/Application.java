package dev.castle.contentcalendar;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
	ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
	RestTemplate restTemplate = (RestTemplate) context.getBean("restTemplate");
		System.out.println(restTemplate);
	}

	@Profile("dev")
	@Bean
	CommandLineRunner commandLineRunner () {
		return args -> {
			System.out.println("Hello World");
		};
	}



}
