package com.mitocode.academy.service.course;

import com.mitocode.academy.model.Course;

import java.util.List;

public interface ICourseService {
    Course save(Course course);

    Course update(Integer courseId, Course course);

    List<Course> findAll();

    Course findById(Integer courseId);

    void delete(Integer courseId);
}
