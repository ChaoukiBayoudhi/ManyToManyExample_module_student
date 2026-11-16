# Many To Many Example module student

A REST API built with Spring Boot around 2 JPA entities, using PostgreSQL.

## Tech stack

- Java 19, built with Maven
- Spring Boot 2.7.4
- Spring Web (REST controllers)
- Spring Data JPA (Hibernate)
- Lombok
- PostgreSQL driver
- Database: PostgreSQL (`study_db` in `application.properties`)

## Concepts covered

JPA relationships, collections.

## Data model

| Entity | Fields |
|---|---|
| `Student` | id, name, birthday, mark, studiedModules |
| `Module` | id, name, nbHours, coefficient, students |

## Project structure

- `com.example.ManyToManyExample`: ManyToManyExampleApplication, Module, Student
- Tests: 1 test class

## How to run

Requirements: a JDK 19+ and Maven (or the included Maven wrapper).
Create the `study_db` database and set your own username and password in `src/main/resources/application.properties`.

```bash
./mvnw spring-boot:run
```

The API then listens on `http://localhost:8080`.

---

Author: [Chaouki Bayoudhi](https://github.com/ChaoukiBayoudhi)
