package com.sopt.lyt.soptseminar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SoptSeminarApplication {

	public static void main(String[] args) {
		SpringApplication.run(SoptSeminarApplication.class, args);
	}

}