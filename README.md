# 🏢 Microservices Architecture with Spring Boot, Eureka, API Gateway & Zipkin

This project demonstrates a **Microservices-based architecture** built using **Spring Boot**, **Spring Cloud**, and **Netflix OSS** components. It includes centralized configuration, service discovery, routing through an API gateway, and distributed tracing using Zipkin.

---

## 📌 Architecture Overview

```
Client
  |
  ↓
API Gateway (Spring Cloud Gateway)
  |
  ├──→ Department Service (Spring Boot, port: 8082)
  └──→ Employee Service (Spring Boot, port: 8081)

Support Services:
  - Config Server (port: 8080)
  - Service Registry (Eureka, port: 8761)
  - Zipkin (default port: 9411)
```

![Architecture Diagram](./path-to-your-image/Screenshot%202025-08-25%20at%205.17.23%20PM.png)

---

## 🛠️ Technologies Used

* **Java 17+**
* **Spring Boot**
* **Spring Cloud Config Server**
* **Spring Cloud Eureka (Service Registry)**
* **Spring Cloud Gateway (API Gateway)**
* **Spring Cloud Sleuth + Zipkin (Distributed Tracing)**
* **Netflix OSS Components**

---

## 📦 Microservices Overview

### 1. 🔧 Config Server (`localhost:8080`)

* Centralized configuration for all services.
* Loads configuration from a Git repository.

### 2. 🌐 API Gateway

* Entry point for all client requests.
* Handles routing and load balancing through Eureka.

### 3. 🗂️ Service Registry (Eureka) (`localhost:8761`)

* Enables service discovery for microservices.
* All services register themselves here.

### 4. 🏬 Department Service (`localhost:8082`)

* Manages department-related data.
* Registers with Eureka, fetches config from Config Server.

### 5. 👨‍💼 Employee Service (`localhost:8081`)

* Manages employee-related data.
* Communicates with Department Service.
* Registers with Eureka, fetches config from Config Server.

### 6. 📊 Zipkin (`localhost:9411`)

* Collects and visualizes distributed trace data.
* Integrated with Spring Cloud Sleuth.

---

## 🔁 How It Works

* All services pull configuration from the **Config Server**.
* They register themselves with **Eureka** for discovery.
* **API Gateway** uses Eureka to route incoming HTTP requests to appropriate services.
* **Sleuth** tags each request, and **Zipkin** collects the trace data for monitoring.

---

## 🚀 Running the Project

1. **Clone the repository**

   ```bash
   git clone https://github.com/your-username/microservices-architecture-springboot.git
   cd microservices-architecture-springboot
   ```

2. **Start the services in this order:**

   | Service            | Port                     |
   | ------------------ | ------------------------ |
   | Config Server      | 8080                     |
   | Eureka Server      | 8761                     |
   | Zipkin Server      | 9411                     |
   | API Gateway        | (your choice, e.g. 8083) |
   | Department Service | 8082                     |
   | Employee Service   | 8081                     |

   You can run Zipkin using Docker:

   ```bash
   docker run -d -p 9411:9411 openzipkin/zipkin
   ```

3. **Access the dashboards:**

   * **Eureka UI:** `http://localhost:8761`
   * **Zipkin UI:** `http://localhost:9411`
   * **Department Service (via Gateway):** `http://localhost:{gateway-port}/department/...`
   * **Employee Service (via Gateway):** `http://localhost:{gateway-port}/employee/...`

---

## 📈 Distributed Tracing

* Enabled with **Spring Cloud Sleuth**
* Visualized through **Zipkin**
* Helps in tracking the request flow between microservices

---

## 📝 License

This project is open-sourced under the MIT License. See `LICENSE` file for details.

---

Would you like me to generate a folder structure and sample codebase for this setup?
