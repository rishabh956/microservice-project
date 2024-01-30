This project has 2 microservice
1. customer-management: it has 3 apis for add, delete and get all the customer data.
2. ref-api: this service consume all the customer -management service, we are calling them by RestTemplate.
3. we have one more service which acts as Eureka-server, both the above service is registered .
4. port for  eureka-server-8761, after running all the service and server we see at http://localhost:8761/
5. port for customer-management service is 8081\
6. port for ref-api service is 8082
7. make sure the DB details configure in customer-management application.properties file.

springboot - 2.4.4
java - 8
mysql DB
