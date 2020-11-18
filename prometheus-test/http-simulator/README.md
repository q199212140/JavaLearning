# Prometheus HTTP Metrics Simulator

模拟一个简单的HTTP微服务，生成Prometheus Metrics，可以Spring Boot方式运行

### Metrics

运行时访问端点：
```
http://SERVICE_URL:8080/prometheus
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









# 问题解决
启动问题：
level=error ts=2018-11-19T06:01:05.697957445Z caller=main.go:625 
err="opening storage failed: lock DB directory: resource temporarily unavailable
 
解决：删除 lock 文件
rm -f /home/ubuntu/software/prometheus/data/lock