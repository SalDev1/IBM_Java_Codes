package com.myapp.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SpringMsEurekaServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMsEurekaServiceApplication.class, args);
	}

}
