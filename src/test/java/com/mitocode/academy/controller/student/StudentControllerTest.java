package com.mitocode.academy.controller.student;

import com.mitocode.academy.config.MapperConfig;
import com.mitocode.academy.dto.student.StudentDTO;
import com.mitocode.academy.model.Student;
import com.mitocode.academy.service.student.IStudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class StudentControllerTest {

    @Mock
    private IStudentService service;

    private StudentController controller;
    private Student student;

    @BeforeEach
    void init() {
        controller = new StudentController(service, new MapperConfig());
        student = new Student(1, "Ana", "Pérez", "12345678", 20);
    }

    @Test
    void getStudentsOrderByAgeDesc_shouldReturnMappedStudents() {
        when(service.getStudentsOrderByAgeDesc()).thenReturn(List.of(student));

        ResponseEntity<List<StudentDTO>> response = controller.getStudentsOrderByAgeDesc();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Ana", response.getBody().getFirst().getFirstsName());
    }
}
