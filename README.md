# GRAPHITE - Recipe Service
Project Recipe Service for GRAPHITE

## Description
This particular service will serve recipe data.

Capabilities:
- List all recipes
- Return details for a specified recipe
- Create a new recipe
- Update a recipe (one user should not be able to update another user's recipe)

## Repository
https://github.com/joselopezh/graphite-recipeservice

## Construcción
```
mvn install
cd target
java -jar recipeservice-0.0.1-SNAPSHOT.jar
```

## Public Service
### Rest Api
http://34.125.206.210
### Rest Api Documentation
http://34.125.206.210/swagger-ui.html#/fuegodequasar-controller

## Local Execution
```
mvn spring-boot:run
```

## Api Documentation
http://localhost:8080/swagger-ui.html

## Test
Run unit test executing bellow command
```
mvn test
```

## DB Validation
To validate registers in DB
go to http://localhost:8080/h2-ui/login.jsp
* **JDBC URL:** jdbc:h2:mem:testdb
* **User Name:** sa

```
Password no requiered
Run Select * from RECIPES
```

## Deploy
The service was deployed on Compute Engine de GCP.
Tipo: e2-medium(2 vCPU, 4GB de Memoria)
Ip: 34.125.206.210

## Design & Thoughts
This App was developed following the bellow principles:
- Use MVC Pattern Model-View-Controller Pattern using (Model-Controller)
    to accomplish single responsibilities in small components.
- Use Spring Framework to optimize development and reduce complexity.
- H2 Database to create and manage an in-memory database.
- Lombock to reduce code lines.

## Autor
* **Jose Luis Lopez** (https://github.com/joselopezh/graphite-recipeservice)
