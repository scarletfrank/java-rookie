# README

## 快速开始

Run `mvn clean compile` first to call protobuf to generate the Dubbo customized Java stubs before run any samples.

```bash
mvn clean compile
mvn clean package
java -jar ./protobuf-provider/target/protobuf-provider-1.0-SNAPSHOT.jar 
java -jar ./protobuf-consumer/target/protobuf-consumer-1.0-SNAPSHOT.jar 
```


## 资料

1. [dubbo-quick-start](https://dubbo.apache.org/zh/docs/languages/java/quick-start/)
2. [dubbo-sample](https://github.com/apache/dubbo-samples)