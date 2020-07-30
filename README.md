# Read Me First

The following was discovered as part of building this project:

# Getting Started

### Reference Documentation

For further reference, please consider the following sections:

- [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
- [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.3.2.RELEASE/maven-plugin/reference/html/)
- [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.3.2.RELEASE/maven-plugin/reference/html/#build-image)
- [Validation](https://docs.spring.io/spring-boot/docs/2.3.2.RELEASE/reference/htmlsingle/#boot-features-validation)
- [Spring Web](https://docs.spring.io/spring-boot/docs/2.3.2.RELEASE/reference/htmlsingle/#boot-features-developing-web-applications)
- [Spring Data Redis (Access+Driver)](https://docs.spring.io/spring-boot/docs/2.3.2.RELEASE/reference/htmlsingle/#boot-features-redis)

### Guides

The following guides illustrate how to use some features concretely:

- [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
- [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
- [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)
- [Messaging with Redis](https://spring.io/guides/gs/messaging-redis/)

### External dependencies/configurations

- Redis
- Kafka

### Redis startup

`docker run -it --name redis -p 6379:6379 redis:5.0.3`

##### Monitoring redis

`redis-cli monitor` : activities
`KEYS *` : list keys

### Kafka startup

- For local setup follow the official [notes](https://kafka.apache.org/quickstart)
- For doker follow [this](https://docs.confluent.io/current/quickstart/ce-docker-quickstart.html)

### Starting

- In project root enter `mvn spring-boot:run`
- Open a browser and go to http://localhost:3000/ ,this is a monitor view that exposes all results from conversions using the API.
- Open a new tab and copy the address http://localhost:3000/api/converter/USD/DKK/1/30/07/2020 to test a request.After look at the first tab to see the response there too!

The API pattern to service: http://localhost:3000/api/converter/[currency code from]/[currency code to]/1/\[day]/\[month]/\[year]
All currency codes suported are mapped in `application.properties` through property `converter.currency-codes`.
