package com.mitocode.academy.service.student;

import com.mitocode.academy.exception.ModelNotFoundException;
import com.mitocode.academy.model.Student;
import com.mitocode.academy.repository.student.IStudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class StudentServiceImplTest {

    @Mock
    private IStudentRepository repository;

    @InjectMocks
    private StudentServiceImpl service;

    private Student junior;
    private Student senior;

    @BeforeEach
    void init() {
        junior = new Student(1, "Ana", "Pérez", "12345678", 20);
        senior = new Student(2, "Luis", "Gómez", "87654321", 32);
    }

    @Test
    void getStudentsOrderByAgeDesc_shouldSortStudentsByDescendingAge() {
        when(repository.findAll()).thenReturn(List.of(junior, senior));

        List<Student> result = service.getStudentsOrderByAgeDesc();

        assertEquals(List.of(senior, junior), result);
    }

    @Test
    void getStudentsOrderByAgeDesc_shouldThrowWhenThereAreNoStudents() {
        when(repository.findAll()).thenReturn(List.of());

        assertThrows(ModelNotFoundException.class, () -> service.getStudentsOrderByAgeDesc());
    }
}
