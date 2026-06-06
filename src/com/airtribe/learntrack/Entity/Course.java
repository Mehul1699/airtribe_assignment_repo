package com.airtribe.learntrack.Entity;

import java.util.Objects;

public class Course {

    private int id;
    private String courseName;
    private String description;
    private int durationInWeeks;
    private boolean isActive = Boolean.TRUE;

    public Course(int id, String courseName, String description, int durationInWeeks) {
        this.setId(id);
        this.setCourseName(courseName);
        this.setDescription(description);
        this.setDurationInWeeks(durationInWeeks);
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + this.getId() +
                ", courseName='" + this.getCourseName() + '\'' +
                ", description='" + this.getDescription() + '\'' +
                ", durationInWeeks=" + this.getDurationInWeeks() +
                ", isActive=" + this.isActive() +
                '}';
    }

    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        if (courseName != null && !courseName.isEmpty()) {
            this.courseName = courseName;
        }
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if (description != null && !description.isEmpty()) {
            this.description = description;
        }
    }

    public int getDurationInWeeks() {
        return durationInWeeks;
    }

    public void setDurationInWeeks(int durationInWeeks) {
        if (durationInWeeks > 0) {
            this.durationInWeeks = durationInWeeks;
        }
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
