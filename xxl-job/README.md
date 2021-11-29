# xxl-job

## 简介

1. `xxl-job`的定时任务用`SpringBoot`写比较自然
2. 如果用`xxl-job`替代网站里的`Quartz`式的任务，似乎也更加方便


## job 类型

> 参考 SampleXxlJob.java 

- demoJobHandler: hello world
- httpJobHandler: HTTP任务

## compose

### docker-compose.yml

写了一个理想的情况，但是`xxl-job-admin`容器连接数据库的时候一直会有错误，错误跟[这个issue](https://github.com/xuxueli/xxl-job/issues/2544)一样

```bash
# 单独运行
docker run -e PARAMS="--spring.datasource.url=jdbc:mysql://127.0.0.1:3306/xxl_job?useUnicode=true&characterEncoding=UTF-8&autoReconnect=true&serverTimezone=Asia/Shanghai" -p 8080:8080 -v /tmp:/data/applogs --name xxl-job-admin  -d xuxueli/xxl-job-admin:2.3.0
```

...试了一下，原来必须用PARAMS写法，其他方式都不太行。感觉应该跟`admin`镜像的打包方式有关，`2.2.0`的时候还正常的，`2.3.0`就不行了。这样的坏处就在于数据库连接信息全写在`docker-compose.yml`里了。

### mysql数据库初始化步骤


```bash
docker cp tables_xxl_job.sql xxl-job_xxl-db_1:/root/ # 似乎Win10下这个命令会报错
mysql -u xxl -p xxljob
source /root/tables_xxl_job.sql
```

### 顺带一提

1. 同事用2.2.0的源码，改了一个支持Oracle的，我以它为admin镜像，然后用类似`.admin.env`写法，此时只要把`Docker Desktop`的`V2`选项去掉就行。
2. 踩坑文章`3`的`links`我也试了一下，感觉不行。而且从`compose`的角度来看，应该不需要额外加`links`。比如说我写`xxl-job`的时候，用`xxl-admin:8180`的写法就是okay的。


## 其他踩坑文章

1. [compose部署2.3.0](https://github.com/xuxueli/xxl-job/issues/2342)
2. [nested exception is java.sql.SQLNonTransientConnectionException](https://github.com/xuxueli/xxl-job/issues/2544)
3. [Docker：容器化运行xxl-job-admin](https://blog.csdn.net/sageyin/article/details/120953638?spm=1001.2014.3001.5501)
4. [xxl-job](https://www.xuxueli.com/xxl-job/)