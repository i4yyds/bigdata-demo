# 运维数据平台项目

## 准备

mysql

```bash
安装
docker pull mysql:5.7
docker run -itd --name mysql3306 -p 3306:3306 -e MYSQL_ROOT_PASSWORD=yyds mysql:5.7
使用
docker exec -it mysql3306 bash
修改/etc/my.cnf
[mysqld]
default-time-zone = 'Asia/Shanghai'
log-bin=mysql-bin
server-id=1
mysql -u root -p
建库表
create database monitor;
create table port_strategy
(
    id       int auto_increment primary key,
    cloud_id int         null,
    ip       varchar(20) null,
    port     varchar(20) null
);
```

kafka

```bash
安装
docker pull wurstmeister/zookeeper  
docker pull wurstmeister/kafka  
docker run -d --name zookeeper -p 2181:2181 -t wurstmeister/zookeeper
docker run  -d --name kafka9092 -p 9092:9092 -e KAFKA_BROKER_ID=0 -e KAFKA_ZOOKEEPER_CONNECT=192.168.200.193:2181 -e KAFKA_ADVERTISED_LISTENERS=PLAINTEXT://192.168.200.193:9092 -e KAFKA_LISTENERS=PLAINTEXT://0.0.0.0:9092 -t wurstmeister/kafka
docker run  -d --name kafka9093 -p 9093:9093 -e KAFKA_BROKER_ID=1 -e KAFKA_ZOOKEEPER_CONNECT=192.168.200.193:2181 -e KAFKA_ADVERTISED_LISTENERS=PLAINTEXT://192.168.200.193:9093 -e KAFKA_LISTENERS=PLAINTEXT://0.0.0.0:9093 -t wurstmeister/kafka
docker run  -d --name kafka9094 -p 9094:9094 -e KAFKA_BROKER_ID=2 -e KAFKA_ZOOKEEPER_CONNECT=192.168.200.193:2181 -e KAFKA_ADVERTISED_LISTENERS=PLAINTEXT://192.168.200.193:9094 -e KAFKA_LISTENERS=PLAINTEXT://0.0.0.0:9094 -t wurstmeister/kafka
使用
docker exec -it kafka9092 /bin/bash
查询
kafka-topics.sh --bootstrap-server 192.168.200.193:9092 --list
删除
kafka-topics.sh --delete --zookeeper 192.168.200.193:2181 --topic topic_port_strategy
新增
kafka-topics.sh --create --zookeeper 192.168.200.193:2181 --replication-factor 2 --partitions 1 --topic topic_port_strategy
消费
kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic topic_port_strategy --from-beginning
```

hbase

```bash
安装
docker pull harisekhon/hbase
docker run -d -p 8080:8080 -p 8085:8085 -p 9090:9090 -p 9095:9095 -p 16000:16000 -p 16010:16010 -p 16201:16201 -p 16301:16301  -p 16030:16030 -p 16020:16020 --name hbase harisekhon/hbase
使用
hbase shell
create_namespace "monitor"
list_namespace
list_namespace_tables "monitor"
```

## 安装

描述如何安装和配置项目。

```bash
# 克隆仓库
git clone https://github.com/yourusername/yourproject.git

# 进入项目目录
cd yourproject

# 安装依赖
npm install
```

## 使用方法

简单描述如何使用项目。

```bash
# 启动项目
npm start
```

## 示例

提供一些使用项目的示例代码或截图。

```go
package main

import "fmt"

func main() {
    fmt.Println("Hello, World!")
}
```

## 贡献

欢迎贡献！请阅读 [CONTRIBUTING.md](CONTRIBUTING.md) 了解详细信息。

## 联系信息

如果有任何问题或建议，请联系 [yourname@example.com](mailto:yourname@example.com)。