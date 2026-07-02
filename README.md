
# 💰 Deploy-Springapp — Personal Finance Tracker REST API

A full-stack **Spring Boot Maven** application built as an introduction to Spring Boot, JPA, REST APIs, and layered architecture. This project implements a **Personal Finance Management System** with CRUD operations for Users, Incomes, Budgets, and Expenses — backed by MySQL and documented via Swagger.

---

## 📌 Project Overview

| Property       | Value                          |
|----------------|-------------------------------|
| Framework      | Spring Boot 2.7.15            |
| Language       | Java 11                       |
| Build Tool     | Maven (with Maven Wrapper)    |
| Database       | MySQL 8                       |
| Port           | 8081                          |
| API Docs       | Swagger UI / SpringDoc OpenAPI|

---

## 🗂️ Project Structure

```
Deploy-Springapp/
└── springapp/
    ├── pom.xml
    ├── mvnw / mvnw.cmd
    ├── logs/
    │   └── application.log
    └── src/
        ├── main/
        │   ├── java/com/examly/springapp/
        │   │   ├── SpringappApplication.java        # Entry point
        │   │   ├── aspect/
        │   │   │   └── SampleAspect.java            # AOP logging aspect
        │   │   ├── configuration/
        │   │   │   └── SwaggerConfig.java           # Swagger/OpenAPI config
        │   │   ├── controllers/
        │   │   │   ├── UserController.java
        │   │   │   ├── IncomeController.java
        │   │   │   ├── BudgetController.java
        │   │   │   └── ExpenseController.java
        │   │   ├── entities/
        │   │   │   ├── User.java
        │   │   │   ├── Income.java
        │   │   │   ├── Budget.java
        │   │   │   └── Expense.java
        │   │   ├── repositories/
        │   │   │   ├── UserRepository.java
        │   │   │   ├── IncomeRepository.java
        │   │   │   ├── BudgetRepository.java
        │   │   │   └── ExpenseRepository.java
        │   │   └── services/
        │   │       ├── UserService.java
        │   │       ├── IncomeService.java
        │   │       ├── BudgetService.java
        │   │       └── ExpenseService.java
        │   └── resources/
        │       └── application.properties
        └── test/
            └── java/com/examly/springapp/
                └── SpringappTest.java
```

---

## 🔧 Tech Stack & Dependencies

| Dependency                  | Purpose                                 |
|-----------------------------|-----------------------------------------|
| `spring-boot-starter-web`   | REST API layer                          |
| `spring-boot-starter-data-jpa` | ORM with Hibernate                  |
| `mysql-connector-java 8.0.30` | MySQL JDBC driver                     |
| `lombok`                    | Boilerplate reduction (getters/setters) |
| `springfox-swagger2 2.4.0`  | Swagger 2 API documentation            |
| `springdoc-openapi-ui 1.7.0`| OpenAPI 3 / Swagger UI                  |
| `spring-boot-starter-logging` | File + console logging               |
| `spring-boot-devtools`      | Hot reload during development           |
| `spring-boot-starter-test` + `junit 4.13.2` | Unit/Integration testing |

---

## ⚙️ Configuration

Edit `springapp/src/main/resources/application.properties`:

```properties
spring.jpa.hibernate.ddl-auto=update
spring.datasource.url=jdbc:mysql://localhost/appdb?createDatabaseIfNotExist=true
spring.datasource.username=root
spring.datasource.password=examly
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.show-sql=true
spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect

logging.file.name=logs/application.log
server.port=8081
```

> ⚠️ Change `spring.datasource.password` to your actual MySQL root password before running.

---

## 🚀 How to Run

### Prerequisites
- Java 11+
- Maven 3.6+ (or use the included `mvnw` wrapper)
- MySQL 8 running locally

### Steps

```bash
# Clone the repository
git clone https://github.com/dhanushkumar-karuppasamy/Deploy-Springapp.git
cd Deploy-Springapp/springapp

# Build the project
./mvnw clean install

# Run the application
./mvnw spring-boot:run
```

The server starts at: **http://localhost:8081**

---

## 📡 API Endpoints

### 👤 Users — `/users`

| Method   | Endpoint       | Description          |
|----------|----------------|----------------------|
| `POST`   | `/users`        | Register a new user  |
| `GET`    | `/users`        | Get all users        |
| `GET`    | `/users/{id}`   | Get user by ID       |
| `PUT`    | `/users/{id}`   | Update user by ID    |
| `DELETE` | `/users/{id}`   | Delete user by ID    |

### 💵 Incomes — `/incomes`

| Method   | Endpoint            | Description                        |
|----------|---------------------|------------------------------------|
| `POST`   | `/incomes`          | Add income record                  |
| `GET`    | `/incomes`          | Get all incomes                    |
| `GET`    | `/incomes/{id}`     | Get income by ID                   |
| `PUT`    | `/incomes/{id}`     | Update income by ID                |
| `DELETE` | `/incomes/{id}`     | Delete income by ID                |
| `GET`    | `/incomes/sorted`   | Get incomes sorted by `?sortBy=`   |

### 📊 Budgets — `/budgets`

| Method   | Endpoint            | Description                             |
|----------|---------------------|-----------------------------------------|
| `POST`   | `/budgets`          | Create a budget                         |
| `GET`    | `/budgets`          | Get all budgets                         |
| `GET`    | `/budgets/{id}`     | Get budget by ID                        |
| `PUT`    | `/budgets/{id}`     | Update budget by ID                     |
| `DELETE` | `/budgets/{id}`     | Delete budget by ID                     |
| `GET`    | `/budgets/filter`   | Filter by `?userId=&category=`          |

### 🧾 Expenses — `/expenses`

| Method   | Endpoint           | Description          |
|----------|--------------------|----------------------|
| `POST`   | `/expenses`        | Add expense record   |
| `GET`    | `/expenses`        | Get all expenses     |
| `GET`    | `/expenses/{id}`   | Get expense by ID    |
| `PUT`    | `/expenses/{id}`   | Update expense       |
| `DELETE` | `/expenses/{id}`   | Delete expense       |

---

## 📖 Swagger API Documentation

Once the app is running, access the interactive API docs at:

- **Swagger UI:** [http://localhost:8081/swagger-ui/](http://localhost:8081/swagger-ui/)
- **OpenAPI JSON:** [http://localhost:8081/v3/api-docs](http://localhost:8081/v3/api-docs)

---

## 🧪 Running Tests

```bash
cd springapp
./mvnw test
```

Test reports are generated at: `target/surefire-reports/`

The test suite covers:
- Controller file existence checks
- User registration and retrieval
- Income, Budget, Expense CRUD via `TestRestTemplate`

---

## 🏗️ Architecture

This project follows the standard **3-layer Spring Boot architecture**:

```
[Client/Postman]
      ↓
[Controller Layer]  → REST endpoints, HTTP request/response mapping
      ↓
[Service Layer]     → Business logic
      ↓
[Repository Layer]  → JPA/Hibernate, MySQL database access
      ↓
[MySQL Database]
```

**Additional components:**
- **AOP Aspect (`SampleAspect.java`)** — Cross-cutting concerns like method logging
- **Swagger Config (`SwaggerConfig.java`)** — API documentation setup
- **Lombok** — Auto-generates boilerplate (getters, setters, constructors)

---

## 📝 Key Concepts Demonstrated

- ✅ Spring Boot project setup with Maven (`pom.xml`)
- ✅ RESTful API design with `@RestController`, `@RequestMapping`
- ✅ JPA entities with `@Entity`, `@OneToMany` relationships
- ✅ Spring Data JPA repositories (`JpaRepository`)
- ✅ Service layer dependency injection with `@Autowired`
- ✅ Aspect-Oriented Programming (AOP) with `@Aspect`
- ✅ Swagger/OpenAPI documentation integration
- ✅ MySQL datasource configuration via `application.properties`
- ✅ Integration testing with `TestRestTemplate` and JUnit 4
- ✅ Maven Wrapper for portable builds (`mvnw`)

---

## 👨‍💻 Author

**Dhanushkumar Karuppasamy**  
AI & Data Science Student  
🔗 [GitHub Profile](https://github.com/dhanushkumar-karuppasamy)

---

## 📄 License

This project is open-source and available under the [MIT License](LICENSE).
```
