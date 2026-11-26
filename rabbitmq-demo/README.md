# rabbitmq-demo

Publisher Confirm、手动 ACK/NACK、消息 ID。

## 代码入口

[src/main/java/learning/Demo.java](src/main/java/learning/Demo.java)

## 示例行为与边界

需要 RabbitMQ。创建独占自动删除队列，发布后等待 broker confirm，再取出处理并 ACK；异常 NACK 且不重新入队。确认发布成功并不等于业务处理成功。该临时队列示例不演示重启持久化。

## 运行

以下命令均在仓库根目录执行，需要 JDK 17+、Maven 3.9+。版本固定用于可复现学习，不代表最新版本。

```sh
docker compose --profile rabbitmq up -d --wait --wait-timeout 180
```

```sh
mvn -pl rabbitmq-demo -am test
mvn -pl rabbitmq-demo exec:java
```

成功时最后输出 `PASS`；连接失败会明确抛错，不会切换到内存模拟。默认 `mvn verify` 只编译此模块，不连接外部服务。

## 环境变量

| 变量 | 默认值 |
| --- | --- |
| `RABBITMQ_URI` | `amqp://learner:learning-local@localhost:5672/%2f` |

通过终端环境变量覆盖；不要将自己的密码提交到仓库。

结束后可运行 `docker compose --profile rabbitmq down`。Compose 的端口只绑定本机，演示账号和开发鉴权配置仅供本地学习。

## 参考

[相关文档](https://www.rabbitmq.com/tutorials/tutorial-seven-java)
