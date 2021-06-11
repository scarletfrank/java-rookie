# README

## 快速入手


### Run the Application

The `main()` method starts that process by creating a Spring application context. This starts the message listener container, which starts listening for messages. There is a `Runner` bean, which is then automatically run. It retrieves the `RabbitTemplate` from the application context and sends a `Hello from RabbitMQ!` message on the `spring-boot` queue. Finally, it closes the Spring application context, and the application ends.



## RabbitMQ

