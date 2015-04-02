# Dropwizard + Scala + JDub + Flyway Project

This project demonstrates how to setup a minimal [Dropwizard](https://dropwizard.github.io/dropwizard/index.html) project with  [Scala support](https://github.com/bretthoerner/dropwizard-scala).

It also incorporates database access through [JDub](https://github.com/SimpleFinance/jdub) with [Flyway](http://flywaydb.org/) for database migrations. In addition, this project demonstrates integration of [Swagger](http://swagger.io/) to expose documentation for all exported REST API endpoints. The Dropwizard Integration with Swagger is care of the [dropwizard-swagger](https://github.com/federecio/dropwizard-swagger) project.

## Getting Started
1. Clone the repository
2. Run the following commands at the command prompt 

        > mvn package
        > mvn flyway:migrate
        > mvn scala:run
        
3. Open a browser to http://localhost:8281/swagger    
    

