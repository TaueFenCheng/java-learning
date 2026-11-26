# Java Learning

Java 17 / Maven 多模块学习仓库。Spring Boot 3.5.0 为示例固定版本，非最新版本声明。

## 构建

```sh
mvn clean verify
```

## 已有示例

- java-basic
- java-collections
- java-concurrent
- java-jvm
- distributed-lock
- cache-consistency
- local-message-table
- order-service
- spring-core
- spring-boot-demo

纯 Java 示例：`java -cp java-basic/target/classes learning.Demo`（先构建）。

Spring Boot 示例：在模块目录执行 `mvn org.springframework.boot:spring-boot-maven-plugin:3.5.0:run`，访问 `/hello`。

## 待实现

- spring-aop
- spring-security
- spring-transaction
- mybatis-plus-demo
- mysql-demo
- redis-demo
- redisson-demo
- rabbitmq-demo
- kafka-demo
- elasticsearch-demo
- nacos-demo
- spring-cloud-demo
- distributed-transaction

## 注意

分布式相关的初始示例仅演示单进程概念，未接入外部中间件。
