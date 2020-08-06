#

### 架构分层简介
|名称|定义|端口|workerId|
|:----: |:----:|:----:|:----:|
|common|公共类|||
|model|实体|||
|dao|后台服务数据交互|||
|admin|监控服务|30000||
|gateway|网关|40000||
|api|负载均衡|41000||
|system|后台服务|42000|0|

* 使用分布式id生成需配置workerId和datacenterId，需保证每个服务workerId和datacenterId组合均不一致，docker容器初始化时workerId为默认设置，datacenterId则根据端口号生成，如40001的datacenterId即为1，以此规则命名

### Docker环境搭建
|应用|获取|运行|
|:----:|:-----|:-----|
|redis|docker pull redis|docker run --restart=always -d --name redis -p 6379:6379 -v /etc/localtime:/etc/localtime redis redis-server --appendonly yes --requirepass "admin"|
|minio|docker pull minio/minio|docker run --restart=always --name minio -d -p 9000:9000 -e "MINIO_ACCESS_KEY=admin" -e "MINIO_SECRET_KEY=12345678" -v /mnt/data:/data -v /mnt/config:/root/.minio minio/minio server /data|
|zookeeper | docker pull wurstmeister/zookeeper | docker run --restart=always -d --name zookeeper -p 2181:2181 wurstmeister/zookeeper |
|kafka | docker pull wurstmeister/kafka | docker run -d --name kafka -p 9092:9092 --link zookeeper --env KAFKA_ZOOKEEPER_CONNECT=zookeeper:2181 -e KAFKA_ADVERTISED_HOST_NAME=localhost -e KAFKA_ADVERTISED_PORT=9092 -v /etc/localtime:/etc/localtime wurstmeister/kafka |
|nacos|docker pull nacos/nacos-server|docker run --restart=always -d --name nacos -p 8848:8848 --restart=always -v MODE=standalone -e SPRING_DATASOURCE_PLATFORM=mysql -e MYSQL_SERVICE_HOST=IP地址 -e MYSQL_SERVICE_PORT=端口 -e MYSQL_SERVICE_USER=用户名 -e MYSQL_SERVICE_PASSWORD=密码 -e MYSQL_SERVICE_DB_NAME=数据库名称 nacos/nacos-server|

* 生产环境IDEA链接Docker开放端口2375请配置好ca证书
* localhost可替换为服务器IP地址

### 预设初始账号密码
* redis 
  >密码:
* Spring Boot Admin
  >账号:admin
  >密码:admin
* minio
  >账号:admin
  >密码:12345678
  
 ### 相关环境及技术栈
 * JDK：Java 8
 * 容器化部署工具：Docker
 * 数据库：MySQL
 * 服务框架：Spring Cloud,Spring Boot
 * 监控组件：Spring Boot Admin
 * 网关组件：Gateway
 * 容错组件：Hystrix
 * 服务调用组件：Feign
 * 负载均衡组件：Ribbon
 * 服务注册与配置中心组件：Nacos
 * 缓存：Redis
 * 消息队列：Kafka
 * 协调服务：Zookeeper
 * 定时任务：Quartz,Schedule
 * 文件服务：Minio
 * Excel文件处理：AutoPOI
 * 鉴权框架：Shiro+JWT
 * Mybatis插件：Mybatis Plus,PageHelper
 * 接口文档框架：Swagger 2
 * JDBC组件：Druid 
