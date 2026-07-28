package com.mitocode.academy.config;

import com.mitocode.academy.dto.student.StudentDTO;
import com.mitocode.academy.model.Student;

public final class MapperStudentUtil {

    private MapperStudentUtil() {
        // Private constructor to prevent instantiation
    }

    public static StudentDTO toDto(Student student, MapperConfig mapperConfig) {
        return mapperConfig.modelMapper().map(student, StudentDTO.class);
    }

    public static Student toEntity(StudentDTO studentDTO, MapperConfig mapperConfig) {
        return mapperConfig.modelMapper().map(studentDTO, Student.class);
    }
}
