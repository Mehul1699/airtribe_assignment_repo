# Student & Course Management System

## Author
Mehul

## Project description

This is a simple JAVA console based application that stimulates a Student Course Enrollment System.

The application allows user to:

- Add and manage students
- Add and manage courses
- Enroll students into courses
- View enrollment information


## Features
- Object-Oriented Design using Java classes
- Separate Service classes for business logic
- In-memory data storage using collections (ArrayList)
- User interaction through console input
- Automatic ID generation for entities
- Data validation to ensure accuracy

## Project Structure
* **Student** – Represents a student.
* **Course** – Represents a course.
* **Enrollment** – Represents a student's enrollment in a course.
* **StudentService** – Handles student-related operations.
* **CourseService** – Handles course-related operations.
* **EnrollmentService** – Handles enrollment-related operations.
* **IdGenerator** – Generates unique IDs.
* **Main** – Entry point of the application.



## Class Relationships

Person

└── Student (extends Person class)

Enrollment

├── Student

└── Course

StudentService → Student

CourseService → Course

EnrollmentService → Enrollment



## How to Compile and Run

**Compile**

Open terminal in the project root directory and run:

javac *.java

**Run**

Main.java