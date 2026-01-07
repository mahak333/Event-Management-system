# Event Registration System

## Description
The **Event Registration System** is a Spring Boot web application developed to manage events and participant registrations. Organizers can create and manage events, while participants can register for available events. The application follows a clean MVC architecture and uses an embedded database for simplicity.

---

## Technologies Used
- Java  
- Spring Boot  
- Spring MVC  
- Spring Data JPA  
- Thymeleaf  
- H2 Database  
- Maven  

---

## Application Architecture
The project is structured using standard Spring Boot conventions:

- **Controller layer** – Handles user requests and navigation  
- **Model layer** – Defines JPA entities (`Event`, `Participant`)  
- **Repository layer** – Manages database operations  
- **View layer** – Thymeleaf templates for UI  

---

## Database Details
- Uses **H2 embedded in-memory database**
- Database is configured in `application.properties`
- Tables are **automatically created** from JPA entity classes
- No physical database file exists in the project structure

Example configuration:
```properties
spring.datasource.url=jdbc:h2:mem:testdb
spring.jpa.hibernate.ddl-auto=update
spring.h2.console.enabled=true
