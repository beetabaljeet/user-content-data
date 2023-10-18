package com.contentdata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableMBeanExport;

@SpringBootApplication
@EnableFeignClients
@RefreshScope
@ComponentScan(basePackages = "com.contentdata.*")
public class ContentDataApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContentDataApplication.class, args);
	}

}
