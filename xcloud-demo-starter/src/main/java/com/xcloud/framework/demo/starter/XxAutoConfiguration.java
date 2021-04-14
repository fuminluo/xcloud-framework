package com.xcloud.framework.demo.starter;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(XxProperties.class)
//只有yml配置该参数，才会加载此容器。
@ConditionalOnProperty(name = "xx.name")
public class XxAutoConfiguration {

    @Bean
    public XxTemplate xxTemplate() {
        return new XxTemplate();
    }
}
