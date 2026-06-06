package com.airtribe.learntrack.ui;

import com.airtribe.learntrack.Constants.MenuOptions;
import com.airtribe.learntrack.Entity.Course;
import com.airtribe.learntrack.Entity.Enrollment;
import com.airtribe.learntrack.Entity.Student;
import com.airtribe.learntrack.Exception.EntityNotFoundException;
import com.airtribe.learntrack.Exception.InvalidDateException;
import com.airtribe.learntrack.Service.CourseService;
import com.airtribe.learntrack.Service.EnrollmentService;
import com.airtribe.learntrack.Service.StudentService;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    static void main() {

        Scanner scanner = new Scanner(System.in);

        StudentService studentService = new StudentService();
        CourseService courseService = new CourseService();
        EnrollmentService enrollmentService =
                new EnrollmentService(studentService, courseService);

        boolean running = Boolean.TRUE;

        while (running) {
            try {
                System.out.println("What data do you want to store? (Student/Course/Enrollment): ");
                String choice = scanner.nextLine();
                switch (choice) {
                    case MenuOptions.STUDENT_MANAGEMENT:
                        displayStudentMenu(scanner, studentService);
                        break;

                    case MenuOptions.COURSE_MANAGEMENT:
                        displayCourseMenu(scanner, courseService);
                        break;

                    case MenuOptions.ENROLLMENT_MANAGEMENT:
                        displayEnrollmentMenu(scanner, enrollmentService);
                        break;

                    default:
                        System.out.println("Invalid choice");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

            System.out.println("Do you want to continue? (Y/N): ");

            String response = scanner.nextLine();

            if (response.equalsIgnoreCase("N")) {
                running = Boolean.FALSE;
            }
        }

        System.out.println("=======Displaying Stored data=======");

        studentService.viewAllStudents();
        courseService.viewAllCourses();

        System.out.println("Do you want to see enrollments against any student? (Y/N): ");

        String response = scanner.nextLine();
        if (response.equalsIgnoreCase("Y")) {
            System.out.println("Please enter student id for checking enrollment: ");
            int studentId = 0;
            try {
                studentId = Integer.parseInt(scanner.nextLine());
                enrollmentService.getStudentEnrollments(studentId);
            } catch (Exception ex) {
                System.out.println("Error in converting duration");
            }
        }

        System.out.println("Application closed. Thank you!");

    }

    public static void displayStudentMenu(Scanner scanner, StudentService studentService) {
        System.out.println("Enter first name: ");
        String firstName = scanner.nextLine();

        System.out.println("Enter last name: ");
        String lastName = scanner.nextLine();

        System.out.println("Enter email: ");
        String email = scanner.nextLine();

        System.out.println("Enter batch: ");
        String batch = scanner.nextLine();

        Student student = studentService.addNewStudent(firstName, lastName, email, batch);

        System.out.println("Student added successfully with: " + student.getId());
    }

    public static void displayCourseMenu(Scanner scanner, CourseService courseService) {
        System.out.println("Enter course name: ");
        String courseName = scanner.nextLine();

        System.out.println("Enter course description: ");
        String courseDescription = scanner.nextLine();

        System.out.println("Enter duration of course in weeks time: ");
        int durationInWeeks = 0;
        try {
            durationInWeeks = Integer.parseInt(scanner.nextLine());
        } catch (Exception ex) {
            System.out.println("Error in converting duration");
        }

        Course course = courseService.addNewCourse(courseName, courseDescription, durationInWeeks);

        System.out.println("Course added successfully with id: " + course.getId());
    }

    public static void displayEnrollmentMenu(Scanner scanner, EnrollmentService enrollmentService) {
        System.out.println("Enter student id: ");
        int studentId = 0;
        try {
            studentId = Integer.parseInt(scanner.nextLine());
        } catch (Exception ex) {
            System.out.println("Invalid student id");
        }

        System.out.println("Enter course id: ");
        int courseId = 0;
        try {
            courseId = Integer.parseInt(scanner.nextLine());
        } catch (Exception ex) {
            System.out.println("Invalid course id");
        }

        System.out.print("Enter enrollment date (yyyy-MM-dd): ");
        String dateInput = scanner.nextLine();

        LocalDate enrollmentDate = LocalDate.parse(dateInput);

        Enrollment enrollment = null;
        try {
            enrollment = enrollmentService.enrollStudent(studentId, courseId, enrollmentDate);
        } catch (EntityNotFoundException | InvalidDateException e) {
            System.out.println("Error: " + e.getMessage());
        }

        if (enrollment != null) {
            System.out.println("Enrollment saved with id: " + enrollment.getId());
        }
    }

}
