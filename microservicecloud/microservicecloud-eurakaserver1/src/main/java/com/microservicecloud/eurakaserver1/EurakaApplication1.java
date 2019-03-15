package com.microservicecloud.eurakaserver1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer //启用euraka
public class EurakaApplication1 {
    public static void main(String[] args) {
		SpringApplication.run(EurakaApplication1.class, args);
	}
}
