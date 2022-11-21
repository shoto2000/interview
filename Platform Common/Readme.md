
# REST API for Student Management System Application

* Developed this REST API for Student Management System Application. This API performs all the fundamental CRUD operations of any StudentManangementSystem Application platform with user validation at every step.

## Tech Stack

* Java
* Spring Framework
* Spring Boot
* Spring Data JPA
* Hibernate
* MySQL
* Swagger

## Modules

* SignUp Module
* Login, Logout Module
* Student Module
* Admin Module

## Features

* User and Admin authentication & validation with session uuid having.
* Admin Features:
    * Can admit a student to the school with information such as name, date of birth ,gender, unique_student_code. A student can have many addresses(area ,state,district, pincode,addressType) like permanent, correspondence,current.
    * Can Upload course details such as (course name, description, course type,duration,topics)
    * Can assign courses to student
    * Can get students by name. (search)
    * Can get students assigned to a particular course.
* Student Features:
    * Can update profile details such as (email, mobile number , parents name,address)
    * Can search for topics/courses he assigned
    * Can leave a course.

## Installation & Run

* Before running the API server, you should update the database config inside the [application.properties](https://github.com/shoto2000/interview/blob/main/Platform%20Common/PlatformCommonStudentManagementSystem/src/main/resources/application.properties) file. 
* Update the port number, username and password as per your local database config.

```
    server.port=8888

    spring.datasource.url=jdbc:mysql://localhost:3306/sms;
    spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
    spring.datasource.username=shoto
    spring.datasource.password=shoto

```

## API Root Endpoint

`https://localhost:8888/`

`http://localhost:8888/swagger-ui/`
 
### E-R Diagram Of Covid-19 Application
---
<div id="2CDE2DC6790F86A273D9411FB2DAFAFDE64_11677"><div id="2CDE2DC6790F86A273D9411FB2DAFAFDE64_11677_robot"><a href="https://cloud.smartdraw.com/share.aspx/?pubDocShare=2CDE2DC6790F86A273D9411FB2DAFAFDE64" target="_blank"><img src="https://cloud.smartdraw.com/cloudstorage/2CDE2DC6790F86A273D9411FB2DAFAFDE64/preview2.png"></a></div></div><br/>

---
<h1 align="center">Thank You</h1>
