package com.mitocode.academy.service.student;

import com.mitocode.academy.model.Student;

import java.util.List;

public interface IStudentService {
    Student save(Student student);

    Student update(Integer studentId, Student student);

    List<Student> findAll();

    Student findById(Integer studentId);

    void delete(Integer studentId);
}
