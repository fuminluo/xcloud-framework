package com.xcloud.framework.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.filter.factory.StripPrefixGatewayFilterFactory;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class XcloudGatewayApplication {


    /**
     * 地址映射规则（坑爹）
     * http://localhost:8080/a/user/all 路由到 服务A http://localhost:8081/user/all
     *
     * @param builder
     * @return
     */
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        StripPrefixGatewayFilterFactory.Config config = new StripPrefixGatewayFilterFactory.Config();
        config.setParts(1);
        return builder.routes()
                .route("xcloud-oauth", r -> r.path("/xcloud-oauth/**").filters(f -> f.stripPrefix(1)).uri("http://localhost:8710"))
                .route("xcloud-usercore", r -> r.path("/xcloud-usercore/**").filters(f -> f.stripPrefix(1)).uri("http://localhost:8763"))
                .route("xcloud-test", r -> r.path("/xcloud-test/**").filters(f -> f.stripPrefix(1)).uri("http://localhost:8762"))
                .build();
    }


    public static void main(String[] args) {
        SpringApplication.run(XcloudGatewayApplication.class, args);
    }
}
