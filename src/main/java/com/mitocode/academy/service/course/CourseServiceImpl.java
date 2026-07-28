package com.mitocode.academy.service.course;

import com.mitocode.academy.model.Course;
import com.mitocode.academy.repository.course.ICourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements ICourseService {

    private final ICourseRepository repository;

    @Override
    public Course save(Course course) {
        return repository.save(course);
    }

    @Override
    public Course update(Integer courseId, Course course) {
        course.setCourseId(courseId);
        return repository.save(course);
    }

    @Override
    public List<Course> findAll() {
        return repository.findAll();
    }

    @Override
    public Course findById(Integer courseId) {
        return repository
                .findById(courseId)
                .orElse(new Course(0,"","",false));
    }

    @Override
    public void delete(Integer courseId) {
        repository.deleteById(courseId);
    }
}
