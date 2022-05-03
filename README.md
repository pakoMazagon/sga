# POC for Inditex

## Goal

Implement POC using TDD approach, Hexagonal Architecture and API First

Use MySQL dockerized database (In src/main/resources/docker-compose.yml), with Liquibase as version control
Use testContainer 

## Pre-requisites

- Docker
- Java 11
- Maven

## Documentation
The implementation of the problem has followed an API first approach. The API definition it's available in  
src/main/resources/api.yml

The swagger-ui it's also enabled and will available after boot the application in the following link:
http://localhost:8080/swagger-ui.html#/prices/

Unit tests, integration tests and end-to-end tests have been carried out
Integration testing 

The integration tests have been done on test containers

Liquibase has been used as database version control and it has been initialized with the data in the test

The required test are implemented in **AppRatePricesFeature.java** class (as parametrized and integrations test over test containers with the data provided) 
    and in End2End.postman_collection.json (by postman collection end2end test)
  

#### 0. First of all we must create the database:

- This database will be dockerized

- Execute the comand "docker-compose up" by the file docker-compose.yml (in resources)

- The database is initialized with Liquibase and the changelogs is in src/main/resources/db

#### 1. We compile the project:

- We must execute he command mvn install

- Then the application can be run as regular spring-boot application
```
	mvn spring-boot:run


#### 2. We can access to swagger for test the endpoint

- GET /prices?appDate={}&brandId={}&productId={}
```json
```

