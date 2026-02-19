TASK MANAGER REST API

OVERVIEW

The Task Manager API is a RESTful backend service built using Spring
Boot. It provides endpoints to create, retrieve, update, delete, filter,
and sort tasks. The project follows a clean layered architecture:
Controller → Service → Repository.

TECH STACK

-   Java 17+
-   Spring Boot
-   Spring Web
-   Spring Data JPA
-   H2 / MySQL (configurable)
-   Maven
-   JUnit 5
-   Mockito

PROJECT STRUCTURE

src/main/java/com/example/taskmanager

controller/ - TaskController.java

service/ - TaskService.java - TaskListService.java (if applicable)

repository/ - TaskRepository.java

entity/ - Task.java

APPLICATION FEATURES

1.  Create a new task
2.  Retrieve all tasks (with optional sorting)
3.  Retrieve a task by ID
4.  Update an existing task
5.  Delete a task
6.  Sort tasks by any valid field (ascending/descending)
7.  Exception handling for missing resources

HOW TO RUN THE APPLICATION

Option 1: Using Maven

mvn spring-boot: run

Option 2: Build JAR and Run

mvn clean package java -jar target/taskmanager-0.0.1-SNAPSHOT.jar

The application runs by default on: http://localhost:8080

API ENDPOINTS

1.  Create Task POST /tasks

Request Body Example: { “title”: “Complete assignment”, “description”:
“Finish API development”, “status”: “PENDING” }

2.  Get All Tasks GET /tasks Optional Query Parameters:

-   sortBy (example: id, title, status)
-   sortDirection (asc | desc)

Example: GET /tasks?sortBy=id&sortDirection=asc

3.  Get Task By ID GET /tasks/{id}

4.  Update Task PUT /tasks/{id}

5.  Delete Task DELETE /tasks/{id}

RUNNING TESTS

Execute the following command:

mvn test

Unit tests cover: - Task creation - Fetch all tasks (with sorting) -
Fetch task by ID - Delete task - Exception scenarios

DATABASE

We are using the H2 database. The console is available at:
http://localhost:8080/h2-console

Database configuration can be modified in application.properties.

DESIGN DECISIONS

-   ID is auto-generated using JPA.
-   Sorting defaults to ID if no field is provided.
-   Service layer handles business logic.
-   The repository layer interacts with the database.
-   Unit tests use Mockito for mocking repository interactions.

FUTURE IMPROVEMENTS

-   Global exception handling with @ControllerAdvice
-   Pagination support
-   OpenAPI/Swagger documentation
-   Authentication and authorization
-   Integration testing with SpringBootTest

AUTHOR

Developed as a backend REST API project using Spring Boot.
