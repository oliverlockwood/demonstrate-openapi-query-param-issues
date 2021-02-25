# demonstrate-openapi-query-param-issues
To demonstrate some problems encountered when upgrading from Swagger V2 to OpenAPI V3

## Modules

- Commons - Contains common model and contract classes
- Client - Contains feign client interfaces
- Core - Contains core business logic
- Service - Contains web components for microservice

#### Run the app
You can do this within the IDE or, alternatively, from the `Service` directory:

`mvn spring-boot:run`

#### Swagger
http://localhost:18119/swagger-ui/index.html?configUrl=/v2/api-docs/swagger-config
