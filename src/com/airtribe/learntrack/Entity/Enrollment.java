package com.airtribe.learntrack.Entity;

import com.airtribe.learntrack.Exception.InvalidDateException;

import java.time.LocalDate;
import java.util.Date;

public class Enrollment {

    private int id;
    private int studentId;
    private int courseId;
    private LocalDate enrollmentDate;
    private STATUS status;

    @Override
    public String toString() {
        return "Enrollment{" +
                "id=" + this.getId() +
                ", studentId=" + this.getStudentId() +
                ", courseId=" + this.getCourseId() +
                ", enrollmentDate=" + this.getEnrollmentDate() +
                ", status=" + this.getStatus() +
                '}';
    }

    public String toString(String studentName, String courseName){
        return "Enrollment{" +
                "id=" + this.getId() +
                ", studentId=" + this.getStudentId() +
                ", studentName='" + studentName + '\'' +
                ", courseId=" + this.getCourseId() +
                ", courseName='" + courseName + '\'' +
                ", enrollmentDate=" + this.getEnrollmentDate() +
                ", status=" + this.getStatus() +
                '}';
    }

    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public LocalDate getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(LocalDate enrollmentDate) {
        if (enrollmentDate == null) {
            throw new InvalidDateException("Enrollment date can't be null");
        }
        if (enrollmentDate.isBefore(LocalDate.now())) {
            throw new InvalidDateException("Enrollment date can't be in past");
        }
        this.enrollmentDate = enrollmentDate;
    }

    public STATUS getStatus() {
        return status;
    }

    public void setStatus(STATUS status) {
        this.status = status;
    }

    public Enrollment(int id, int studentId, int courseId, LocalDate enrollmentDate, STATUS status) {
        this.setId(id);
        this.setCourseId(courseId);
        this.setStudentId(studentId);
        this.setEnrollmentDate(enrollmentDate);
        this.setStatus(status);
    }
}


