package com.mitocode.academy.service.enrollment;

import com.mitocode.academy.model.Enrollment;
import com.mitocode.academy.repository.enrollment.IEnrollmentRepository;
import com.mitocode.academy.service.common.CrudImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.mitocode.academy.service.enrollment.EnrollmentServiceHelper.getDistinctCourseStudentEntryStream;

@Service
@RequiredArgsConstructor
public class EnrollmentServiceImpl extends CrudImpl<Enrollment, Integer> implements IEnrollmentService {

    private final IEnrollmentRepository repository;

    @Override
    protected IEnrollmentRepository getRepo() {
        return repository;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Map<String, List<String>> getEnrolledCoursesAndTheirCorrespondingStudents() {
        Stream<Enrollment> enrollmentStream = repository.findAll().stream();
        return getDistinctCourseStudentEntryStream(enrollmentStream).collect(Collectors.groupingBy(Map.Entry::getKey,
                Collectors.mapping(Map.Entry::getValue, Collectors.toList())));
    }
}
