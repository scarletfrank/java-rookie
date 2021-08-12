# README

## 简介

最近在研究`Zeppelin`，注意到了它除了前后端分离之外，还具有两套前端，并且用`maven`来统一编译。

这个项目是从[struts-example](https://github.com/apache/struts-examples)里发现的，`struts2`的文档里并没有对这个项目进行描述，`GitHub`里也没有相应的`README`。因此我把这个项目搬到我自己的库里，并进行了恰当的修改。主要集中在`pom.xml`，替换合适的`jetty`版本，添加缺少的参数。最后能访问成功。

这个项目的核心就是，前端已经用`AngularJS`编译打包好了，放入在`src/main/webapp`里，然后后端是`Strust2`加上`convention`插件，变成`RESTFul`的`API`。这样一来，这个项目就显得相对现代化了。后端与前端的开发都更加轻松（大概吧）

## 测试

```bash
mvn jetty:run -f pom.xml
# 访问 http://localhost:8080/rest-angular/
```

## 资料

1. [struts-examples](https://github.com/apache/struts-examples)
2. [rest-convention](https://struts.apache.org/plugins/rest/)

