# Gift Shop Feedback & Rating Management System

## Overview
The Gift Shop Feedback & Rating Management System is a Spring Boot backend application developed to manage gift shop products, categories, customer feedback, and product ratings through RESTful APIs.

The system provides CRUD operations for managing:
- Products
- Categories
- Feedback
- Ratings
- Users

It follows a layered architecture using:
- Controller Layer
- Service Layer
- Repository Layer
- Database Layer

---

## Technologies Used

- Java 17
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL
- Maven
- REST API
- Tomcat Server

---

## Features

- Add, update, delete, and view products
- Manage product categories
- Store customer feedback
- Manage product ratings
- User management
- RESTful API architecture
- Database integration using JPA/Hibernate
- Automatic table generation
- Validation and exception handling

---

## Project Structure

```text
src/main/java/com/examly/springapp
│
├── controller
├── service
├── repository
├── model/entity
├── exception
└── SpringappApplication.java
Database Tables

The application automatically creates the following tables:

category
product
feedback
rating
user
How to Run the Project
1. Clone or Download Project

Extract the project folder.

2. Configure Database

Update application.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/appdb
spring.datasource.username=root
spring.datasource.password=your_password
3. Run the Application

Open terminal inside project folder:

mvn spring-boot:run
4. Access Application

Server runs on:

http://localhost:8080
Sample API Endpoints
Category APIs
Method	Endpoint
GET	/api/categories
POST	/api/categories
PUT	/api/categories/{id}
DELETE	/api/categories/{id}
Product APIs
Method	Endpoint
GET	/api/products
POST	/api/products
PUT	/api/products/{id}
DELETE	/api/products/{id}
Architecture
Client → Controller → Service → Repository → MySQL Database
Future Enhancements
Frontend integration
Authentication & authorization
JWT security
Admin dashboard
Analytics and reporting
Cloud deployment
Conclusion

This project demonstrates backend application development using Spring Boot and REST APIs with database integration. It provides a scalable and maintainable architecture for managing gift shop feedback and ratings efficiently.
