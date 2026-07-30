package com.mitocode.academy.service.student;

import com.mitocode.academy.exception.ModelNotFoundException;
import com.mitocode.academy.model.Student;
import com.mitocode.academy.service.common.ICrud;

import java.util.List;

public interface IStudentService extends ICrud<Student, Integer> {

    /**
     * List students sorted in descending order by age using functional programming.
     *
     * @return List of students sorted by age in descending order.
     * @throws ModelNotFoundException if no students are found.
     */
    List<Student> getStudentsOrderByAgeDesc();
}
