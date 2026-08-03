package com.mitocode.academy.service.course;

import com.mitocode.academy.exception.ModelNotFoundException;
import com.mitocode.academy.model.Course;
import com.mitocode.academy.repository.course.ICourseRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CourseServiceImplTest {

    @Mock
    private ICourseRepository repository;

    @InjectMocks
    private CourseServiceImpl service;

    private Course course;

    @BeforeEach
    void init() {
        course = new Course(1, "Java avanzado", "JAVA-01", true);
    }

    @Test
    void save_shouldDelegateToRepository() {
        when(repository.save(course)).thenReturn(course);

        Course saved = service.save(course);

        assertEquals(course, saved);
        verify(repository).save(course);
    }

    @Test
    void findById_shouldReturnCourseWhenPresent() {
        when(repository.findById(1)).thenReturn(Optional.of(course));

        assertEquals(course, service.findById(1));
    }

    @Test
    void findById_shouldThrowWhenMissing() {
        when(repository.findById(99)).thenReturn(Optional.empty());

        assertThrows(ModelNotFoundException.class, () -> service.findById(99));
    }

    @Test
    void update_shouldAssignIdAndSaveExistingCourse() throws Exception {
        Course changed = new Course(null, "Spring Boot", "SPRING-1", true);
        when(repository.findById(1)).thenReturn(Optional.of(course));
        when(repository.save(changed)).thenReturn(changed);

        Course updated = service.update(1, changed);

        assertEquals(1, updated.getCourseId());
        verify(repository).save(changed);
    }

    @Test
    void delete_shouldThrowWhenCourseDoesNotExist() {
        when(repository.existsById(99)).thenReturn(false);

        assertThrows(ModelNotFoundException.class, () -> service.delete(99));
        verify(repository, never()).deleteById(anyInt());
    }
}
