# Spring Boot with PostgresSQL, Swagger and Docker

Commands:

```shell
# Run the project:
mvn spring-boot:run
# Build the project:
mvn clean package

# Build docker image:
docker build -t demo .
# Run the image:
docker run --network=host -it demo
```
