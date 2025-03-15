package com.eight.travel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:config/secu.properties")
public class MytravelApplication {

	public static void main(String[] args) {
		SpringApplication.run(MytravelApplication.class, args);
	}
}
