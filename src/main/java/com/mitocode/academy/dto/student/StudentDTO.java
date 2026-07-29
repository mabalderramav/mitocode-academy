package com.mitocode.academy.dto.student;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {

    private Integer studentId;

    @NotBlank(message = "First name is required, this is should be not blank.")
    @NotNull(message = "First name is required, this is should be not null.")
    @NotEmpty(message = "First name is required, this is should be not empty.")
    @Size(min = 3, max = 50, message = "First name must be between 3 and 50 characters.")
    private String firstsName;

    @NotBlank(message = "Last name is required, this is should be not blank.")
    @NotNull(message = "Last name is required, this is should be not null.")
    @NotEmpty(message = "Last name is required, this is should be not empty.")
    @Size(min = 3, max = 100, message = "Last name must be between 3 and 100 characters.")
    private String lastName;

    @NotBlank(message = "DNI is required, this is should be not blank.")
    @NotNull(message = "DNI is required, this is should be not null.")
    @NotEmpty(message = "DNI is required, this is should be not empty.")
    @Size(min = 3, max = 20, message = "DNI must be between 3 and 20 characters.")
    private String dni;

    @NotBlank(message = "Age is required, this is should be not blank.")
    @NotNull(message = "Age is required, this is should be not null.")
    @NotEmpty(message = "Age is required, this is should be not empty.")
    private Integer age;
}
