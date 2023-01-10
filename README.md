# Spring Boot Drools Rule Engine

This project is a demonstration of how to use Drools as a rule engine in a Spring Boot application. The project includes `Patient`, `Temperature`, and `Diagnosis` DTO classes and a set of rules for generating diagnoses for a patient based on their symptoms.


### Running the Application

Copy code
To build and run the application using Maven, use the following commands:
mvn clean install
mvn spring-boot:run

## Rule Configuration

The rules for generating diagnoses are defined in the `src/main/resources/rules.drl` file. The rules use the DRL language provided by Drools, and uses patient symptoms to match the diagnosis.

## Built With

- [Spring Boot](https://spring.io/projects/spring-boot) - The web framework used
- [Drools](https://drools.org/) - The rule engine used
- [Maven](https://maven.org/) - Dependency Management

## Authors

- **Arsal Jamal** - *Initial work*




