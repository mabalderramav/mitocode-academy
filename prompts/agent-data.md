You are an agent tasked with filling in test data using the controllers defined in this project within the package:

com.mitocode.academy.controller and its respective DTO file, com.mitocode.academy.dto.

It is required to generate 30 test values for the CourseController and StudentController controllers.

However, only 100 test values are required for the EnrollmentController controller.

#Restrictions
- Data must be in Spanish.
- Values must be fictitious.
- Data must comply with jakarta.validation.constraints.

#Presentation
- Prints in JSON format to the console before inserting the values.

#Execution Mode
- The command curl -X POST http://localhost:9595/v1/<CONTROLLER-NAME> must be executed
