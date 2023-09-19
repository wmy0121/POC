# Full Stack User Management System
This is a comprehensive full-stack user management application.
## User Roles: Admin and Regular User
In this application, users are divided into two roles: administrators and regular users. Administrators have the authority to manage all user information, including adding, updating, deleting, and querying, while regular users can only perform actions on their own information.
## Frontend Application
The frontend application focuses on delivering an exceptional user experience. We have employed Bootstrap 5 for styling, resulting in a modern, responsive interface. The application flow is as follows:
### Login Page: 
Users are initially presented with options to log in, reset their passwords, or register.
### After Login:
Both administrators and regular users can access the management interface, which includes functions for adding, updating, viewing, and deleting user profiles.
## Backend Application
The backend application leverages Spring Boot, Spring Data JPA, and MySQL database to implement REST APIs. It supports CRUD operations on user models and incorporates the following features:
1. Exception handling
2. Data access repositories
3. Controllers to handle HTTP requests
## Frontend-Backend Integration
To facilitate seamless communication between the frontend and backend, we use the following code configuration (located in the Spring MVC module of the Java Spring framework):
![Image text](https://github.com/wmy0121/POC/blob/master/img/%E5%9B%BE%E5%83%8F9-19-23%20%E4%B8%8B%E5%8D%885.52.jpeg)
This code configures a static resource handler to manage static resources in the web application. Frontend files are located in the src/main/resources/static directory. Consequently, you can access frontend pages via http://localhost:8080/login.html.
## Steps to Operate
Follow these steps to run the project:
1. Clone the project to your local machine.
2. Import the project using IntelliJ IDEA or a similar development tool.
3. Run the userManagementApplication class.
4. Open your web browser and navigate to http://localhost:8080/login.html.
5. Log in or register as needed.
## Project Structure
1. Frontend Page Directory: src/main/resources
2. Backend API Code Directory: src/main/java
## Usage
The front-end application communicates with the back-end API to create, read, update, and delete users.
### Login Interface
![Image text](https://github.com/wmy0121/POC/blob/master/img/%E5%9B%BE%E5%83%8F9-19-23%20%E4%B8%8B%E5%8D%886.29.jpeg)
### Administrator Application Interface
![Image text](https://github.com/wmy0121/POC/blob/master/img/%E5%9B%BE%E5%83%8F9-19-23%20%E4%B8%8B%E5%8D%886.30.jpeg)
### Common User Application Interface
![Image text](https://github.com/wmy0121/POC/blob/master/img/%E5%9B%BE%E5%83%8F9-19-23%20%E4%B8%8B%E5%8D%886.28.jpeg)

