package com.xcloud.framework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class XcloudTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(XcloudTestApplication.class, args);
	}
}
