package com.mitocode.academy.controller.student;

import com.mitocode.academy.config.MapperConfig;
import com.mitocode.academy.dto.student.StudentDTO;
import com.mitocode.academy.model.Student;
import com.mitocode.academy.service.student.IStudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.mitocode.academy.config.MapperStudentUtil.toDto;
import static com.mitocode.academy.config.MapperStudentUtil.toEntity;

@RestController
@RequestMapping("/v1/students")
@RequiredArgsConstructor
public class StudentController {

    private final IStudentService service;
    private final MapperConfig mapperConfig;

    @GetMapping
    public ResponseEntity<List<StudentDTO>> findAll() {
        List<Student> students = service.findAll();
        List<StudentDTO> studentDTOs = students.stream()
                .map(student -> toDto(student, mapperConfig))
                .toList();
        return ResponseEntity.ok(studentDTOs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDTO> findById(@PathVariable Integer id) {
        Student student = service.findById(id);
        StudentDTO studentDTO = toDto(student, mapperConfig);
        return ResponseEntity.ok(studentDTO);
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody StudentDTO studentDTO) {
        Student student = toEntity(studentDTO, mapperConfig);
        Student _ = service.save(student);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentDTO> update(@PathVariable Integer id, @Valid @RequestBody StudentDTO studentDTO) {
        Student student = toEntity(studentDTO, mapperConfig);
        Student updatedStudent = service.update(id, student);
        StudentDTO updatedStudentDTO = toDto(updatedStudent, mapperConfig);
        return ResponseEntity.ok(updatedStudentDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
