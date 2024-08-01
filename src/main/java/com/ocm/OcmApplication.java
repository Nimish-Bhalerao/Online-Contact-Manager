package com.ocm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class OcmApplication {

	public static void main(String[] args) {
		SpringApplication.run(OcmApplication.class, args);
	}

}
