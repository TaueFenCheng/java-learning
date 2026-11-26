# Java Learning

Java 17 / Maven 多模块学习仓库，适合从前端 / Node.js 转向 Java 后端时逐个跟练。

全部 23 个模块均包含 Java 代码入口，不再包含空模块。Spring Boot 3.5.0 为固定学习基线，其他客户端版本见各 pom.xml；不声明为最新版本。

## 快速开始

需要 JDK 17+ 和 Maven 3.9+。以下命令在仓库根目录执行：

```sh
mvn clean verify
mvn -pl java-basic exec:java
mvn -pl spring-aop exec:java
mvn -pl mybatis-plus-demo exec:java
mvn -pl spring-transaction exec:java
mvn -pl spring-cloud-demo exec:java
mvn -pl distributed-transaction exec:java
```

`verify` 编译所有模块，执行 AOP、认证授权、MyBatis-Plus CRUD、事务回滚、负载均衡 HTTP 调用、Saga 幂等补偿测试；不要求本地已有中间件。Maven CI 使用 JDK 17。

## 模块与代码

| 模块 | 示例内容 | 依赖 |
| --- | --- | --- |
| [java-basic](java-basic/README.md) · [代码](java-basic/src/main/java/learning/Demo.java) | record 与基本类型 | 本地运行 |
| [java-collections](java-collections/README.md) · [代码](java-collections/src/main/java/learning/Demo.java) | 集合计数与 Map.merge | 本地运行 |
| [java-concurrent](java-concurrent/README.md) · [代码](java-concurrent/src/main/java/learning/Demo.java) | 线程池与 AtomicInteger | 本地运行 |
| [java-jvm](java-jvm/README.md) · [代码](java-jvm/src/main/java/learning/Demo.java) | 堆与 GC 信息 | 本地运行 |
| [spring-core](spring-core/README.md) · [代码](spring-core/src/main/java/learning/Demo.java) | Spring IoC 容器 | 本地运行 |
| [spring-boot-demo](spring-boot-demo/README.md) · [代码](spring-boot-demo/src/main/java/learning/Demo.java) | Spring Boot HTTP 接口 | 本地运行 |
| [spring-aop](spring-aop/README.md) · [代码](spring-aop/src/main/java/learning/Demo.java) | AOP 环绕通知、方法计时与异常传播 | 本地运行 |
| [spring-security](spring-security/README.md) · [代码](spring-security/src/main/java/learning/Demo.java) | HTTP Basic 认证、BCrypt 密码与角色授权 | 本地 HTTP 服务，默认 8080 |
| [spring-transaction](spring-transaction/README.md) · [代码](spring-transaction/src/main/java/learning/Demo.java) | Spring JDBC 事务提交、异常回滚与 rollbackOnly | 本地运行 |
| [mybatis-plus-demo](mybatis-plus-demo/README.md) · [代码](mybatis-plus-demo/src/main/java/learning/Demo.java) | BaseMapper CRUD、条件查询、提交与回滚 | 本地运行 |
| [mysql-demo](mysql-demo/README.md) · [代码](mysql-demo/src/main/java/learning/Demo.java) | 真实 MySQL JDBC、参数绑定、事务与条件扣减 | mysql |
| [redis-demo](redis-demo/README.md) · [代码](redis-demo/src/main/java/learning/Demo.java) | StringRedisTemplate 缓存、TTL、SET NX 与 Lua 解锁 | redis |
| [redisson-demo](redisson-demo/README.md) · [代码](redisson-demo/src/main/java/learning/Demo.java) | 真实 Redisson 可重入锁、tryLock 和 watchdog 模式 | redis |
| [rabbitmq-demo](rabbitmq-demo/README.md) · [代码](rabbitmq-demo/src/main/java/learning/Demo.java) | Publisher Confirm、手动 ACK/NACK、消息 ID | rabbitmq |
| [kafka-demo](kafka-demo/README.md) · [代码](kafka-demo/src/main/java/learning/Demo.java) | 幂等生产者、消费组、手动提交 next offset | kafka |
| [elasticsearch-demo](elasticsearch-demo/README.md) · [代码](elasticsearch-demo/src/main/java/learning/Demo.java) | 真实 REST API：建索引、写入、搜索、更新和删除 | elasticsearch |
| [nacos-demo](nacos-demo/README.md) · [代码](nacos-demo/src/main/java/learning/Demo.java) | Nacos Java SDK 配置发布/读取、服务注册/发现/注销 | nacos |
| [spring-cloud-demo](spring-cloud-demo/README.md) · [代码](spring-cloud-demo/src/main/java/learning/Demo.java) | Spring Cloud RoundRobinLoadBalancer + 双节点 HTTP 调用 | 本地运行 |
| [distributed-lock](distributed-lock/README.md) · [代码](distributed-lock/src/main/java/learning/Demo.java) | 单进程 ReentrantLock 基础（真实 Redis 锁见 redisson-demo） | 本地运行 |
| [distributed-transaction](distributed-transaction/README.md) · [代码](distributed-transaction/src/main/java/learning/Demo.java) | Saga：独立本地事务、幂等记录和可重试补偿 | 本地运行 |
| [cache-consistency](cache-consistency/README.md) · [代码](cache-consistency/src/main/java/learning/Demo.java) | 内存演示 Cache Aside 更新后失效 | 本地运行 |
| [local-message-table](local-message-table/README.md) · [代码](local-message-table/src/main/java/learning/Demo.java) | 内存事件与去重概念（非持久化 outbox） | 本地运行 |
| [order-service](order-service/README.md) · [代码](order-service/src/main/java/learning/Demo.java) | AtomicInteger 条件预扣概念（非完整订单系统） | 本地运行 |

## 真实中间件示例

按需启动一个服务，避免同时启动所有容器：

```sh
docker compose --profile redis up -d --wait --wait-timeout 180
mvn -pl redis-demo exec:java
mvn -pl redisson-demo exec:java
docker compose --profile redis down
```

其他 profile 为 `mysql`、`rabbitmq`、`kafka`、`elasticsearch`、`nacos`；具体运行命令、环境变量、预期输出和清理行为见模块 README。首次拉取镜像需要网络。Compose 不挂载持久卷，删除容器后数据不保留；端口绑定 127.0.0.1，使用开发账号与本地鉴权配置。

GitHub Actions 中的 **Middleware smoke examples** 可以手动运行，分别启动真实服务并执行对应 Java 客户端示例。常规 Maven CI 不连接这些服务；编译通过不等于外部集成通过。

## Web 示例

```sh
mvn -pl spring-boot-demo exec:java
# 新终端访问 http://localhost:8080/hello
```

停止服务后再运行 `mvn -pl spring-security exec:java`，按该模块 README 验证 200 / 401 / 403。

## 跟练顺序

1. java-basic → java-collections → java-concurrent → java-jvm。
2. spring-core → spring-boot-demo → spring-aop → spring-security → spring-transaction。
3. mysql-demo → mybatis-plus-demo → redis-demo → redisson-demo。
4. rabbitmq-demo → kafka-demo → elasticsearch-demo → nacos-demo → spring-cloud-demo。
5. cache-consistency → local-message-table → order-service → distributed-transaction，比较内存概念和真实中间件实现的边界。

## 示例边界

原有 distributed-lock、cache-consistency、local-message-table、order-service 是单进程基础示例；真实 Redis 锁见 redis-demo/redisson-demo。distributed-transaction 使用两个独立 H2 数据库演示 Saga，不具备生产协调器的故障恢复能力。消息确认、生产者幂等、事务提交各有不同边界，不能直接等同业务 exactly-once。各模块 README 包含具体说明。
