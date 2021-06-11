# Spring Boot

## 项目介绍

Spring Initializer 生成的项目`bootdemo`，主要依赖为：

- Spring
- Spring Web
- Mybatis
- Postgres

## 各种包介绍

>  基本是Boot网站上[初级教程](https://spring.io/guides)，15到30分钟的那种。

```shell
# 启动项目
mvnw spring-boot:run
```

用自己本地的 mvn 替代`Spring Initializer`提供的 mvnw（查看`.gitignore`）

- consumingrest 读取一个 RESTful API
- swagger 包含若干个 RESTful API，并用 Swagger 包注释，自动生成接口文档页面


### schedule

> 用Spring自带的注解，实现定时任务。

### consumingrest

> A RESTful service has been stood up at `https://gturnquist-quoters.cfapps.io/api/random.` It randomly fetches quotations about Spring Boot and returns them as JSON documents.

这部分程序演示了如何处理 RESTful 服务，原本程序中又出现了一个 SpringBoot 的`main`方法，注释掉，放入`bootdemo`下即可，用`bootdemoApplication`管理全局，除了原有的`bean`加载，还加了一个`quote`的`GetMapping`，看`Swagger`文档还可以看到`Schema`说明。

### Swagger

由于用了 Swagger3 的 Boot 组装包，似乎不用写额外 Swagger 相关的配置了（真的够~~懒狗~~方便的）

```shell
# swagger 可视化界面
http://localhost:8080/swagger-ui/index.html
# v3 版本
http://localhost:8080/v3/api-docs
```

- [spring-boot-rest-service](https://spring.io/guides/gs/rest-service/)
- [swagger 与 boot 快速配置](https://itweknow.cn/blog-site/posts/2111459879.html)
