# Unit Test Plan

## Scope

Unit tests using JUnit 5 and Mockito for the service and controller layers of courses, students, and enrollments. 
External dependencies (repositories and services) are simulated with mocks.

## Service Test Cases

| Component                                | Successful cases                                                           | Failure cases                                                       |
|------------------------------------------|----------------------------------------------------------------------------|---------------------------------------------------------------------|
| `CrudImpl` (through `CourseServiceImpl`) | Save, retrieve all, retrieve by ID, update, and delete an existing entity. | Retrieve, update, or delete a non-existent ID.                      |
| `StudentServiceImpl`                     | Sort students by age in descending order.                                  | Report that no students are available when the repository is empty. |
| `EnrollmentServiceImpl`                  | Group courses and students while removing duplicate pairs.                 | N/A                                                                 |

## Controller Test Cases

| Component              | Successful cases                                                                 | Failure cases                                                           |
|------------------------|----------------------------------------------------------------------------------|-------------------------------------------------------------------------|
| `CourseController`     | Retrieve, create, update, and delete courses.                                    | Propagate the service exception when retrieving a non-existent course.  |
| `StudentController`    | Retrieve, create, update, and delete students, including the list sorted by age. | Propagate the service exception when retrieving a non-existent student. |
| `EnrollmentController` | Retrieve, create, update, delete, and retrieve the course-student summary.       | Propagate the exception when the associated student is not found.       |

## Verification Criteria

- Verify the HTTP status and response body for each controller response.
- Verify mock interactions using Mockito.
- Confirm that domain exceptions are thrown in negative scenarios.
- Run `gradlew.bat test` when finished.
