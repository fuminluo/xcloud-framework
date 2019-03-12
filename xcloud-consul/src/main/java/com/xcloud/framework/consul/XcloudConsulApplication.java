package com.xcloud.framework.consul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class XcloudConsulApplication {

    public static void main(String[] args) {
        SpringApplication.run(XcloudConsulApplication.class, args);
    }

}
