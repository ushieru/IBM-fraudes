## IBM - ACADEMY

Proyecto final de la academia **Spring Boot - Java 11**

- Spring Boot Web
- Spring Boot
- Eureka
- Api Gateway Spring Cloud
- Dynamic ports
- Resilience4J
- Feign
- H2
- JPA / Hibernate
- Logs
- Spring Boot Test

### Instructions:

⚠️⚠️ add fixer token __fraudes.src.main.resources.application.yml__

### End points:

- GET

 http://localhost:8090/gateway/api/v1/rest-fraudes/info/{ip}
  
- POST

http://localhost:8090/gateway/api/v1/rest-fraudes/addBlackList
   
    {
        "ip": "2.2.2.2"
    }

By default ip 1.1.1.1 is blacklisted

