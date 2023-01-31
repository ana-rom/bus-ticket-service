<h2>  <img align="center" height="50" src="images/bus.png" width="50" alt=""/> Bus ticket service </h2>


The bus ticket service project is a web application realized on SpringBoot and has **two main modules** with synchronous communication: </br>
➡️ ticket management service </br>
➡️ payment service </br>

This project is built based on **three-layered architecture**:</br>
1. presentation (controllers level)
2. business logic (service level)
3. data logic layer (repository level)

| Modules                                                                                                   | Features                                                                                             |
|-----------------------------------------------------------------------------------------------------------|------------------------------------------------------------------------------------------------------|
| <img align="center" height="30" src="images/pay.png" width="30" alt=""/> **Payment Service**              |                                                                                                      |
| Payment Creation Service                                                                                  | CRUD operations                                                                                      |
| Service for receiving a payment status                                                                    | get payment id, generate random payment status and update payment                                    |
| <img align="center" height="30" src="images/ticket.png" width="30" alt=""/> **Ticket Management Service** |                                                                                                      |
| Bus Travel Service                                                                                        | CRUD operations                                                                                      |
| Ticket Buyer Service                                                                                      | save ticket to DB, call Payment service, get payment status, check ticket availability and update it |
| Ticket Information Service                                                                                | show all information about ticket, bus travel and payment status                                     |


**Technology solution**
* Main stack:
  * Spring Boot 3.0.2
  * Spring MVC, Data JPA
  * Apache Tomcat v.9.0.50
  * Java (JDK v.17)
  * Maven + checkstyle plugin
  * MySQL (v.8.0.22)
  * Lombok
* Other tools:
  * IDE: IntelliJ Ultimate
  * Postman

<h2>  <img align="center" height="50" src="images/map.png" width="50" alt=""/>  How it works </h2>


**Endpoints**

- GET: show all bus travels ```http://localhost:8080/bus-travels``` </br>
- POST: buy a ticket ```http://localhost:8080/tickets ```</br>
  - send request body in json format (client name, bus travel id, ticket price)  
  > { </br>
  >    "clientName":"Bob", </br>
  >    "busTravelId":1, </br>
  >    "price":750" </br>
  > } </br>
  - automatically send post request to create a payment and receive a payment status
  - check tickets and update bus travel with new amount of available tickets 
  - receive ticket id
- GET: show all information about bus travel, ticket and payment status ```http://localhost:8080/tickets/{id}/information ```</br>
- POST: create a payment and receive a payment status ```http://localhost:8081/payment ``` </br>
  - send client name and ticket price as request parameters (connection via WebClient)
  - receive payment status
- POST: create a new bus travel ```http://localhost:8080/bus-travels```

**Configuration**

1️⃣ Initialize your project by creating a fork (i.e. clone it from GitHub)</br>
2️⃣ Change datasource properties: </br>
- payment-service [applications.properties](payment-service/src/main/resources/application.properties) file</br>
- ticket-management-service [applications.properties](ticket-management-service/src/main/resources/application.properties) file </br>

3️⃣ Run modules (Payment Service on 8080 port and Ticket Management Service in 8081 port)</br>
4️⃣ Initialize bus travels test data to your DB running [init_bus_travels_in_db](ticket-management-service/src/main/resources/init_bus_travels_in_db.sql) file via IntelliJ Ultimate or directly in your RDBMS. You can add more test data to file.</br> 
Also you can add bus travels sending a post method to ```http://localhost:8080/bus-travels``` endpoint </br>

🎉 Use Postman and enjoy the application! </br>
