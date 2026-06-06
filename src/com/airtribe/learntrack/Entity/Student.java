package com.airtribe.learntrack.Entity;

public class Student extends Person {

    private String batch;
    private boolean isActive = Boolean.TRUE;

    public Student(int id, String firstName, String lastName, String email, String batch) {
        super(id, firstName, lastName, email);
        this.setBatch(batch);
    }

    public Student(int id, String firstName, String lastName, String batch) {
        super(id, firstName, lastName);
        this.setBatch(batch);
    }

    @Override
    public String toString() {
        return "Student{" +
                super.toString() +
                ", batch='" + getBatch() + '\'' +
                ", isActive=" + isActive() + '\'' +
                '}';
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        if (batch != null && !batch.isEmpty()) {
            this.batch = batch;
        }
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    @Override
    public void getDisplayName() {
        System.out.println("Name of the student is: " + this.getFirstName() + " " + this.getLastName());
    }
}
