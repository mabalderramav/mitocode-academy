package com.mitocode.academy.service.enrollment;

import com.mitocode.academy.model.Enrollment;
import com.mitocode.academy.service.common.ICrud;

import java.util.List;
import java.util.Map;

public interface IEnrollmentService extends ICrud<Enrollment, Integer> {

    /**
     * Display the list of enrolled courses and their corresponding students
     * using functional programming (suggestion: use a Map<K,V>)
     *
     * @return A map where the key is the course name and the value is a list of student names enrolled in that course.
     */
    Map<String, List<String>> getEnrolledCoursesAndTheirCorrespondingStudents();
}
