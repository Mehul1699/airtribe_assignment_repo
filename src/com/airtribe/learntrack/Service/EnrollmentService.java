package com.airtribe.learntrack.Service;

import com.airtribe.learntrack.Entity.Course;
import com.airtribe.learntrack.Entity.Enrollment;
import com.airtribe.learntrack.Entity.STATUS;
import com.airtribe.learntrack.Entity.Student;
import com.airtribe.learntrack.Exception.EntityNotFoundException;
import com.airtribe.learntrack.util.IdGenerator;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EnrollmentService {

    private List<Enrollment> enrollments = new ArrayList<>();
    private final StudentService studentService;
    private final CourseService courseService;

    public EnrollmentService(StudentService studentService, CourseService courseService) {
        this.studentService = studentService;
        this.courseService = courseService;
    }

    public Enrollment enrollStudent(int studentId, int courseId, LocalDate enrollmentDate) throws EntityNotFoundException {

        Student student = studentService.searchStudentById(studentId);
        Course course = courseService.searchCourseById(courseId);

        if (student == null) {
            throw new EntityNotFoundException(String.format("Student not found with id %d , cannot enroll", studentId));
        }

        if (course == null) {
            throw new EntityNotFoundException(String.format("Course not found with id %d , cannot enroll", courseId));
        }

        Enrollment enrollment = new Enrollment(
                IdGenerator.getNextEnrollmentId(), studentId, courseId, enrollmentDate, STATUS.ACTIVE
        );

        enrollments.add(enrollment);

        return enrollment;

    }

    public void getStudentEnrollments(int id) throws EntityNotFoundException {

        Student student = studentService.searchStudentById(id);

        if (student == null) {
            throw new EntityNotFoundException(String.format("Student not found with id %d , cannot enroll", id));
        }

        String fullName = student.getFirstName() + " " + student.getLastName();

        boolean isEnrollmentExists = Boolean.FALSE;

        for (Enrollment enrollment : enrollments) {
            if (enrollment.getStudentId() == id) {
                Course course =
                        courseService.searchCourseById(enrollment.getCourseId());
                System.out.println(enrollment.toString(fullName, course.getCourseName()));
                isEnrollmentExists = Boolean.TRUE;
            }
        }

        if (!isEnrollmentExists) {
            System.out.println("Sorry! The mentioned student is not enrolled to any course");
        }

    }

    public void markEnrollmentCompleted(int id) throws EntityNotFoundException {

        Enrollment enrollment = searchEnrollmentById(id);

        if (enrollment == null) {
            throw new EntityNotFoundException(String.format("Enrollment not found with id %d , cannot be marked completed", id));
        }

        enrollment.setStatus(STATUS.COMPLETED);

    }

    public void markEnrollmentCancelled(int id) throws EntityNotFoundException {

        Enrollment enrollment = searchEnrollmentById(id);

        if (enrollment == null) {
            throw new EntityNotFoundException(String.format("Enrollment not found with id %d , cannot be marked cancelled", id));
        }

        enrollment.setStatus(STATUS.CANCELLED);

    }

    public Enrollment searchEnrollmentById(int id) {
        for (Enrollment enrollment : enrollments) {
            if (enrollment.getId() == id) {
                return enrollment;
            }
        }
        return null;
    }

}
