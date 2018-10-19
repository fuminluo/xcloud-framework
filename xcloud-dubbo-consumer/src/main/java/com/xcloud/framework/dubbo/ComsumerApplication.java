package com.xcloud.framework.dubbo;

import com.xcloud.framework.dubbo.service.DubboConsumerService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

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
