package com.xcloud.framework.pgsql;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.xcloud.framework.pgsql.mapper")
public class XcloudPostgresqlApplication {

    public static void main(String[] args) {
        SpringApplication.run(XcloudPostgresqlApplication.class, args);
    }
}
