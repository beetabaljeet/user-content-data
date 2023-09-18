package com.contentdata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.contentdata.*")
public class ContentDataApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContentDataApplication.class, args);
	}

}
