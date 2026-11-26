# elasticsearch-demo

真实 REST API：建索引、写入、搜索、更新和删除。

## 代码入口

[src/main/java/learning/Demo.java](src/main/java/learning/Demo.java)

## 示例行为与边界

需要 Elasticsearch 8.x。JDK HttpClient 发 HTTP 请求，Jackson 验证命中数，refresh=wait_for 避免写后立刻搜索不可见。创建并清理唯一 learning-demo-* 索引，非内存搜索模拟。

## 运行

以下命令均在仓库根目录执行，需要 JDK 17+、Maven 3.9+。版本固定用于可复现学习，不代表最新版本。

```sh
docker compose --profile elasticsearch up -d --wait --wait-timeout 180
```

```sh
mvn -pl elasticsearch-demo -am test
mvn -pl elasticsearch-demo exec:java
```

成功时最后输出 `PASS`；连接失败会明确抛错，不会切换到内存模拟。默认 `mvn verify` 只编译此模块，不连接外部服务。

## 环境变量

| 变量 | 默认值 |
| --- | --- |
| `ES_URL` | `http://localhost:9200` |
| `ES_API_KEY` | `未设置；启用鉴权的集群需提供 API key` |

通过终端环境变量覆盖；不要将自己的密码提交到仓库。

结束后可运行 `docker compose --profile elasticsearch down`。Compose 的端口只绑定本机，演示账号和开发鉴权配置仅供本地学习。

## 参考

[相关文档](https://www.elastic.co/docs/reference/elasticsearch/rest-apis/refresh-parameter)
