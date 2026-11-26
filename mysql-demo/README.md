# mysql-demo

真实 MySQL JDBC、参数绑定、事务与条件扣减。

## 代码入口

[src/main/java/learning/Demo.java](src/main/java/learning/Demo.java)

## 示例行为与边界

需要 MySQL；默认连接 learning 数据库。只操作带 UUID 的演示行，结束时删除该行，保留 learning_account 表。DDL 在事务开始前执行，避免 MySQL DDL 隐式提交干扰回滚。

## 运行

以下命令均在仓库根目录执行，需要 JDK 17+、Maven 3.9+。版本固定用于可复现学习，不代表最新版本。

```sh
docker compose --profile mysql up -d --wait --wait-timeout 180
```

```sh
mvn -pl mysql-demo -am test
mvn -pl mysql-demo exec:java
```

成功时最后输出 `PASS`；连接失败会明确抛错，不会切换到内存模拟。默认 `mvn verify` 只编译此模块，不连接外部服务。

## 环境变量

| 变量 | 默认值 |
| --- | --- |
| `MYSQL_URL` | `jdbc:mysql://localhost:3306/learning?connectTimeout=5000&socketTimeout=5000` |
| `MYSQL_USER` | `learner` |
| `MYSQL_PASSWORD` | `learning-local` |

通过终端环境变量覆盖；不要将自己的密码提交到仓库。

结束后可运行 `docker compose --profile mysql down`。Compose 的端口只绑定本机，演示账号和开发鉴权配置仅供本地学习。

## 参考

[相关文档](https://dev.mysql.com/doc/connector-j/en/connector-j-usagenotes-statements.html)
