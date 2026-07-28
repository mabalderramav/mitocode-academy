package com.mitocode.academy.service.course;

import com.mitocode.academy.model.Course;
import com.mitocode.academy.repository.course.ICourseRepository;
import com.mitocode.academy.service.common.CrudImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl extends CrudImpl<Course, Integer> implements ICourseService {

    private final ICourseRepository repository;

    @Override
    protected ICourseRepository getRepo() {
        return repository;
    }
}
