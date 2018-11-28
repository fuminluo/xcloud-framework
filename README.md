# xcloud-framework 一个 springcloud + maven  多模块项目

[![GitHub issues](https://img.shields.io/github/issues/yidao620c/SpringBootBucket.svg)](https://github.com/yidao620c/SpringBootBucket/issues)
[![License][licensesvg]][license]
[![Github downloads](https://img.shields.io/github/downloads/yidao620c/SpringBootBucket/total.svg)](https://github.com/yidao620c/SpringBootBucket/releases/latest)
[![GitHub release](https://img.shields.io/github/release/yidao620c/SpringBootBucket.svg)](https://github.com/yidao620c/SpringBootBucket/releases)

## 1. xcloud-eureka 注册中心(springcloud+eureka) 

## 2. xcloud-routing 路由网管 (springcloud+zuul)

## 3. xcloud-oauth2 授权、鉴权服务(springcloud+oauth2)

## 4. xcloud-test 测试微服务(springboot+mybatis+mybatisplus)

## 5. xcloud-user 用户中心微服务(springboot+mybatis+mybatisplus)

## 6. xcloud-service 业务逻辑模块（不可单独启动）

## 7. xcloud-entity 实体类（不可单独启动）

## 8. xcloud-mapper 持久层模块（不可单独启动）

## 9. xcloud-dubbo-api dubbo接口

## 10. xcloud-dubbo-consumer dubbo消费者

## 11. xcloud-dubbo-productor dubbo 生产者

## 12. xcloud-common 公共包

## 13. xcloud-postgresql psSQL + Mybatis 集成案例（独立模块）

## 环境

* JDK 1.8
* Maven latest
* Spring Boot 2.0.6
* Intellij IDEA
* mysql 
* redis 缓存

## 运行

1. 在IDEA里面直接运行Application.java的main函数。
2. 另一种方式是执行`mvn clean package`命令后传到linux服务器上面，通过命令`java -Xms64m -Xmx1024m -jar xxx.jar`方式运行
3. 在linux服务器上面，配置好jdk、maven、git命令后，通过`git clone sb-xxx`拉取工程后，执行`./run.sh start test`命令来执行

注：每个子项目有自己的README.md文件，告诉你该怎么初始化环境，db 文件夹下有数据库脚本等。

另外，如果你需要打包成war包放到tomcat容器中运行，可修改pom.xml文件，将打包类型从jar改成war，打包后再放到容器中运行：

``` xml
<modelVersion>4.0.0</modelVersion>
<artifactId>springboot-cache</artifactId>
<packaging>war</packaging>
```
