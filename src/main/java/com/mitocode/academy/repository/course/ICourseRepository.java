package com.mitocode.academy.repository.course;

import com.mitocode.academy.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICourseRepository extends JpaRepository<Course, Integer> {
}
