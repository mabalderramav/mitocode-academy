package com.mitocode.academy.config;

import com.mitocode.academy.dto.course.CourseDTO;
import com.mitocode.academy.model.Course;

public final class MapperCourseUtil {

    private MapperCourseUtil() {
        // Private constructor to prevent instantiation
    }

    public static CourseDTO toDto(Course course, MapperConfig mapperConfig) {
        return mapperConfig.modelMapper().map(course, CourseDTO.class);
    }

    public static Course toEntity(CourseDTO courseDTO, MapperConfig mapperConfig) {
        return mapperConfig.modelMapper().map(courseDTO, Course.class);
    }
}
