# nacos-demo

Nacos Java SDK 配置发布/读取、服务注册/发现/注销。

## 代码入口

[src/main/java/learning/Demo.java](src/main/java/learning/Demo.java)

## 示例行为与边界

需要 Nacos 2.5.x，开放 8848 和客户端 gRPC 9848。唯一 dataId/serviceName，只清理本次生成的配置和实例。127.0.0.1:18080 是演示注册元数据，没有启动业务 HTTP 服务，不演示实际远程调用或配置监听。

## 运行

以下命令均在仓库根目录执行，需要 JDK 17+、Maven 3.9+。版本固定用于可复现学习，不代表最新版本。

```sh
docker compose --profile nacos up -d --wait --wait-timeout 180
```

```sh
mvn -pl nacos-demo -am test
mvn -pl nacos-demo exec:java
```

成功时最后输出 `PASS`；连接失败会明确抛错，不会切换到内存模拟。默认 `mvn verify` 只编译此模块，不连接外部服务。

## 环境变量

| 变量 | 默认值 |
| --- | --- |
| `NACOS_ADDR` | `localhost:8848` |
| `NACOS_USERNAME` | `未设置` |
| `NACOS_PASSWORD` | `未设置` |
| `NACOS_NAMESPACE` | `未设置（public）` |

通过终端环境变量覆盖；不要将自己的密码提交到仓库。

结束后可运行 `docker compose --profile nacos down`。Compose 的端口只绑定本机，演示账号和开发鉴权配置仅供本地学习。

## 参考

[相关文档](https://nacos.io/en-us/docs/sdk.html)
