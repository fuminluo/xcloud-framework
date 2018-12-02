# xcloud-framework
## springcloud-eureka 注册中心（不继承 xcloud-framework 父结构）！

# 1. 创建eureka-server项目
选择依赖 **spring-cloud-starter-netflix-eureka-server**
## 1.1 启动类里添加注释
``` java
@EnableEurekaServer
@SpringBootApplication
public class XcloudEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(XcloudEurekaApplication.class, args);
	}
}
```
## 1.2 application.properties
``` xml
server.port=8760
eureka.instance.hostname=localhost
eureka.client.register-with-eureka=false
eureka.client.fetch-registry=false
eureka.client.service-url.defaultZone=http://${eureka.instance.hostname}:${server.port}/eureka/
eureka.server.enableSelfPreservation=false

```
配置完成可以访问 http://localhost:8760
