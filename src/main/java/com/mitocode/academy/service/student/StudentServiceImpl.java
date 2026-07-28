package com.mitocode.academy.service.student;

import com.mitocode.academy.model.Student;
import com.mitocode.academy.repository.student.IStudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements IStudentService {

    private final IStudentRepository repository;

    @Override
    public Student save(Student student) {
        return repository.save(student);
    }

    @Override
    public Student update(Integer studentId, Student student) {
        student.setStudentId(studentId);
        return repository.save(student);
    }

    @Override
    public List<Student> findAll() {
        return repository.findAll();
    }

    @Override
    public Student findById(Integer studentId) {
        return repository.findById(studentId).orElse(null);
    }

    @Override
    public void delete(Integer studentId) {
        repository.deleteById(studentId);
    }
}
