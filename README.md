## Hospital Management System

#### Description:
The Hospital Management System is a backend application developed using Spring Boot, Spring Security, JWT Authentication, and MySQL to manage patient records securely.
It provides user registration, login, JWT-based API authentication, and CRUD operations for managing patient information.

#### Use Case 1: Create the Project
Set up the Spring Boot project with the required dependencies and configure MySQL database connectivity.

#### Use Case 2: Create Entity Classes
Create User, Role, and Patient entities to represent the database structure.

#### Use Case 3: Create Repository Layer
Create UserRepository and PatientRepository to perform database operations using Spring Data JPA.

#### Use Case 4: Create DTO Classes
Create AuthRequest, AuthResponse, and PatientDto to transfer request and response data.

#### Use Case 5: Create Service Layer
Implement AuthService and PatientService to handle user registration, password encoding, authentication, JWT generation, and patient CRUD business logic.