package com.mitocode.academy.dto.course;

import com.fasterxml.jackson.annotation.JsonInclude;
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
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CourseDTO {

    private Integer courseId;

    @NotBlank(message = "Name is required, this is should be not blank.")
    @NotNull(message = "Name is required, this is should be not null.")
    @NotEmpty(message = "Name is required, this is should be not empty.")
    @Size(min = 3, max = 100, message = "Name must be between 3 and 100 characters.")
    private String name;

    @NotBlank(message = "Code is required, this is should be not blank.")
    @NotNull(message = "Code is required, this is should be not null.")
    @NotEmpty(message = "Code is required, this is should be not empty.")
    @Size(min = 3, max = 10, message = "Code must be between 3 and 10 characters.")
    private String code;

    @NotNull(message = "Active status is required, this is should be not null.")
    private Boolean isActive;
}
