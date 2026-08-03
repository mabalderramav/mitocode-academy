package com.mitocode.academy.controller.enrollment;

import com.mitocode.academy.config.MapperConfig;
import com.mitocode.academy.dto.course.CourseDTO;
import com.mitocode.academy.dto.enrollment.EnrollmentDTO;
import com.mitocode.academy.dto.enrollment.EnrollmentDetailDTO;
import com.mitocode.academy.dto.student.StudentDTO;
import com.mitocode.academy.exception.ModelNotFoundException;
import com.mitocode.academy.model.Student;
import com.mitocode.academy.service.enrollment.IEnrollmentService;
import com.mitocode.academy.service.student.IStudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EnrollmentControllerTest {

    @Mock
    private IEnrollmentService service;
    @Mock
    private IStudentService studentService;

    private EnrollmentController controller;
    private EnrollmentDTO dto;

    @BeforeEach
    void init() {
        controller = new EnrollmentController(service, studentService, new MapperConfig());
        StudentDTO student = new StudentDTO(1, "Ana", "Pérez", "12345678", 20);
        CourseDTO course = new CourseDTO(1, "Java", "JAVA-1", true);
        EnrollmentDetailDTO detail = new EnrollmentDetailDTO(1, "Aula 1", null, course);
        dto = new EnrollmentDTO(1, student, LocalDateTime.of(2026, 1, 10, 9, 0), true, List.of(detail));
    }

    @Test
    void getEnrolledCoursesAndTheirCorrespondingStudents_shouldReturnServiceResult() {
        Map<String, List<String>> expected = Map.of("Java", List.of("Ana Pérez"));
        when(service.getEnrolledCoursesAndTheirCorrespondingStudents()).thenReturn(expected);

        ResponseEntity<Map<String, List<String>>> response = controller.getEnrolledCoursesAndTheirCorrespondingStudents();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expected, response.getBody());
    }

    @Test
    void save_shouldResolveStudentAndReturnCreated() {
        when(studentService.findById(1)).thenReturn(new Student(1, "Ana", "Pérez", "12345678", 20));

        ResponseEntity<Void> response = controller.save(dto);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        verify(service).save(any());
    }

    @Test
    void save_shouldPropagateErrorWhenStudentDoesNotExist() {
        when(studentService.findById(1)).thenThrow(new ModelNotFoundException("ID NOT FOUND: 1"));

        assertThrows(ModelNotFoundException.class, () -> controller.save(dto));
        verify(service, never()).save(any());
    }
}
