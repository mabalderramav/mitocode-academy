package com.mitocode.academy.controller.course;

import com.mitocode.academy.model.Course;
import com.mitocode.academy.service.course.ICourseService;
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
@RequestMapping("/v1/courses")
@RequiredArgsConstructor
public class CourseController {

    private final ICourseService service;

    @GetMapping
    public ResponseEntity<List<Course>> findAll() {
        List<Course> courses = service.findAll();
        return ResponseEntity.ok(courses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Course> findById(@PathVariable Integer id) {
        Course course = service.findById(id);
        return ResponseEntity.ok(course);
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody Course course) {
        Course _ = service.save(course);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Course> update(@PathVariable Integer id, @RequestBody Course course) {
        Course updatedCourse = service.update(id, course);
        return ResponseEntity.ok(updatedCourse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
