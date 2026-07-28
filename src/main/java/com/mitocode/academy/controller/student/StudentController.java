package com.mitocode.academy.controller.student;

import com.mitocode.academy.model.Student;
import com.mitocode.academy.service.student.IStudentService;
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

@RestController
@RequestMapping("/v1/students")
@RequiredArgsConstructor
public class StudentController {

    private final IStudentService service;

    @GetMapping
    public ResponseEntity<List<Student>> findAll() {
        List<Student> students = service.findAll();
        return ResponseEntity.ok(students);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> findById(@PathVariable Integer id) {
        Student student = service.findById(id);
        return ResponseEntity.ok(student);
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody Student student) {
        Student _ = service.save(student);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> update(@PathVariable Integer id, @RequestBody Student student) {
        Student updatedStudent = service.update(id, student);
        return ResponseEntity.ok(updatedStudent);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
