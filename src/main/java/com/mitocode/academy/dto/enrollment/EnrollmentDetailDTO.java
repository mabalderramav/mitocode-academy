package com.mitocode.academy.dto.enrollment;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import com.mitocode.academy.dto.course.CourseDTO;
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
public class EnrollmentDetailDTO {

    private Integer enrollmentDetailId;

    @NotBlank(message = "Classroom is required, this should not be blank.")
    @NotNull(message = "Classroom is required, this should not be null.")
    @NotEmpty(message = "Classroom is required, this should not be empty.")
    @Size(max = 50, message = "Classroom must not exceed 50 characters.")
    private String classroom;

    @JsonBackReference
    private EnrollmentDTO enrollment;

    @NotNull(message = "Course is required, this should not be null.")
    @JsonIncludeProperties({"courseId", "name", "isActive"})
    private CourseDTO course;
}
