## Library Status Dashboard

This project consists of two main microservices for managing a library system:

**Book Service**: Manages book information (retrieve, add, update, delete, and update book status).

**Borrowing Service**: Handles the borrowing and returning of books.

Additionally, it includes a Eureka Discovery Service for service discovery, allowing the Book and Borrowing services to communicate with each other.

### Create a new maven project in intellij

File -> New -> Project -> (Select New Project) and choose maven build system.

### Part 1: Setting Up Eureka Service

Create a EurekaService Module that will act as a service registry for microservices.

**1.Create Eureka Service Project**:

Right click on project  New -> Module.

Choose Spring Initializr and set the Project configuration such as SDK, type, and language. (Choose Java as language and Maven as type)

Click Next, and from the dependencies section, choose:

Spring Boot Actuator

Spring Cloud Eureka Server

Click Finish to create the project.

**2.Configure application.properties:**

Navigate to src/main/resources/application.properties.

Add the following properties:

server.port=8761 

eureka.client.register-with-eureka=false

eureka.client.fetch-registry=false 


**3.Run EurekaService:**

Create eureka server by using @EnableEurekaServer

Right-click on the project and choose Run 'EurekaService'.

Ensure the service is up and running on http://localhost:8761.

### Part 2: Setting up Book service module
Create a BookService module that will register with Eureka and provide book-related operations.

**1.Create Book Service Project:**

Follow the same steps as in part 1 to create a new project named BookService.

Choose the following dependencies:

Spring Boot Actuator

Spring Data JPA

Spring Data REST

Spring Web

Spring Cloud Eureka Client

H2 Database

Lombok

Spring Boot DevTools


**2.Configure application.properties:**

Navigate to src/main/resources/application.properties.

Add the properties learned in the class and properties for H2



**3.Create Book Model and Repository:**

Create a new Java class Book in the entity package and annotate it with @Entity.

Define properties for the Book entity and annotate them with JPA annotations.

Create an interface BookRepository in the repository package and extend JpaRepository.



**4.Create Seeder to Populate Books H2 in-memory database:**

Create a new class DbSeeder and use it to populate the BookRepository with some initial books.

Access the H2 console via http://localhost:<BookService-Port>/h2-console to manage and query the database 


**5. Create Controller and Service to operate books**

Create a new interface class BookService in the service package.

Create an impl package inside the service package and add a Java class BookServiceImpl to it.

Define service methods in BookServiceImpl and annotate the class with @Service.

Create a new Java class BookController in the controller package and annotate it with @RestController.

Define endpoints for the book service in the BookController class, annotate them with appropriate mapping annotations (e.g., @GetMapping, @PostMapping), and call the service methods within each endpoint.


**6.Run BookService:**

Right-click on the project and choose Run 'BookService'.

Ensure it registers with Eureka and is accessible.


### Part 3: Setting up Borrow Service Module

Create a Borrow service module that will register with Eureka and consume BookService to borrow and return books

**1.Create Borrow Service Project:**

Follow the same steps as in Part 1 to create a new project named BorrowService.

Choose the following dependencies:

Spring Boot Actuator

Spring Web

Spring Cloud Eureka Client

OpenFeign

Spring Boot DevTools

Lombok


**2.Configure application.properties similar to BookService.**


**3.Implement Fetching book functionality using OpenFeign**

Create Feign client BookClient to communicate with BookService.

Configure Feign client by adding @EnableFeignClients to the application

Implement endpoints to fetch a book by id and update book status

Implement a rest service to borrow and return a book 


**4.Run BorrowService:**

Right-click on the project and choose Run BorrowService.

Ensure it registers with Eureka and is accessible.


**5.Testing Services:**

Use Postman to interact with book and borrow services.


