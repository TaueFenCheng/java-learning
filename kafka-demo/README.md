# kafka-demo

幂等生产者、消费组、手动提交 next offset。

## 代码入口

[src/main/java/learning/Demo.java](src/main/java/learning/Demo.java)

## 示例行为与边界

需要单节点 Kafka。每次创建唯一 topic 和 group，先发送再从 earliest 消费，处理成功后提交 record.offset()+1，最后删除本次 topic。需要创建/删除 topic 权限。生产者幂等不代表业务端 exactly-once；跨进程业务仍需持久幂等键。

## 运行

以下命令均在仓库根目录执行，需要 JDK 17+、Maven 3.9+。版本固定用于可复现学习，不代表最新版本。

```sh
docker compose --profile kafka up -d --wait --wait-timeout 180
```

```sh
mvn -pl kafka-demo -am test
mvn -pl kafka-demo exec:java
```

成功时最后输出 `PASS`；连接失败会明确抛错，不会切换到内存模拟。默认 `mvn verify` 只编译此模块，不连接外部服务。

## 环境变量

| 变量 | 默认值 |
| --- | --- |
| `KAFKA_BOOTSTRAP` | `localhost:9092` |

通过终端环境变量覆盖；不要将自己的密码提交到仓库。

结束后可运行 `docker compose --profile kafka down`。Compose 的端口只绑定本机，演示账号和开发鉴权配置仅供本地学习。

## 参考

[相关文档](https://kafka.apache.org/39/javadoc/org/apache/kafka/clients/consumer/KafkaConsumer.html)
