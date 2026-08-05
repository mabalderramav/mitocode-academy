# Mitocode Academy Backend

A REST API for managing academy students, courses, and enrollments. The application is built with Spring Boot, Gradle, Java 25, and PostgreSQL.

## Requirements

- Java Development Kit (JDK) 25
- PostgreSQL

The repository includes the Gradle Wrapper, so a separate Gradle installation is not required.

## Database setup

By default, the application connects to PostgreSQL with the following settings:

| Setting | Value |
| --- | --- |
| Host | `localhost` |
| Port | `5433` |
| Database | `mitocode_academy_2026_3_db` |
| Username | Supplied at startup |
| Password | Supplied at startup |

Start PostgreSQL and create the database:

```sql
CREATE DATABASE mitocode_academy_2026_3_db;
```

Database credentials are intentionally not stored in the repository. The application requires `DB_USERNAME` and `DB_PASSWORD` values at startup. If your local PostgreSQL configuration is different, update `src/main/resources/application.yaml`. Hibernate is configured with `ddl-auto: update`, so the required tables are created or updated automatically.

## Run the application

1. Clone the repository and open a terminal in the project directory.
2. Configure and start PostgreSQL as described above.
3. Run the application with the Gradle Wrapper and supply your database credentials. Replace the example values with your own:

   **Windows (PowerShell)**

   ```powershell
   .\gradlew.bat bootRun --args="--DB_USERNAME=postgres --DB_PASSWORD=your-password"
   ```

   **macOS/Linux**

   ```bash
   ./gradlew bootRun --args='--DB_USERNAME=postgres --DB_PASSWORD=your-password'
   ```

4. When startup is complete, the API is available at `http://localhost:9595`.

Do not commit real credentials to the repository or share them in screenshots and logs.

## Run tests

Use the Gradle Wrapper to execute the test suite:

**Windows (PowerShell)**

```powershell
.\gradlew.bat test
```

**macOS/Linux**

```bash
./gradlew test
```

## API endpoints

All endpoints use the `/v1` base path.

| Resource | Endpoints |
| --- | --- |
| Students | `GET/POST /v1/students`, `GET/PUT/DELETE /v1/students/{id}` |
| Student reporting | `GET /v1/students/list-students-sorted-in-descending-order-by-age` |
| Courses | `GET/POST /v1/courses`, `GET/PUT/DELETE /v1/courses/{id}` |
| Enrollments | `GET/POST /v1/enrollments`, `GET/PUT/DELETE /v1/enrollments/{id}` |
| Enrollment reporting | `GET /v1/enrollments/courses-and-students` |

### Example: create a student

```http
POST http://localhost:9595/v1/students
Content-Type: application/json

{
  "firstsName": "Jane",
  "lastName": "Doe",
  "dni": "12345678",
  "age": 22
}
```

### Example: create a course

```http
POST http://localhost:9595/v1/courses
Content-Type: application/json

{
  "name": "Java Fundamentals",
  "code": "JAVA-101",
  "isActive": true
}
```

> Note: the student first-name field is named `firstsName` in the current API contract.
