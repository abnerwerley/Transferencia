package com.transferencia.itau;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class ItauApplication {

	public static void main(String[] args) {
		SpringApplication.run(ItauApplication.class, args);
	}

}
