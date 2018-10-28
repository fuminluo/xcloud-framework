package com.xcloud.framework;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan({"com.xcloud.framework.mapper"})
public class XcloudPostgresqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(XcloudPostgresqlApplication.class, args);
	}
}
