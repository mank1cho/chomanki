package com.kakaopay.membership;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class ChomankiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChomankiApplication.class, args);
	}

}
