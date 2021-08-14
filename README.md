# java-rookie

## 项目列表

- [x] bootdemo: SpringBoot为主体的网络应用，用于新项目。配置了`Swagger`

- [x] struts2.demo Struts2的学习，用于老项目的维护 `2.5.26`
  
    为了和新的文档兼容，采用了`blank-archtype`来快速上手。为了和这个框架配合，似乎只能使用`Swagger4j`，在另一个[repo](https://github.com/FrankScarlet/swagger-demo-struts2)里。

- [x] quartz.demo：定时任务框架学习
- [x] rest-angular: `strust2-rest-convention`作为后端，`angular`作为前端
- [x] solution-mvn: LeetCode Java题解
- [ ] Apache Dubbo 微服务学习


## 吐槽

### Java EE 的历史

- 1999 `J2EE`, Java 2 Platform Enterprise Edition
- 2006 `J2EE`, rename to `Java EE` or Java Platform Enterprise Edition
- 2017 Oracle把`Java EE`的一些权利给了`Eclipse`基金会，Oracle依然持有本语言`Java`。`Eclipse`为了避免和`Oracle`的`Java`冲突，进行`Java EE`的改名。由社区投票，最后形成了`Jakarta EE`

> maven-archetype-quickstart的版本为1.7，按照之前看的视频，1.7的策略是默认加载全部包。有时一些项目，用了新的JDK，会提示Java EE的API缺失。

对于`Eclipse`来说，给`Jakarta EE`添加标准是一个新的流程。`a specification, a reference implementation, and tests`

1. `JCP`, Java Community Process. `EFSP`, Eclipse Foundation Specification Process.
2. `JSR`, Java Specification Request. Time showed that an implementation-first approach tended to create more widely-accepted features and APIs.
3. `Glassfish`
4. `TCK`, Technology Compatibility Kit, or TCK.

### 技术发展

有些框架比我还老。引用项目`swagger-demo-struts2`里的想法，稍微研究一下`struts2-swagger`和`struts2-restful`。学习主攻`springboot`吧，进一步把前后端分离开。

