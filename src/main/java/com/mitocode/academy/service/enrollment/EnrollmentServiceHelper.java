package com.mitocode.academy.service.enrollment;

import com.mitocode.academy.model.Course;
import com.mitocode.academy.model.Enrollment;
import com.mitocode.academy.model.EnrollmentDetail;
import com.mitocode.academy.model.Student;

import java.util.Map;
import java.util.stream.Stream;

public final class EnrollmentServiceHelper {

    private EnrollmentServiceHelper() {
        // Private constructor to prevent instantiation
    }

    public static Stream<Map.Entry<String, String>> getDistinctCourseStudentEntryStream(
            Stream<Enrollment> enrollmentStream) {
        Stream<Map.Entry<String, String>> courseStudentEntryStream =
                enrollmentStream.flatMap(EnrollmentServiceHelper::getEnrollmentStream);
        return courseStudentEntryStream.distinct();
    }

    private static Stream<Map.Entry<String, String>> getEnrollmentStream(Enrollment enrollment) {
        return enrollment.getEnrollmentDetails().stream().map(EnrollmentServiceHelper::getEnrollmentDetailMapEntry);
    }

    private static Map.Entry<String, String> getEnrollmentDetailMapEntry(EnrollmentDetail detail){
        return Map.entry(getCourseName(detail.getCourse()), getFullName(detail.getEnrollment().getStudent()));
    }

    private static String getCourseName(Course course) {
        return course.getName();
    }

    private static String getFullName(Student student) {
        return student.getFirstsName().concat(" ").concat(student.getLastName());
    }
}
