package com.mitocode.academy.dto.student;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {

    private Integer studentId;
    private String firstsName;
    private String lastName;
    private String dni;
    private Integer age;
}
