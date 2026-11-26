# mybatis-plus-demo

BaseMapper CRUD、条件查询、提交与回滚。

## 代码入口

[src/main/java/learning/Demo.java](src/main/java/learning/Demo.java)

## 示例行为与边界

默认使用 H2，直接启动，无需 MySQL。实体和 Mapper 为 Demo.java 的嵌套公开类型，便于跟读。SQL 会话默认不自动提交；显示验证 rollback 后数据仍存在。

## 运行

以下命令均在仓库根目录执行，需要 JDK 17+、Maven 3.9+。版本固定用于可复现学习，不代表最新版本。

```sh
mvn -pl mybatis-plus-demo -am test
mvn -pl mybatis-plus-demo exec:java
```

运行时自动检查关键结果，失败抛出异常；`mvn verify` 也会通过 JUnit 执行该示例。

## 参考

[相关文档](https://baomidou.com/en/guides/data-interface/)
