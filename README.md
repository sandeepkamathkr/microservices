# Microservices with Spring Boot and Spring Cloud

Make your microservices cloud ready with Spring Cloud

Steps Implemented

- Established Communication between Microservices
- Centralized Microservice Configuration with Spring Cloud Config Server
- Using Spring Cloud Bus to exchange messages about Configuration updates
- Simplify communication with other Microservices using Feign REST Client
- Implemented client side load balancing with Ribbon
- Implemented dynamic scaling using Eureka Naming Server and Ribbon
- Implemented API Gateway with Zuul
- Implemented Distributed tracing with Spring Cloud Sleuth and Zipkin
- Implemented Fault Tolerance with Zipkin

## Ports

|     Application       |     Port          |
| ------------- | ------------- |
| Limits Service | 8080, 8081, ... |
| Spring Cloud Config Server | 8888 |
|  |  |
| Currency Exchange Service | 8000, 8001, 8002, ..  |
| Currency Conversion Service | 8100, 8101, 8102, ... |
| Netflix Eureka Naming Server | 8761 |
| Netflix Zuul API Gateway Server | 8765 |
| Zipkin Distributed Tracing Server | 9411 |

## URLs

|     Application       |     URL          |
| ------------- | ------------- |
| Limits Service | http://localhost:8080/limits POST -> http://localhost:8080/actuator/refresh|
|Spring Cloud Config Server| http://localhost:8888/my-limits-service/default http://localhost:8888/my-limits-service/dev |
|  Currency Converter Service - Direct Call| http://localhost:8100/my-currency-conversion/from/USD/to/INR/quantity/1000
|  Currency Converter Service - Feign| http://localhost:8100/my-currency-conversion-feign/from/USD/to/INR/quantity/1000
| Currency Exchange Service | http://localhost:8000/my-currency-exchange/from/EUR/to/INR http://localhost:8001/my-currency-exchange/from/EUR/to/INR
| Eureka | http://localhost:8761/|
| Zuul - Currency Exchange & Exchange Services | http://localhost:8765/my-currency-exchange-service/my-currency-exchange/from/EUR/to/INR http://localhost:8765/my-currency-conversion-service/my-currency-convertion-feign/from/USD/to/INR/quantity/10|
| Zipkin | http://localhost:9411/zipkin/ |
| Spring Cloud Bus Refresh | http://localhost:8080/bus/refresh |