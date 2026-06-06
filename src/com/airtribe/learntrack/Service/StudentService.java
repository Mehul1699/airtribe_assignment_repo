package com.airtribe.learntrack.Service;

import com.airtribe.learntrack.Entity.Student;
import com.airtribe.learntrack.Exception.EntityNotFoundException;
import com.airtribe.learntrack.util.IdGenerator;

import java.util.ArrayList;
import java.util.List;

public class StudentService {

    private List<Student> students = new ArrayList<>();

    public Student addNewStudent(String firstName, String lastName, String email, String batch) {
        Student student = new Student(
                IdGenerator.getNextStudentId(), firstName, lastName, email, batch
        );

        students.add(student);
        return student;
    }

    public void addStudent(Student student) {
        if (student != null) {
            students.add(student);
        }
    }

    public void updateStudent(int id, String firstName, String lastName, String email, String batch) throws EntityNotFoundException {
        Student student = searchStudentById(id);
        if (student == null) {
            throw new EntityNotFoundException(String.format("Student doesn't exist with id %d", id));
        }
        student.setFirstName(firstName);
        student.setLastName(lastName);
        student.setEmail(email);
        student.setBatch(batch);
    }

    public Student searchStudentById(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    public void viewAllStudents() {
        System.out.println(students);
    }

    public void deactivateStudent(int id) throws EntityNotFoundException {
        Student student = searchStudentById(id);
        if (student == null) {
            throw new EntityNotFoundException(String.format("Student doesn't exist with id %d , cannot deactivate", id));
        }
        student.setActive(Boolean.FALSE);
    }

}
