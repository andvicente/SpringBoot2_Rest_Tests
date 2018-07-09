# SpringBoot2_Rest_Tests
API Rest para Testes de API utilizando Cucumber e Rest-Assured

### Tecnologias
* Spring Boot 2 (https://spring.io/projects/spring-boot)
* Spring Data JPA - Banco H2 (In Memory)
* Swagger - Rest API Documentation (https://swagger.io/tools/swagger-ui)
* Cucumber-JVM - BDD Testing (https://cucumber.io)
  * Gherking (https://docs.cucumber.io/gherkin/reference)
* Rest-Assured - API Testing (http://rest-assured.io)

### Classes
```
    |-- main
          |-- Springboot2RestApplication.java // Aplicação Spring Boot
    |-- test
          |-- com.andvicente.springboot2rest
                |-- cucumber.steps
                      |-- EstudanteSteps.java //Cucumber Steps
                |-- restassured
                       |-- StudentTests.java //Testes Rest-Assured
          |-- RunCucumberTests.java //Testes com Cucumber + Rest-Assured
          |-- resources
                |-- *.features //BDD - Gherking
```

### Referência
* Spring Boot 2: http://www.springboottutorial.com/spring-boot-crud-rest-service-with-jpa-hibernate
* Swagger: https://dzone.com/articles/spring-boot-restful-api-documentation-with-swagger
