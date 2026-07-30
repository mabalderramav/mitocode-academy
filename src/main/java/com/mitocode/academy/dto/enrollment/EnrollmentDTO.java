package com.mitocode.academy.dto.enrollment;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.mitocode.academy.dto.student.StudentDTO;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EnrollmentDTO {

    private Integer enrollmentId;

    @NotNull(message = "Student is required, this should not be null.")
    @JsonIncludeProperties({"studentId", "firstsName", "lastName"})
    private StudentDTO student;

    @NotNull(message = "Enrollment date is required, this should not be null.")
    private LocalDateTime enrollmentDate;

    @NotNull(message = "Active status is required, this should not be null.")
    private Boolean isActive;

    @NotNull(message = "Enrollment details are required, this should not be null.")
    @JsonManagedReference
    private List<EnrollmentDetailDTO> enrollmentDetails;
}
