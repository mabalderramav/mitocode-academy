package com.mitocode.academy.controller.enrollment;

import com.mitocode.academy.config.MapperConfig;
import com.mitocode.academy.dto.enrollment.EnrollmentDTO;
import com.mitocode.academy.model.Enrollment;
import com.mitocode.academy.model.Student;
import com.mitocode.academy.service.enrollment.IEnrollmentService;
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

import static com.mitocode.academy.config.MapperEnrollmentUtil.toDto;
import static com.mitocode.academy.config.MapperEnrollmentUtil.toEntity;

@RestController
@RequestMapping("/v1/enrollments")
@RequiredArgsConstructor
public class EnrollmentController {

    private final IEnrollmentService service;
    private final IStudentService studentService;
    private final MapperConfig mapperConfig;

    @GetMapping
    public ResponseEntity<List<EnrollmentDTO>> findAll() {
        List<EnrollmentDTO> enrollmentDTOs = service.findAll().stream()
                .map(enrollment -> toDto(enrollment, mapperConfig))
                .toList();
        return ResponseEntity.ok(enrollmentDTOs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnrollmentDTO> findById(@PathVariable Integer id) {
        Enrollment enrollment = service.findById(id);
        return ResponseEntity.ok(toDto(enrollment, mapperConfig));
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody EnrollmentDTO enrollmentDTO) {
        service.save(toEntity(enrollmentDTO, findStudent(enrollmentDTO), mapperConfig));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<EnrollmentDTO> update(@PathVariable Integer id, @Valid @RequestBody EnrollmentDTO enrollmentDTO) {
        Enrollment enrollment = toEntity(enrollmentDTO, findStudent(enrollmentDTO), mapperConfig);
        enrollment.setEnrollmentId(id);
        Enrollment updatedEnrollment = service.update(id, enrollment);
        return ResponseEntity.ok(toDto(updatedEnrollment, mapperConfig));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    private Student findStudent(EnrollmentDTO enrollmentDTO) {
        return studentService.findById(enrollmentDTO.getStudent().getStudentId());
    }
}
