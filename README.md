<<<<<<< Updated upstream
<img width="686" height="386" alt="image" src="https://github.com/user-attachments/assets/0bbd7ce8-82ee-49b6-bfcf-04cefbaecc6d" />
=======
**Spring Boot**
- Spring Boot is a framework for building applications in the Java programming language.
- Spring Boot makes it easy to create stand-alone, production-grade Spring based Applications that you can just run.
- However, Spring Boot takes this convenience to the next level by focusing specifically on reducing the effort required to set up and configure a Spring Appication.

**While Spring does simplify many tasks like**
- Creating web applications
- Working with databses, 
- managing transactions and more.
- But setting up a Spring project can still involve quite a bit of manual configuration. This is where Spring Boot steps in.
- Auto-Configuration, Standalone Applications.
- We need to manually set up the Spring application context in the main method.
- We use the @SpringBootApplication annotation on the main class. This single annotation replaces the need for setting up a manual Spring application context.
- We no longer need to explicitly create an applicaiton context using AnnotationConfigApplicationContext as Sprign Boot handles that behind the scenes.
- We use SpringApplication.run() to start the application, and Spring Boot takes care of configuring the embedded web server and other necessary components.
- The @SpringBootApplication annotation alone brings in a lot of pre-configured features, including automatic componenet scanning and embedded server configuration, which would have required more steps in a traditional Spring setup.

**What is Application Context?**
- Application context is a way to implement IOC Container.

**What is @SpringBootApplication?**
- @Configuration
- @EnableAutoConfiguration
- @ComponentScan

**What is REST API?**
- Representational State Transfer
- Application Programming Interfaces

**What is 4 HTTP verb?**
- GET 
- PUT 
- POST 
- DELETE

**What is Controller?**
- Special type of classes/componenets.

**What is ORM?**
- ORM is a technique used to map Java objects to database tables. 
- It allows developers to work with databases using object-oriented programming concepts, making it easier to interact with relational databases. 
- Consider a Java class User and a database table users. 
- ORM frameworks like Hibernate can map the fields in the User class to columns in the suers table, making it easier to insert, update, retrieve, and delete records.


**What is JPA?**
- A way to achieve ORM, includes interfaces and annotations that you use in your Java classes, requires a persistence provider(ORM tools) for implementation.

**What is Persistence Provider / ORM tools?**
- To use JPA, you need a persistence provider. A persistence provider is a specific implementation of the JPA specidfication. Examples of JPA persistence providers include Hibernate, EcliplseLink, and OpenJPA. These providers implement the JPA interfaces and provide the underlying functionality to interact with databases. 

**What is Spring Data JPA?**
- Spring Data JPA is built on top of the JPA(Java Persistence API) specification, but it is not a JPA implementation itself. Instead, it simplifeis workign with JPA by providing higher-level abstractions and utilities. However, to use Spring Data JPA effectively, you still need a JPA implementation, such as Hibernate, EclipseLInk, or another JPA-compliant provider, to handle the actual database interactions. 


JPA is primarily designed for working with relational databses, where data is stored in tables with a predefined schema. MongoDB, on the other hand, is a NoSQL database that uses a different data model, typically based on collections of documents, which are schema-less or have flexible schemas. This fundamental difference in data models and storage structures is why JPA is not used with MongoDB. 

In the case of MongoDB, you don't have a traditional JPA persistence provider. MongoDB is a NoSQL database, and Spring Data MongoDB serves as the "persistence provider" for MongoDB. It provides the necessary abstractions and implementations to work with MongoDB in a Spring application.

- **Query Method DSL** and **Criteria API** are two different ways to interact with a database when using Spring Data JPA for relational databases and Spring Data MongoDB for MongoDB databses. 
- Spring Data JPA is a part of the Spring Framework that simplifies data access in Java applications, while Spring Data MongoDB provides similar functionality for MongoDB.
- **Query Method DSL** is a simple and convenient way to create queries based on method naming conventions, while the **Criteria API** offers a more dynamic and programmatic approach for building complex and custom queries.

>>>>>>> Stashed changes
