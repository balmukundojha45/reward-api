# 📦 Rewards API - Spring Boot Application

A Spring Boot REST API that calculates **customer reward points** based on their monthly transaction history.

---

## 📁 Project Structure

rewards-api/
├── controller/ # Exposes REST API endpoints (RewardController.java)
├── services/ # Contains business logic (TransactionServices.java)
├── model/ # (If any) contains POJOs like Transaction, RewardSummary
├── mock/ # Holds dummy transaction data (MockTransactionData.java)
├── exception/ # Custom and global exception handling
│ ├── CustomerNotFoundException.java
│ └── GlobalExceptionHandler.java
├── RewardsApiApplicationTests.java # JUnit tests for controller
└── pom.xml # Maven dependencies


---

## 🔧 Technologies Used

- Java 17
- Spring Boot 3.4.5
- Spring Web
- Spring Validation
- JUnit 5 (for testing)
- Mockito (for mocking services)
- Maven

---

## 🎯 Core Features

- 🔹 Calculates rewards based on transaction amount:
    - $50–100: 1 point per dollar over $50
    - Above $100: 2 points per dollar over $100 + 1 point per dollar between $50–100
- 🔹 Returns total rewards per month for each customer
- 🔹 Provides REST APIs to:
    - Fetch rewards for all customers
    - Fetch rewards for a specific customer
- 🔹 Exception handling for invalid customer IDs

---

## 🧪 Mock Logic

Transactions are mocked using `MockTransactionData.java`. You can customize these for testing/demo purposes without connecting to a real database.

---

## 🚀 API Endpoints

| Method | Endpoint              | Description                        |
|--------|-----------------------|------------------------------------|
| GET    | `/api/rewards`        | Get reward summary for all users   |
| GET    | `/api/rewards/{id}`   | Get reward summary for a customer  |

---

## ⚙️ How to Run the Project

### 💻 Using IDE (IntelliJ/Eclipse)
1. Open the project.
2. Run the application using your IDE or use:


### 🧪 Test with Postman or Browser
- **All Rewards**: `http://localhost:8080/api/rewards`
- **Customer Rewards**: `http://localhost:8080/api/rewards/1`

### ✅ Run JUnit Tests
```bash
mvn test

| Folder/File                           | Purpose                                        |
| ------------------------------------- | ---------------------------------------------- |
| `controller/RewardController`         | Handles API requests and delegates to service  |
| `services/TransactionServices`        | Business logic for calculating reward points   |
| `mock/MockTransactionData`            | Provides hard-coded transaction data           |
| `exception/GlobalExceptionHandler`    | Customizes error messages and status codes     |
| `exception/CustomerNotFoundException` | Thrown if user ID is invalid                   |
| `RewardsApiApplicationTests`          | JUnit + MockMvc tests for controller endpoints |

📌 Future Improvements
Add database support (JPA + MySQL/PostgreSQL)

Swagger/OpenAPI documentation

Authentication (JWT/Spring Security)

UI dashboard for visualizing points