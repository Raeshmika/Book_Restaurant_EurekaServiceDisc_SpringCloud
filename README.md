# Book_Restaurant_EurekaServiceDisc_SpringCloud

Folder Sweet-home Contains following services: Booking Service
Transaction Service
Eureka Service registry
Api-gateway
Booking Service: URL : http://localhost:8081/hotel/booking API gateway link to access the service : http://localhost:9191/hotel/booking Service is registered on Eureka server. This service is responsible for booking hotel rooms. Service makes a synchronous call to Payment service using restTemplate. Payments can be made using UPI or CARD. Service validates payment mode using spring-validator and custom annotation Service uses in-memory H2 database - bookingdb
Payment Service: URL : http://localhost:8083/payment/transaction API gateway link to access the service. http://localhost:9191/payment/transaction
Service is registered on Eureka server. This service is responsible for processing payment for the booked hotel rooms. Service uses in-memory H2-database - transactiondb
API Gateway This service is the entry port for the other two microservices Booking and Payment. URL : http://localhost:9191
Eureka server All the three services Booking, Payment and Eureka service are registered on Eureka Service Registry.
URL : http://localhost:8761/ 
