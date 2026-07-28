package com.mitocode.academy.dto.course;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseDTO {

    private Integer courseId;
    private String name;
    private String code;
    private Boolean isActive;
}
