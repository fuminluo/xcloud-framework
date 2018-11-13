package com.xcloud.framework.dubbo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * @Author administered
 * @Description
 * @Date 2018/10/19 22:26
 **/
@SpringBootApplication
@MapperScan("com.xcloud.framework.dubbo.mapper")
public class ProviderApplications {

    public static void main(String[] args) {
        new SpringApplicationBuilder(ProviderApplications.class)
                .web(WebApplicationType.NONE)
                .run(args);
    }
}
