package com.microservice.eurekaserver.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ApiGateWaysApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGateWaysApplication.class, args);
	}

}
