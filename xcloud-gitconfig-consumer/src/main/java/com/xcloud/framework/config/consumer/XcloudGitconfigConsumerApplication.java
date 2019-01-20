package com.xcloud.framework.config.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@EnableEurekaClient
@SpringBootApplication
public class XcloudGitconfigConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(XcloudGitconfigConsumerApplication.class, args);
	}

}

