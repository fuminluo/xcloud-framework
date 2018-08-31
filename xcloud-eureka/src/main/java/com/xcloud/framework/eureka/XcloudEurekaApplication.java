package com.xcloud.framework.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class XcloudEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(XcloudEurekaApplication.class, args);
	}
}
