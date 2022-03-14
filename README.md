
### Microservice em Java Spring Boot com RabbitMQ

Este projeto é a criação de um microserviço reponsável por receber requisições e gerar mensagens
para os demais microsserviços, que são os consumidores da mensagem.

Dividido em 3 projetos:

1. `estoque-api` = Cria as filas e envia as mensagens ao servidor RabbitMQ
2. `estoque-core` =  contém os nomes das constantes e DTOs 
3. `estoque-consumer` = consome as mensagens (processa)

Opcional:

- Prefecth Count do RabbitMQ.
- Interceptor de exceções.



![Projeto](https://github.com/juan-souza/microservice-estoque-rabbitmq/blob/master/doc/microservice-rabbitmq.png)

#### Documentos

- [Spring Cloud](https://spring.io/projects/spring-cloud)
- [Spring AMQP](https://docs.spring.io/spring-amqp/docs/current/reference/html/)
- [RabbitMQ](https://www.rabbitmq.com/documentation.html)

#### Notes

- Baseando no curso do [Danilo Canesch](https://github.com/DaniloCaneschi).

