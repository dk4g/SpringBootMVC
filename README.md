# SpringBoot MVC
### Spring MVC Application using Spring Boot with PostgreSQL, Thymeleaf and REST API

This SpringMVC application is built using Spring Boot. The Spring Boot takes care of bootstrapping our 
application. We use Thymeleaf templating engine for the prupose of server side redering of UI and use 
PostgreSQL as database.
The application also exposes a REST API.

We start with creating a POM file and adding a parent POM and following dependencies into it.

```xml
<parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-parent</artifactId>
    <version>2.2.2.RELEASE</version>
    <relativePath/>
</parent>

<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>

<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>

<dependency>
    <groupId>org.postgresql</groupId>
    <artifactId>postgresql</artifactId>
    <scope>runtime</scope>
</dependency>

<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-thymeleaf</artifactId>
</dependency>
```
Next we need to define some of the properties like PostgreSQL server details for our project in the 
`application.properties` file.

```properties
server.port = 8081
spring.h2.console.enabled=true
management.endpoints.web.exposure.include=*

#Switch off automatic schema creation by Hibernate as we use a schema.sql file
spring.jpa.hibernate.ddl-auto=none
spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.PostgreSQLDialect
#show sql queries in the log
spring.jpa.show-sql=true

#required to prevent an error SQLFeatureNotSupportedException: Method org.postgresql.jdbc.PgConnection.createClob()
spring.jpa.properties.hibernate.jdbc.lob.non_contextual_creation=true

#if initialization-mode is 'always' then schema.sql and data.sql will be executed. If it is 'never' then they are not executed
spring.datasource.initialization-mode=always
spring.datasource.platform=postgres
spring.datasource.url=jdbc:postgresql://localhost:5432/test_db
spring.datasource.username=postgres
spring.datasource.password=postgres

```

To initialize our db schema we use a `schema.sql` file in `src/main/resources` folder. 
To bootstrap some data in the database we can also use a `data.sql` script if needed.

Run the app using `mvn spring-boot:run`.