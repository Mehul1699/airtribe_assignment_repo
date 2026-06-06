package com.airtribe.learntrack.Service;

import com.airtribe.learntrack.Entity.Course;
import com.airtribe.learntrack.Exception.EntityNotFoundException;
import com.airtribe.learntrack.util.IdGenerator;

import java.util.ArrayList;
import java.util.List;

public class CourseService {

    private List<Course> courses = new ArrayList<>();

    public Course addNewCourse(String courseName, String description, int durationInWeeks) {
        Course course = new Course(
                IdGenerator.getNextCourseId(), courseName, description, durationInWeeks
        );

        courses.add(course);
        return course;
    }

    public void addNewCourse(Course course) {
        if (course != null) {
            courses.add(course);
        }
    }

    public Course searchCourseById(int id) {
        for (Course course : courses) {
            if (course.getId() == id) {
                return course;
            }
        }
        return null;
    }

    public void viewAllCourses() {
        System.out.println(courses);
    }

    public void deactivateCourse(int id) throws EntityNotFoundException {
        Course course = searchCourseById(id);
        if (course == null) {
            throw new EntityNotFoundException(String.format("Course not found with id %d , cannot deactivate", id));
        }
        course.setActive(Boolean.FALSE);
    }

    public void activateCourse(int id) throws EntityNotFoundException {
        Course course = searchCourseById(id);
        if (course == null) {
            throw new EntityNotFoundException(String.format("Course not found with id %d , cannot activate", id));
        }
        course.setActive(Boolean.TRUE);
    }

}
