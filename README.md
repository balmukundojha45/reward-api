# Rewards API

This is a Spring Boot REST API that calculates customer reward points based on their transaction history.

The reward logic is as follows:
- $1 spent over $50 earns 1 point.
- $1 spent over $100 earns 2 points.

---

## Project Structure

```text
rewards-api/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/xyzcompany/rewards/
│   │           ├── controller/
│   │           │   └── RewardController.java
│   │           ├── exception/
│   │           │   └── CustomerNotFoundException.java
│   │           ├── model/
│   │           │   └── Transaction.java
│   │           ├── service/
│   │           │   └── TransactionServices.java
│   │           ├── Mock/
│   │           │   └── MockTransactionData.java
│   │           └── RewardsApiApplication.java
│
│   └── test/
│       └── java/
│           └── com/xyzcompany/rewards/
│               ├── TransactionServicesTest.java
│               ├── RewardControllerTest.java
│               └── RewardsApiIntegrationTest.java
│
├── pom.xml
└── README.md
```

---

## Technologies Used

- Java 17
- Spring Boot 3.4.5
- Maven
- JUnit 5
- Mockito
- Spring Boot Starter Test

---

## Setup Instructions

### Prerequisites

- Java 17
- Maven

### Build the Project

```bash
mvn clean install
```

### Run the Application

```bash
mvn spring-boot:run
```

The application will start at:  
`http://localhost:8080`

---

## API Endpoint

### `GET /rewards/{customerId}`

Returns monthly and total reward points for the given customer.

#### Example

```http
GET http://localhost:8080/rewards/1
```

#### Sample Response

```json
{
  "customerId": 1,
  "customerName": "Mukund",
  "monthlyRewards": {
    "MAY": 210
  },
  "totalRewards": 210
}
```

#### Error Response

```json
{
  "message": "Customer with ID 10 not found"
}
```

---

## Mock Data – Sample Customers

The following customers are available in the in-memory mock dataset:

- Mukund
- Sadhana

Each has transactions across multiple months.

---

## Running Tests

### Unit Tests

```bash
mvn test
```

Covers:
- `TransactionServicesTest`
- `RewardControllerTest`

### Integration Tests

```bash
mvn verify
```

Covers:
- `RewardsApiIntegrationTest` — full request-response cycle

---

## Notes

- The project uses mock data only (no database).
- Easily extendable to integrate with a real database.

---

## License

This project is for educational and internal demo purposes.
