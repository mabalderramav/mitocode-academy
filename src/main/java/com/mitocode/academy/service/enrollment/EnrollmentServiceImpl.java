package com.mitocode.academy.service.enrollment;

import com.mitocode.academy.model.Enrollment;
import com.mitocode.academy.repository.enrollment.IEnrollmentRepository;
import com.mitocode.academy.service.common.CrudImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EnrollmentServiceImpl extends CrudImpl<Enrollment, Integer> implements IEnrollmentService {

    private final IEnrollmentRepository repository;

    @Override
    protected IEnrollmentRepository getRepo() {
        return repository;
    }
}
