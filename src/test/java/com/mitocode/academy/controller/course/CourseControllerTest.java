package com.mitocode.academy.controller.course;

import com.mitocode.academy.config.MapperConfig;
import com.mitocode.academy.dto.course.CourseDTO;
import com.mitocode.academy.exception.ModelNotFoundException;
import com.mitocode.academy.model.Course;
import com.mitocode.academy.service.course.ICourseService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CourseControllerTest {

    @Mock
    private ICourseService service;

    private CourseController controller;
    private Course course;
    private CourseDTO dto;

    @BeforeEach
    void init() {
        controller = new CourseController(service, new MapperConfig());
        course = new Course(1, "Java avanzado", "JAVA-01", true);
        dto = new CourseDTO(1, "Java avanzado", "JAVA-01", true);
    }

    @Test
    void findAll_shouldReturnMappedCourses() {
        when(service.findAll()).thenReturn(List.of(course));

        ResponseEntity<List<CourseDTO>> response = controller.findAll();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(List.of(dto), response.getBody());
    }

    @Test
    void save_shouldReturnCreatedAndDelegateMappedCourse() {
        when(service.save(any(Course.class))).thenReturn(course);

        ResponseEntity<Void> response = controller.save(dto);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        verify(service).save(argThat(saved -> saved.getName().equals("Java avanzado")));
    }

    @Test
    void delete_shouldReturnNoContent() {
        ResponseEntity<Void> response = controller.delete(1);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(service).delete(1);
    }

    @Test
    void findById_shouldPropagateNotFoundError() {
        when(service.findById(99)).thenThrow(new ModelNotFoundException("ID NOT FOUND: 99"));

        assertThrows(ModelNotFoundException.class, () -> controller.findById(99));
    }
}
