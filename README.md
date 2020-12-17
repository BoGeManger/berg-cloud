#Spring Cloud示例项目

### 架构分层简介
|名称|定义|端口|workerId|
|:----: |:----:|:----:|:----:|
|common|公共|||
|model|实体|||
|dao|后台服务数据交互|||
|manager|公共服务应用|||
|admin|监控服务|30000||
|gateway|网关|40000|0|
|system|后台服务|41000|1|

* 使用分布式id生成需配置workerId和datacenterId，需保证每个服务workerId和datacenterId组合均不一致，docker容器初始化时workerId为默认设置，datacenterId则根据端口号生成，如40001的datacenterId即为1，以此规则命名

### Docker环境搭建
|应用|获取|运行|
|:----:|:-----|:-----|
|redis|docker pull redis|docker run --restart=always -d --name redis -p 6379:6379 -v /etc/localtime:/etc/localtime redis redis-server --appendonly yes --requirepass "密码"|
|minio|docker pull minio/minio|docker run --restart=always --name minio -d -p 9000:9000 -e "MINIO_ACCESS_KEY=账号" -e "MINIO_SECRET_KEY=密码" -v /mnt/data:/data -v /mnt/config:/root/.minio minio/minio server /data|
|zookeeper |docker pull wurstmeister/zookeeper | docker run --restart=always -d --name zookeeper -p 2181:2181 wurstmeister/zookeeper |
|kafka |docker pull wurstmeister/kafka | docker run -d --name kafka -p 9092:9092 --link zookeeper --env KAFKA_ZOOKEEPER_CONNECT=zookeeper:2181 -e KAFKA_ADVERTISED_HOST_NAME=IP地址(服务器为内网) -e KAFKA_ADVERTISED_PORT=9092 -v /etc/localtime:/etc/localtime wurstmeister/kafka |
|nacos|docker pull nacos/nacos-server:1.3.0|docker run --restart=always -d --name nacos -p 8848:8848 -e MODE=standalone -e SPRING_DATASOURCE_PLATFORM=mysql -e MYSQL_SERVICE_HOST=IP地址 -e MYSQL_SERVICE_PORT=端口 -e MYSQL_SERVICE_USER=用户名 -e MYSQL_SERVICE_PASSWORD=密码 -e MYSQL_SERVICE_DB_NAME=数据库名称 nacos/nacos-server:1.3.0|
|xxl-job-admin|docker pull xuxueli/xxl-job-admin:2.2.0|docker run --restart=always -d --name xxl-job-admin  -p 8080:8080 -v /tmp:/data/applogs -e PARAMS="--spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver --spring.datasource.url=jdbc:mysql://IP地址:端口号/xxl_job?useUnicode=true&characterEncoding=UTF-8&autoReconnect=true&serverTimezone=Asia/Shanghai --spring.datasource.username=数据库账号 --spring.datasource.password=数据库密码  --xxl.job.login.username=登录账号  --xxl.job.login.password=登录密码" xuxueli/xxl-job-admin:2.2.0|
|seata |docker pull seataio/seata-server | docker run --restart=always -d --name seata -p 8091:8091 seataio/seata-server |

* 生产环境IDEA链接Docker开放端口2375请配置好ca证书
* docker run添加--cap-add=SYS_PTRACE参数解决无法使用JVM命令问题

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
 * 定时任务：xxl-job
 * 分布式事务：Seata
 * 文件服务：Minio
 * Excel文件处理：AutoPOI
 * 鉴权框架：Shiro+JWT
 * Mybatis插件：Mybatis Plus,PageHelper,dynamic datasource
 * 接口文档框架：Swagger 2
 * JDBC组件：Druid 
 * 公共工具：Hutool 
 * 验证框架：Hibernate Validator
 
 ### api使用
 ```
feign:
  hystrix:
    enabled: true

hystrix:
  command:
    default:
      execution:
        timeout:
          enabled: true
        isolation:
          thread:
            timeoutInMilliseconds: 700000
            
ribbon:
  ReadTimeout: 300000
  ConnectTimeout: 300000
  MaxAutoRetries: 0
  MaxAutoRetriesNextServer: 0
  eureka:
     enabled: false
```