package com.xcloud.framework.dubbo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Author administered
 * @Description
 * @Date 2018/10/19 22:37
 **/

@SpringBootApplication
public class ComsumerApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(ComsumerApplication.class, args);
    }
}
