package com.mitocode.academy.service.student;

import com.mitocode.academy.model.Student;
import com.mitocode.academy.repository.student.IStudentRepository;
import com.mitocode.academy.service.common.CrudImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl extends CrudImpl<Student, Integer> implements IStudentService {

    private final IStudentRepository repository;

    @Override
    protected IStudentRepository getRepo() {
        return repository;
    }
}
