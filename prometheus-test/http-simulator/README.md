# Prometheus HTTP Metrics Simulator

模拟一个简单的HTTP微服务，生成Prometheus Metrics，可以Spring Boot方式运行

### Metrics

运行时访问端点：
```
http://SERVICE_URL:8080/prometheus

http://127.0.0.1:18088/actuator/prometheus
```

包括：
* `http_requests_total`：请求计数器，`endpoint`和`status`为label
* `http_request_duration_milliseconds`：请求延迟分布(histogram)

### 运行时options

#### Spike Mode

在Spike模式下，请求数会乘以一个因子(5~15)，延迟加倍

Spike模式可以是`on`, `off`或者`random`, 改变方式：

```
# ON
curl -X POST http://SERVICE_URL:8080/spike/on

# OFF
curl -X POST http://SERVICE_URL:8080/spike/off

# RANDOM
curl -X POST http://SERVICE_URL:8080/spike/random

```

#### Error rate

缺省错误率1%，可以调整(0~100)，方法：

```
# Setting error to 50%
curl -X POST http://SERVICE_URL:8080/error_rate/50

```

#### 其它参数

配置在`application.properties`中

```
opts.endpoints=/login, /login, /login, /login, /login, /login, /login, /users, /users, /users, /users/{id}, /register, /register, /logout, /logout, /logout, /logout
opts.request_rate=1000
opts.request_rate_uncertainty=70
opts.latency_min=10
opts.latency_p50=25
opts.latency_p90=150
opts.latency_p99=750
opts.latency_max=10000
opts.latency_uncertainty=70

opts.error_rate=1
opts.spike_start_chance=5
opts.spike_end_chance=30
```


运行时校验端点：
```
http://SERVICE_URL:8080/opts
```

### 参考

https://github.com/PierreVincent/prom-http-simulator









实验一、Prometheus起步查询实验
======

### 实验步骤

#### 1. 运行Prometheus HTTP Metrics Simulator

* 将[http-simulator](../http-simulator)导入Eclipse IDE
* Review代码理解模拟器原理
* 以Spring Boot方式运行模拟器
* 通过`http://localhost:8080/prometheus`查看metrics
* 通过Postman启用随机Spike模式

```
curl -X POST http://SERVICE_URL:8080/spike/random
```

#### 2. 安装运行Promethus

下载[Prometheus 2.22.2 for linux](https://github.com/prometheus/prometheus/releases/download/v2.22.2/prometheus-2.22.2.linux-amd64.tar.gz)，并解压到本地目录。

放到/home/ubuntu/software/prometheus 目录
解压 tar -zxvf prometheus-2.22.2.linux-amd64.tar.gz 到当前目录
vim /home/ubuntu/software/prometheus/prometheus.yml


调整全配置项
```yml

# my global config
global:
  scrape_interval:     5s # Set the scrape interval to every 5 seconds. Default is every 1 minute.
  scrape_timeout: 5s
  evaluation_interval: 5s # Evaluate rules every 5 seconds. The default is every 1 minute.

```

添加http-simulator Job配置项 

sudo vim /home/ubuntu/software/prometheus/prometheus.yml

```yml
# A scrape configuration containing exactly one endpoint to scrape:
# Here it's Prometheus itself.
scrape_configs:
  # The job name is added as a label `job=<job_name>` to any timeseries scraped from this config.
  - job_name: 'prometheus'

    # metrics_path defaults to '/metrics'
    # scheme defaults to 'http'.

    static_configs:
    - targets: ['localhost:9090']	
  - job_name: 'http-simulator'
    metrics_path: /prometheus
    static_configs:
    - targets: ['localhost:8080']

```

运行Prometheus
nohup 英文全称 no hang up（不挂起），用于在系统后台不挂断地运行命令，退出终端不会影响程序的运行。

```
nohup ./prometheus --config.file=prometheus.yml --web.listen-address=:9090 &
```

访问Prometheus Web UI
```
http://localhost:9090
```

通过`Status->Targets`，或者通过`Graph`查询
```
up
```
metric方式校验`prometheus`和`http-simulator`两个jobs在**UP**或**1**状态。

#### 3. 请求率(Request Rate)查询

校验http-simulator在**1**状态
```
up{job="http-simulator"}
```

查询http请求数
```
http_requests_total{job="http-simulator"}
```

查询成功login请求数
```
http_requests_total{job="http-simulator", status="200", endpoint="/login"}
```

查询成功请求数，以endpoint区分
```
http_requests_total{job="http-simulator", status="200"}
```

查询总成功请求数
```
sum(http_requests_total{job="http-simulator", status="200"})
```

查询成功请求率，以endpoint区分
```
rate(http_requests_total{job="http-simulator", status="200"}[5m])
```

查询总成功请求率
```
sum(rate(http_requests_total{job="http-simulator", status="200"}[5m]))
```

#### 4. 延迟分布(Latency distribution)查询

查询http-simulator延迟分布
```
http_request_duration_milliseconds_bucket{job="http-simulator"}
```

查询成功login延迟分布
```
http_request_duration_milliseconds_bucket{job="http-simulator", status="200", endpoint="/login"}
```

不超过200ms延迟的成功login请求占比
```
sum(http_request_duration_milliseconds_bucket{job="http-simulator", status="200", endpoint="/login", le="200.0"}) / sum(http_request_duration_milliseconds_count{job="http-simulator", status="200", endpoint="/login"})
```

成功login请求延迟的99百分位
```
histogram_quantile(0.99, rate(http_request_duration_milliseconds_bucket{job="http-simulator", status="200", endpoint="/login"}[5m]))
```



实验二、Prometheus+Grafana展示实验
======

### 实验步骤

#### 1. 先决条件

* 运行Prometheus HTTP Metrics Simulator
* 运行Prometheus服务器

#### 2. 安装运行Grafana
https://grafana.com/grafana/download

下载[Grafana 7.3.3 for ubuntu]
```
sudo apt-get install -y adduser libfontconfig1
wget https://dl.grafana.com/oss/release/grafana_7.3.3_amd64.deb
sudo dpkg -i grafana_7.3.3_amd64.deb
```
并解压到本地目录。

运行：
```
sudo service grafana-server start
sudo service grafana-server status
```

访问Granfa UI，使用缺省账号`admin/admin`登录
```
http://localhost:3000
```

添加Proemethes数据源

* Name -> prom-datasource
* Type -> Prometheus
* HTTP URL -> http://localhost:9090

其它缺省即可

**Save & Test**确保连接成功


#### 3. 创建一个Dashboard

点击**+**图标创建一个Dashbaord，点击**保存**图标保存Dashboard，使用缺省Folder，给Dashboard起名为`prom-demo`。

#### 4. 展示请求率

点击**Add panel**图标，点击**Graph**图标添加一个Graph，

点击Graph上的*Panel Title*->*Edit*进行编辑

修改Title：*General* -> Title = Request Rate

设置*Metrics*
```
sum(rate(http_requests_total{job="http-simulator"}[5m]))
```

调整*Lagend*

* 以表格展示*As Table*
* 显示*Min/Max/Avg/Current/Total*
* 根据需要调整*Axis*

注意保存Dahsboard。

#### 5. 展示实时错误率

点击**Add panel**图标，点击**Singlestat**图标添加一个Singlestat，

点击Graph上的*Panel Title->Edit*进行编辑

修改Title：*General* -> Title = Live Error Rate

设置*Metrics*
```
sum(rate(http_requests_total{job="http-simulator", status="500"}[5m])) / sum(rate(http_requests_total{job="http-simulator"}[5m]))
```

调整显示单位unit：*Options->Unit*，设置为*None->percent(0.0-1.0)*

调整显示值(目前为平均)为当前值(now)：*Options->Value->Stat*，设置为*Current*

添加阀值和颜色：*Options->Coloring*，选中*Value*，将*Threshold*设置为*0.01,0.05*，表示
* 绿色：0-1%
* 橙色：1-5%
* 红色：>5%

添加测量仪效果：*Options->Gauge*，选中*Show*，并将*Max*设为*1*

添加错误率演变曲线：选中*Spark lines -> Show*

注意保存Dahsboard。

#### 6. 展示Top requested端点

点击**Add panel**图标，点击**Table**图标添加一个Table，

设置*Metrics*
```
sum(rate(http_requests_total{job="http-simulator"}[5m])) by (endpoint)
```
减少表中数据项，在*Metrics*下，选中*Instant*只显示当前值

隐藏*Time*列，在*Column Sytle*下，*Apply to columns named*为*Time*，将*Type->Type*设置为*Hidden*

将*Value*列重命名，添加一个*Column Style*，*Apply to columns named*为*Value*，将*Column Header*设置为*Requests/s*

点击表中的*Requests/s* header，让其中数据根据端点活跃度进行排序。

注意调整Widget位置并保存Dahsboard。







## Kafka监控



1.下载kafka_exporter（机器需要与kafka集群相通）

wget https://github.com/danielqsj/kafka_exporter/releases/download/v1.2.0/kafka_exporter-1.2.0.linux-amd64.tar.gz

解压：

tar -zxvf kafka_exporter-1.2.0.linux-amd64.tar.gz 

更名，切到相应目录：  

mv kafka_exporter-1.2.0.linux-amd64 kafka_exporter

cd kafka_exporter

 ./kafka_exporter --kafka.server=kafkaIP或者域名:9092 & （只需填写kafka集群的一个ip即可）

**对应的服务端口为9308**



2.增加Prometheus配置

```
  - job_name: 'kafka_exporter'
    static_configs:
    - targets: ['localhost:9308']
```



3.grafana导入 7589





增加查询语句

```
sum(irate(kafka_topic_partition_current_offset{topic !~ "__consumer_offsets|__transaction_state|test",env="$env",app="$app"}[30s])) by (topic) >= 0
```

![img](README/20200113110250525.png)



```
sum(kafka_consumergroup_lag{env="$env",app="$app"})  by (topic,consumergroup)
```

![img](README/20200113110321270-1606189607958.png)



4.设置自启动

```
## 准备配置文件
cat <<\EOF >/etc/systemd/system/kafka_exporter.service
[Unit]
Description=Elasticsearch stats exporter for Prometheus
Documentation=Prometheus exporter for various metrics about ElasticSearch, written in Go.

[Service]
ExecStart=/usr/local/kafka_exporter/kafka_exporter --kafka.server=192.168.50.16:9092

[Install]
WantedBy=multi-user.target
EOF


## 启动并设置为开机自动启动
systemctl daemon-reload
systemctl enable kafka_exporter.service
systemctl stop kafka_exporter.service
systemctl start kafka_exporter.service
systemctl status kafka_exporter.service
```



- **Grafana仪表盘参考：**

1. https://grafana.com/grafana/dashboards/7589 （推介）
2. https://grafana.com/grafana/dashboards/9018 （参考-新的）
3. https://grafana.com/grafana/dashboards/9947（参考-新的）
4. https://grafana.com/grafana/dashboards/10973（JMX-阿里云）
5. https://www.menina.cn/article/88
6. https://cloud.tencent.com/developer/news/377416





## ES监控

1.安装elasticsearch_exporter

下载地址：https://github.com/justwatchcom/elasticsearch_exporter/releases



```
wget https://github.com/justwatchcom/elasticsearch_exporter/releases/download/v1.1.0/elasticsearch_exporter-1.1.0.linux-amd64.tar.gz
tar -xvf elasticsearch_exporter-1.1.0.linux-amd64.tar.gz
cd elasticsearch_exporter-1.1.0.linux-amd64/
```





2.启动

```
nohup ./elasticsearch_exporter --es.uri http://10.x.xx.100:9200 &

nohup ./elasticsearch_exporter --es.uri http://用户名:密码@10.x.xx.100:9200 &
```

```
## 参数说明：
--es.uri         　　　　默认http://localhost:9200，连接到的Elasticsearch节点的地址（主机和端口）。 这可以是本地节点（例如localhost：9200），也可以是远程Elasticsearch服务器的地址
--es.all                默认flase，如果为true，则查询群集中所有节点的统计信息，而不仅仅是查询我们连接到的节点。
--es.cluster_settings   默认flase，如果为true，请在统计信息中查询集群设置
--es.indices            默认flase，如果为true，则查询统计信息以获取集群中的所有索引。
--es.indices_settings   默认flase，如果为true，则查询集群中所有索引的设置统计信息。
--es.shards             默认flase，如果为true，则查询集群中所有索引的统计信息，包括分片级统计信息（意味着es.indices = true）。
--es.snapshots          默认flase，如果为true，则查询集群快照的统计信息。
```



nohup ./elasticsearch_exporter --es.all --es.indices --es.cluster_settings --es.indices_settings --es.shards --es.snapshots --es.timeout=10s --web.listen-address=":9114" --web.telemetry-path="/metrics" --es.uri http://10.xxx.xxx.10:9200 &





- 输入以下命令查看日志是否启动成功：

```
tail -1000f nohup.out
```



启动成功后，可以访问 [http://10.xx.xxx.100:9114/metrics/](http://10.0.101.100:9114/metrics/) ，看抓取的指标信息



https://www.cnblogs.com/caoweixiong/p/12156590.html







## 字定义监控

##### 实例化MeterRegistryCustomizer

```java
@SpringBootApplication
public class ClientmonitorApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientmonitorApplication.class, args);
	}

	@Bean
	MeterRegistryCustomizer<MeterRegistry> configurer(@Value("${spring.application.name}") String applicationName) {
		return (registry) -> registry.config().commonTags("application", applicationName);
	}
}
```



实现 MeterBinder 接口的 bindTo 方法，将要采集的指标注册到 MeterRegistry

```java
@Component
public class JobMetrics implements MeterBinder {
    public Counter job1Counter;
    public Counter job2Counter;

    public Map<String, Double> map;

    JobMetrics() {
        map = new HashMap<>();
    }

    @Override
    public void bindTo(MeterRegistry meterRegistry) {
         this.job1Counter = Counter.builder("counter_builder_job_counter1")
                .tags(new String[]{"name", "tag_job_counter1"})
                .description("description-Job counter1 execute count").register(meterRegistry);

        this.job2Counter = Counter.builder("counter_builder_job_counter2")
                .tags(new String[]{"name", "tag_job_counter2"})
                .description("description-Job counter2 execute count ").register(meterRegistry);

        Gauge.builder("gauge_builder_job_gauge", map, x -> x.get("x"))
                .tags("name", "tag_job_gauge")
                .description("description-Job gauge")
                .register(meterRegistry);
    }

}
```



##### 定时任务实现counter，gauge数据填充

```java
@Component
@EnableScheduling
public class MyJob {

    private Integer count1 = 0;

    private Integer count2 = 0;

    @Autowired
    private JobMetrics jobMetrics;

    @Async("main")
    @Scheduled(fixedDelay = 1000)
    public void doSomething() {
        count1++;
        jobMetrics.job1Counter.increment();
        jobMetrics.map.put("x", Double.valueOf(count1));
        System.out.println("task1 count:" + count1);
        if(count1%2==0){
            System.out.println("%5==0");
            jobMetrics.map.put("x", Double.valueOf(1));
        }

    }

    @Async
    @Scheduled(fixedDelay = 10000)
    public void doSomethingOther() {
        count2++;
        jobMetrics.job2Counter.increment();
        System.out.println("task2 count:" + count2);
    }
}
```





##### Controller 接口方式实现counter，gauge数据填充

```
@RestController
public class CounterController {
    @Autowired
    private JobMetrics jobMetrics;

    @RequestMapping(value = "/counter1", method= RequestMethod.GET)
    public void counter1() {
        jobMetrics.job2Counter.increment();
    }

    @RequestMapping(value = "/counter2", method= RequestMethod.GET)
    public void counter2() {
        jobMetrics.job2Counter.increment();
    }
    @RequestMapping(value = "/gauge", method= RequestMethod.GET)
    public void gauge(@RequestParam(value = "x") String x) {
        System.out.println("gauge controller x"+x);
        jobMetrics.map.put("x",Double.valueOf(x));
    }
}
```



注册方式







设置标签

registry.config().commonTags("stack", "prod", "region", "us-east-1");

registry.config().commonTags(Arrays.asList(Tag.of("stack", "prod"), Tag.of("region", "us-east-1"))); 

















# 问题解决

启动问题：
level=error ts=2018-11-19T06:01:05.697957445Z caller=main.go:625 
err="opening storage failed: lock DB directory: resource temporarily unavailable

解决：删除 lock 文件
rm -f /home/ubuntu/software/prometheus/data/lock



## 1.micrometer-registry-prometheus 1.1.4

```
<dependency>
  <groupId>io.micrometer</groupId>
  <artifactId>micrometer-registry-prometheus</artifactId>
  <version>1.1.4</version>
</dependency>
```



Caused by: java.lang.NoSuchMethodError: io.micrometer.core.instrument.MeterRegistry$Config.onMeterRemoved(Ljava/util/function/Consumer;)Lio/micrometer/core/instrument/MeterRegistry$Config;





## 2.

Failed to introspect Class [org.springframework.boot.actuate.autoconfigure.metrics.export.prometheus.PrometheusPropertiesConfigAdapter] from ClassLoader [sun.misc.Launcher$AppClassLoader@18b4aac2]





## 3. 官方提供的simpleclient_spring_boot这个starter在springboot2.0中不支持

Caused by: java.lang.ClassNotFoundException: org.springframework.boot.actuate.endpoint.AbstractEndpoint
at [java.net](http://java.net/).URLClassLoader.findClass(URLClassLoader.java:382) ~[na:1.8.0_201]
at java.lang.ClassLoader.loadClass(ClassLoader.java:424) ~[na:1.8.0_201]
at sun.misc.Launcher$AppClassLoader.loadClass(Launcher.java:349) ~[na:1.8.0_201]
at java.lang.ClassLoader.loadClass(ClassLoader.java:357) ~[na:1.8.0_201]



https://github.com/prometheus/client_java/issues/345





## 4.加密

https://blog.csdn.net/singgel/article/details/101120430

### 安全认证

--------该部分不需要，直接由NGINX层面完成-----------

以下是在项目中添加security安全依赖，也可以使用系统自己的安全认证

配置pom.xml

```html
<dependency>
 <groupId>org.springframework.boot</groupId>
 <artifactId>spring-boot-starter-security</artifactId>
</dependency> 
```

配置application.xml

```
## security认证配置
  security:
    user:
      name: monitor
      password: monitor123
```

配置prometheus.xml

```
……
scrape_configs:
# job name 这个配置是表示在这个配置内的时间序例，每一条都会自动添加上这个{job_name:"redis-manage"}的标签。
  - job_name: 'redis-manager'
    # metrics_path defaults to '/actuator/prometheus'
    # scheme defaults to 'http'.
    # 重写了全局抓取间隔时间，由15秒重写成5秒。
    metrics_path: /xueqiu/prometheus
    scrape_interval: 5s
    scheme: http
    basic_auth:
      username: admin
      password: admin
    static_configs:
      - targets: ['192.168.64.51:8099']
……
```

