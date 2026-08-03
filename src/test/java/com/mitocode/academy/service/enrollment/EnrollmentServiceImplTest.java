package com.mitocode.academy.service.enrollment;

import com.mitocode.academy.model.Course;
import com.mitocode.academy.model.Enrollment;
import com.mitocode.academy.model.EnrollmentDetail;
import com.mitocode.academy.model.Student;
import com.mitocode.academy.repository.enrollment.IEnrollmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EnrollmentServiceImplTest {

    @Mock
    private IEnrollmentRepository repository;

    @InjectMocks
    private EnrollmentServiceImpl service;

    private Enrollment enrollment;

    @BeforeEach
    void init() {
        Student student = new Student(1, "Lucía", "Torres", "12345678", 24);
        enrollment = new Enrollment();
        enrollment.setStudent(student);
        Course course = new Course(1, "Arquitectura", "ARQ-01", true);
        EnrollmentDetail detail = new EnrollmentDetail(1, "Aula 3", course, enrollment);
        enrollment.setEnrollmentDetails(List.of(detail, detail));
    }

    @Test
    void getEnrolledCoursesAndTheirCorrespondingStudents_shouldGroupAndRemoveDuplicates() {
        when(repository.findAll()).thenReturn(List.of(enrollment));

        Map<String, List<String>> result = service.getEnrolledCoursesAndTheirCorrespondingStudents();

        assertEquals(Map.of("Arquitectura", List.of("Lucía Torres")), result);
    }
}
