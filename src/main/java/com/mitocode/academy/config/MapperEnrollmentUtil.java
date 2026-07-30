package com.mitocode.academy.config;

import com.mitocode.academy.dto.enrollment.EnrollmentDTO;
import com.mitocode.academy.dto.student.StudentDTO;
import com.mitocode.academy.model.Enrollment;
import com.mitocode.academy.model.Student;

public final class MapperEnrollmentUtil {

    private MapperEnrollmentUtil() {
    }

    public static EnrollmentDTO toDto(Enrollment enrollment, MapperConfig mapperConfig) {
        EnrollmentDTO enrollmentDTO = mapperConfig.modelMapper().map(enrollment, EnrollmentDTO.class);
        enrollmentDTO.setStudent(mapperConfig.modelMapper().map(enrollment.getStudent(), StudentDTO.class));
        return enrollmentDTO;
    }

    public static Enrollment toEntity(EnrollmentDTO enrollmentDTO, Student student, MapperConfig mapperConfig) {
        Enrollment enrollment = mapperConfig.modelMapper().map(enrollmentDTO, Enrollment.class);
        enrollment.setStudent(student);
        enrollment.getEnrollmentDetails().forEach(detail -> detail.setEnrollment(enrollment));
        return enrollment;
    }
}
