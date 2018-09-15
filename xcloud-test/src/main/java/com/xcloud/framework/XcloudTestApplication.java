package com.xcloud.framework;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.baomidou.mybatisplus.samples.quickstart.mapper")
public class XcloudTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(XcloudTestApplication.class, args);
	}
}
