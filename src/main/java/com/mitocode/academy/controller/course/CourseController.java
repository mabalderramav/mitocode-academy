package com.mitocode.academy.controller.course;

import com.mitocode.academy.config.MapperConfig;
import com.mitocode.academy.dto.course.CourseDTO;
import com.mitocode.academy.model.Course;
import com.mitocode.academy.service.course.ICourseService;
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

import static com.mitocode.academy.config.MapperCourseUtil.toDto;
import static com.mitocode.academy.config.MapperCourseUtil.toEntity;

@RestController
@RequestMapping("/v1/courses")
@RequiredArgsConstructor
public class CourseController {

    private final ICourseService service;
    private final MapperConfig mapperConfig;

    @GetMapping
    public ResponseEntity<List<CourseDTO>> findAll() {
        List<Course> courses = service.findAll();
        List<CourseDTO> courseDTOs = courses.stream()
                .map(course -> toDto(course, mapperConfig))
                .toList();
        return ResponseEntity.ok(courseDTOs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseDTO> findById(@PathVariable Integer id) {
        Course course = service.findById(id);
        CourseDTO courseDTO = toDto(course, mapperConfig);
        return ResponseEntity.ok(courseDTO);
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody CourseDTO courseDTO) {
        Course course = toEntity(courseDTO, mapperConfig);
        Course _ = service.save(course);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<CourseDTO> update(@PathVariable Integer id, @Valid @RequestBody CourseDTO courseDTO) {
        Course course = toEntity(courseDTO, mapperConfig);
        Course updatedCourse = service.update(id, course);
        CourseDTO updatedCourseDTO = toDto(updatedCourse, mapperConfig);
        return ResponseEntity.ok(updatedCourseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
