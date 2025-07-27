

* ✅ Setup steps
* ✅ Screenshots (Postman or UI)
* ✅ API testing (registration, login, save API, fetch response)
* ✅ CI/CD & hosting
* ✅ Factory Pattern explanation
* ✅ Full configuration guide for new developers



## 📌 Features

- 🔐 User Registration & Login with JWT token-based authentication
- 🌐 Add public JSON API URLs and save responses
- 📦 Store all user data, APIs, and responses in PostgreSQL
- 🧠 Uses Factory Pattern for handling different API parsing strategies
- ✅ Clean MVC structure (Controller, Service, Repository)
- 🔧 Deployed using Render (or Railway/Fly.io)
- 🔄 CI/CD pipeline setup with GitHub Actions (or GitLab CI)

---

## 🚀 Getting Started

### 1️⃣ Clone the Repository

```bash
git clone https://github.com/riteshsinghrajput017-ship-it/Java-Spring-Boot-Showcase-Assignment.git
cd Java-Spring-Boot-Showcase-Assignment
````

### 2️⃣ Setup Environment Variables

Edit `application.properties`:

```properties
# PostgreSQL
spring.datasource.url=jdbc:postgresql://localhost:5432/your_db
spring.datasource.username=your_username
spring.datasource.password=your_password

# JWT
app.jwtSecret=your_jwt_secret_key
app.jwtExpirationMs=3600000
```

---

## 🛠️ Build & Run Locally

```bash
./mvnw clean install
./mvnw spring-boot:run
```

OR

```bash
mvn clean install
mvn spring-boot:run
```

---

## 📬 API Endpoints

| Method | Endpoint             | Description                   |
| ------ | -------------------- | ----------------------------- |
| POST   | `/api/auth/register` | Register new user             |
| POST   | `/api/auth/login`    | Authenticate & get JWT token  |
| POST   | `/api/url/add`       | Save public API URL           |
| GET    | `/api/url/all`       | Fetch all saved API responses |

> ✅ All protected endpoints require `Authorization: Bearer <token>` in headers

---

## 🧪 Sample API Usage (Postman)

### ✅ 1. Register User

**POST** `/api/auth/register`

**Request Body:**

```json
{
  "username": "ritesh",
  "email": "ritesh@example.com",
  "password": "secure123"
}
```





---

### ✅ 2. Login to Get Token

**POST** `/api/auth/login`

**Request Body:**

```json
{
  "username": "ritesh",
  "password": "secure123"
}
```

**Response:**

```json
{
  "token": "eyJhbGciOiJIUzI1NiIsInR5cCI..."
}
```


---

### ✅ 3. Add Public API URL

**POST** `/api/url/add`
**Headers:**

```
Authorization: Bearer <your_token>
```

**Body:**

```json
{
  "url": "https://jsonplaceholder.typicode.com/todos/1"
}
```


---

### ✅ 4. Fetch Stored Responses

**GET** `/api/url/all`
**Headers:**

```
Authorization: Bearer <your_token>
```



---

## 🧱 Factory Pattern Explained

We implemented a **Service Factory** to handle different API response strategies.

Example:

* `JsonPlaceholderService` for JSONPlaceholder
* `WeatherApiService` for OpenWeatherMap

The factory chooses the parser implementation at runtime based on the API source.

---

## 🏗️ Project Structure (MVC)

```
src/
├── controller/
├── service/
│   ├── factory/
│   ├── impl/
├── model/
├── dto/
├── repository/
├── security/
│   ├── JWTFilter
│   └── AuthEntryPoint
└── config/
```

---

## 🔐 JWT Security Flow

* Login/Register returns a JWT token.
* All secured endpoints check the token using a filter.
* Token is passed in `Authorization: Bearer <token>` header.

---

## 🧵 CI/CD

CI/CD pipeline is configured using **GitHub Actions** or **GitLab CI** to:

* Run build and tests on every push
* Auto-deploy to Render (or Railway)

📷 *Screenshot: CI pipeline execution*



## 📸 Screenshots (Postman)

* ✅ User registered
* ✅ JWT token received
* ✅ API added
* ✅ Response fetched

> Add these images in a `/screenshots` folder and reference like:


![Token-Username-Passwors Fetched](https://github.com/user-attachments/assets/2d11cf0a-abf1-4edb-b20e-9c3ac5710d66)
![Token-Username-Email Fetched](https://github.com/user-attachments/assets/2c3c18e7-0590-4f47-a5a7-7465a7693da5)
![ID-URL Fetched Succesfully](https://github.com/user-attachments/assets/4da0bf76-e2f7-476a-b33f-32a74ba4db82)
![User Registered Succesfully](https://github.com/user-attachments/assets/97947fd8-911e-4626-9de1-b8c3c10669bd)

## 🧑‍💻 Contributing (for new developers)

1. Clone the repo
2. Setup your DB & `application.properties`
3. Register/login to get token
4. Add your APIs
5. Check saved data
6. To test, use Postman collection included in `/postman` folder

---

## 📄 License

This project is for educational showcase purposes.

---

## 📞 Contact

Ritesh Thakur
📧 [ritesh@example.com](mailto:riteshsinghrajput017@gmail.com)
🔗 [LinkedIn](https://www.linkedin.com/in/ritesh-thakur-061825251/)