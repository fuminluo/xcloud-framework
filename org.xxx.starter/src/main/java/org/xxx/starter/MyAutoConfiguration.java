package org.xxx.starter;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(MyProperties.class)
//只有yml配置该参数，才会加载此容器。
@ConditionalOnProperty(name = "my.prefix")
public class MyAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    TestTemplate initTestTemplate() {
        return new TestTemplate();
    }
}
