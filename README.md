# Employee Management System

![Java](https://img.shields.io/badge/Java-17%2B-ED8B00?style=flat-square&logo=java&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-6DB33F?style=flat-square&logo=springboot&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-4479A1?style=flat-square&logo=mysql&logoColor=white)
![React](https://img.shields.io/badge/React-20232A?style=flat-square&logo=react&logoColor=61DAFB)
![JWT](https://img.shields.io/badge/JWT-000000?style=flat-square&logo=JSON%20web%20tokens&logoColor=white)

A full-stack Employee Management System with JWT authentication and role-based access control (ADMIN/USER). Admins can perform CRUD operations on Employees, Departments, and Projects. Users have read-only access.

## Table of Contents
- [Tech Stack](#tech-stack)
- [Key Features](#key-features)
- [Project Structure](#project-structure)
  - [Backend (Spring Boot)](#backend-spring-boot)
  - [Frontend (React + Vite)](#frontend-react--vite)
- [Screenshots](#screenshots)
- [API Endpoints](#api-endpoints)
- [Getting Started](#getting-started)
  - [Requirements](#requirements)
  - [Database Setup](#database-setup)
  - [Backend Setup](#backend-setup)
  - [Frontend Setup](#frontend-setup)
- [Future Enhancements](#future-enhancements)

---

## Tech Stack

**Backend:**
- Spring Boot (Java, Maven)
- Spring Security
- JWT Authentication
- Spring Data JPA
- MySQL

**Frontend:**
- React (Vite)
- React Router DOM
- Axios
- jwt-decode

---

## Key Features

- **User Registration & Login** with JWT tokens.
- **Role-based Access Control:** `ROLE_ADMIN` (full CRUD) and `ROLE_USER` (read-only).
- **Employee Management:** Includes department assignment.
- **Department Management:** Manage name, location, and budget.
- **Project Management:** Manage name, description, dates, and status.
- **Relational Data Mapping:** Many-to-many relationship mapping Employees ↔ Projects (expandable rows showing related data).
- **Protected Routes:** Frontend route protection with automatic redirect on 401 Unauthorized errors.
- **Token Management:** Frontend token expiration check with claims (`sub`, `role`, `exp`).
- **Global Exception Handling:** Centralized error handling on the backend.

---

## Project Structure

### Backend (Spring Boot)
```text
src/main/java/com/example/demo/
├── DemoApplication.java
├── config/SecurityConfig.java
├── controller/
│   ├── AuthController.java
│   ├── EmployeeController.java
│   ├── DepartmentController.java
│   └── ProjectController.java
├── dto/
│   ├── auth/ (LoginRequest, RegisterRequest, AuthResponse)
│   ├── EmployeeDTO.java
│   ├── DepartmentDTO.java
│   └── ProjectDTO.java
├── entity/ (User, Employees, Department, Project)
├── exception/GlobalExceptionHandler.java
├── mapper/ (EmployeeMapper, DepartmentMapper, ProjectMapper)
├── repository/ (UserRepository, EmployeeRepository, DepartmentRepository, ProjectRepository)
├── security/ (JwtUtil, JwtFilter, CustomUserDetailsService)
└── service/
    ├── EmployeeService, DepartmentService, ProjectService (interfaces)
    └── impl/ (EmployeeServiceImpl, DepartmentServiceImpl, ProjectServiceImpl)
```

### Frontend (React + Vite)
```text
src/
├── App.jsx (routing with ProtectedRoute and PublicRoute)
├── components/
│   ├── Login.jsx
│   ├── Register.jsx
│   └── Dashboard.jsx
├── services/api.js (Axios instance with JWT interceptor)
├── utils/auth.js (token decode, role check, auth helpers)
├── main.jsx
└── index.css
```

---

## Screenshots

*(Placeholder for Screenshots)*

- **Dashboard:** `<!-- Add dashboard screenshot here -->`
- **Employee List:** `<!-- Add employee list screenshot here -->`
- **Role-based Views:** `<!-- Add view reflecting Admin vs User permissions here -->`

---

## API Endpoints

### Authentication
- `POST /api/auth/register` — Register user
- `POST /api/auth/login` — Login, returns JWT

### Employee
- `GET /api/employee/getall` — Retrieve all employees
- `POST /api/employee/create` — Create new employee
- `PUT /api/employee/editbyid/{id}` — Update employee by ID
- `DELETE /api/employee/deletebyid/{id}` — Delete employee by ID

### Department
- `GET /api/department/getall` — Retrieve all departments
- `POST /api/department/create` — Create new department
- `PUT /api/department/editbyid/{id}` — Update department by ID
- `DELETE /api/department/deletebyid/{id}` — Delete department by ID

### Project
- `GET /api/project/getall` — Retrieve all projects
- `POST /api/project/create` — Create new project
- `PUT /api/project/editbyid/{id}` — Update project by ID
- `DELETE /api/project/deletebyid/{id}` — Delete project by ID

### JWT Token Claims
Tokens are decoded on the frontend to manage sessions and verify roles.
- `sub`: username
- `role`: `ROLE_ADMIN` or `ROLE_USER`
- `exp`: expiration timestamp

---

## Getting Started

### Requirements
- Java 17+
- Maven
- MySQL
- Node.js 18+
- npm

### Database Setup
1. Ensure MySQL is installed and running on your system.
2. Create a new MySQL database for the application.
3. Update the database URL, username, and password in your Spring Boot configuration file (`application.properties` or `application.yml`).

### Backend Setup
1. Navigate to the backend project directory.
2. Build the project and download dependencies using Maven:
   ```bash
   mvn clean install
   ```
3. Run the Spring Boot application (starts on port `8080`):
   ```bash
   mvn spring-boot:run
   ```

### Frontend Setup
1. Navigate to the frontend directory (`src/`).
2. Install the necessary dependencies:
   ```bash
   npm install
   ```
   *(Note: This installs `react-router-dom`, `axios`, `jwt-decode`, and other Vite defaults).*
3. Start the Vite development server:
   ```bash
   npm run dev
   ```
4. Access the application in your browser at `http://localhost:5173`. The application automatically points to the backend server running on `http://localhost:8080`.

---

## Future Enhancements
- Dockerizing the application for streamlined deployments.
- Adding pagination and sorting to data grids.
- Expanding metrics logging and data visualization options.