# distributed-transaction

Saga：独立本地事务、幂等记录和可重试补偿。

## 代码入口

[src/main/java/learning/Demo.java](src/main/java/learning/Demo.java)

## 示例行为与边界

使用两个独立 H2 内存库，借记与贷记各自提交。测试成功重试不重复扣款、确定失败前退款、重复补偿、同幂等键不同金额拒绝。只演示本地编排核心，未实现持久化协调器、宕机恢复、网络调用、状态机或 XA/Seata。对贷记结果未知时不能盲目退款。真实系统应持久化 Saga 状态并确认结果后决定补偿。

## 运行

以下命令均在仓库根目录执行，需要 JDK 17+、Maven 3.9+。版本固定用于可复现学习，不代表最新版本。

```sh
mvn -pl distributed-transaction -am test
mvn -pl distributed-transaction exec:java
```

运行时自动检查关键结果，失败抛出异常；`mvn verify` 也会通过 JUnit 执行该示例。

## 参考

[相关文档](https://microservices.io/patterns/data/saga.html)
