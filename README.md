# Gym Management System Demo 🏋️‍♂️

This project is a Gym Management System built with **Java 21** and **Spring Boot**.  
It supports database-driven user authentication, role-based authorization, menu item management, ingredient/allergen tracking, and profile photo uploads.  
Authentication is handled using **JDBC-based Spring Security**, and passwords are encrypted with **BCrypt**.

---

## 🚀 Technologies Used

- Java **21**
- Spring Boot **3.4.4**
- Spring Security (JDBC-based authentication)
- Spring Data JPA (Hibernate)
- MySQL
- BCrypt
- Maven

## 🔐 Security Overview

- Authentication is managed via `JdbcUserDetailsManager`.
- User credentials and roles are retrieved from custom tables: `auth_users` and `auth_roles`.
- Passwords are stored securely using `BCryptPasswordEncoder`.
- Security configuration is handled in `DemoSecurity.java`.
- Authorization rules:
  - **ADMIN**: full access
  - **TRAINER**: limited access
  - **MEMBER**: read-only or restricted actions

---

## 🧩 Project Structure

src/
└── main/
├── java/
│   └── com/gorkemkaragoz/gymmanagementsystemdemo/
│       ├── controller/     → REST endpoints
│       ├── entity/         → JPA Entities (manually coded)
│       ├── repository/     → Spring Data interfaces
│       ├── service/        → Service interfaces
│       ├── serviceImpl/    → Service implementations
│       ├── security/       → Authentication & access control
│       └── exception/      → Custom exception classes
└── resources/
└── application.properties → Configuration file

---

## 📂 Entity Summary

| Entity           | Description                                    |
|------------------|------------------------------------------------|
| `MenuItem`       | Represents food/drink items                    |
| `ItemIngredient` | Represents ingredients of a menu item          |
| `ItemAllergen`   | Represents allergens of a menu item            |
| `FoodDrinkType`  | Represents the category of items (e.g., Shake) |

> Entities use `@JsonManagedReference` and `@JsonBackReference` to prevent infinite recursion in JSON serialization.

---

## 📮 Example API Endpoints

| Method | Endpoint                  | Description                          |
|--------|---------------------------|--------------------------------------|
| GET    | `/api/menu-items`         | Get all menu items                   |
| POST   | `/api/menu-items`         | Add a new menu item                  |
| GET    | `/api/profile-photo/{id}` | Get profile photo by user ID         |
| POST   | `/auth/register`          | Register a new user                  |
| POST   | `/auth/login`             | Perform login (form-based)           |
