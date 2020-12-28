# Spring Boot

## 项目介绍

Spring Initializer生成的项目，主要依赖为：

- Spring
- Spring Web
- Mybatis
- Postgres

## 运行

原本是用项目提供的mvnw的（已经被ignore，可以查看`.gitignore`），我用自己本地的mvn。

```shell
mvnw spring-boot:run
```

### Swagger

由于用了Swagger3的Boot组装包，所以直接也不用写Swagger相关的配置了（真的够懒狗的），默认地址为：

```shell
# swagger 可视化界面
http://localhost:8080/swagger-ui/index.html
# v3 版本
http://localhost:8080/v3/api-docs
```

## 参考资料

1. [swagger与boot快速配置](https://itweknow.cn/blog-site/posts/2111459879.html)