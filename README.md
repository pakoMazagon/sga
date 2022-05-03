# POC for Inditex

## Goal

Implement POC using TDD approach, Hexagonal Architecture and API First

Use MySQL dockerized database (In /docker-compose.yml), with Liquibase as version control
Use testContainer 

## Pre-requisites

- Java 11
- Maven
- Docker and Docker-Compose

## Documentation
The implementation of the problem has followed an API first approach. The API definition it's available in  
src/main/resources/api.yml

The swagger-ui it's also enabled and will available after boot the application in the following link:
http://localhost:8080/swagger-ui.html#/prices/

Unit tests, integration tests and end-to-end tests have been carried out

The integration tests have been done on test containers

Liquibase has been used as database version control and it has been initialized with the data in the test

The required test are implemented in **AppRatePricesFeature.java** class (as parametrized and integrations test over test containers with the data provided) 
   and in End2End.postman_collection.json (by postman collection end2end test)
  

### 0. First of all we must create the .jar 

- This .jar will be used for generates the image of docker
- We must open a cmd and go to the Location of project
- Due to this project use Consumer Driven Contract Testing, the .jar will be generates with this command (without run tests):
		"mvn clean install -DskipTests"


### 1. Now we must generate the image

- In this Location, there is a Dockerfile for generate the image from the .jar
- For this, we must execute "Docker build -t prueba_sga ."

### 2. Execute docker-compose

- /docker-compose.yml file contains the database and the app in another container, with the connection between them
- We must execute "docker-compose up -d"

#### 3. The app is run!!
- This app use Liquibase for initialize the database with data provided (changelog in: src/main/resources/db)

- We can test this application with:

	- Swagger UI: http://localhost:8080/swagger-ui.html#
	- Postman: Collection in /End2End.postman_collection.json. We must import the Collection in postman with the case uses describes in the test
	- Execute Tests: 
		- The project contains unit test for each layer using junit, integration test using TestContainers, and endToend Test using ConsumerdrivenContract. 
		- For execute all test we must execute 
		    "mvn test"
		- The use cases requested are implemented in **AppRatePricesFeature.java** class as parametrized Test using TestContainers and Liquibase for this
		     mvn -Dtest=AppRatePricesFeature test
```

