/*-----------------------------------------------------
Miniproject1
Written by: 2022901057 [Farah Ammoura] + 2022901019[Aya Zeyad]
-----------------------------------------------------*/
import java.util.Scanner;
class User {
    protected String username;
    protected String password;
    protected String name;
    protected String role;

    // Constructor for User class
    public User(String username, String password, String name, String role) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.role = role;
    }

    // Method to display user details.
    public void displayDetails() {
        System.out.println("Username: " + username);
        System.out.println("Name: " + name);
        System.out.println("Role: " + role);
    }
}

// Class representing a Student, which inheritce from the User class.
class Student extends User {
    private String studentID;
    private Course[] coursesstd;

    // Constructor for Student class .
    public Student(String username, String password, String name, String studentID) {
        super(username, password, name, "Student");
        this.studentID = studentID;
        this.coursesstd = new Course[10]; 
    }

    // Method to add a course to the student's list of courses.
    public void addCourse(Course course) {
        int i = 0;
        while (i < coursesstd.length && coursesstd[i] != null) {
            i++;
        }
        if (i < coursesstd.length) {
            coursesstd[i] = course;
        } else {
            System.out.println("Cannot add more coursesstd.");
        }
    }
    

    // Method to remove a course from the student's list of courses.
    public void removeCourse(Course course) {
        int i = 0;
        while (i < coursesstd.length && (coursesstd[i] == null || !coursesstd[i].equals(course))) {
            i++;
        }
        if (i < coursesstd.length) {
            coursesstd[i] = null;
        } else {
            System.out.println("Course not found.");
        }
    }
    

    // Overridden method to display student details, including enrolled courses.
    
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Student ID: " + studentID + "\nEnrolled courses: ");
        for (Course course : coursesstd) {
            if (course != null) {
                System.out.println(" - " + course.getCourseName());
            }
        }
    }
}

// Class representing an Instructor, which inherite from the User class.
class Instructor extends User {
    private String instructorID;
    private Course[] courses;

    // Constructor for the class Instructor  
    public Instructor(String username, String password, String name, String instructorID) {
        super(username, password, name, "Instructor");
        this.instructorID = instructorID;
        this.courses = new Course[10]; 
    }

    // Method to add a course to the instructor's list of courses.
    public void addCourse(Course course) {
        int i = 0;
        while (i < courses.length && courses[i] != null) {
            i++;
        }
        if (i < courses.length) {
            courses[i] = course;
        } else {
            System.out.println("Cannot add more courses.");
        }
    }
        // Method to remove a course from the instructor's list of courses.

    public void removeCourse(Course course) {
        int i = 0;
        while (i < courses.length && (courses[i] == null || !courses[i].equals(course))) {
            i++;
        }
        if (i < courses.length) {
            courses[i] = null;
        } else {
            System.out.println("Course not found.");
        }
    }

    // Overridden method to display instructor details, including assigned courses.
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Instructor ID: " + instructorID + "\nAssigned Courses: ");
        for (Course course : courses) {
            if (course != null) {
                System.out.println(" - " + course.getCourseName());
            }
        }
    }
}

// Class representing a Course.
class Course {
    private String courseID;
    private String courseName;
    private Instructor instructor;
    private Student[] students;
    private Assignment[] assignments;

    // Constructor to initialize Course class
    public Course(String courseID, String courseName, Instructor instructor) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.instructor = instructor;
        this.students = new Student[50]; 
        this.assignments = new Assignment[20]; 
    }

    // Method to get the course name.
    public String getCourseName() {
        return courseName;
    }

    // Method to add a student to the course.
public void addStudent(Student student) {
    int i = 0;
    while (i < students.length && students[i] != null) {
        i++;
    }
    if (i < students.length) {
        students[i] = student; 
    } else {
        System.out.println("Cannot add more students."); 
    }
}
// Method to remove a student from the course.
public void removeStudent(Student student) {
    int i = 0;
    while (i < students.length && students[i] != student) {
        i++; 
    }
    if (i < students.length) {
        students[i] = null; 
    } else {
        System.out.println("Student not found.");
    }
}


    // Method to remove an assignment from the course.
public void removeAssignment(Assignment assignment) {
    int i = 0;
    while (i < assignments.length && assignments[i] != assignment) {
        i++; 
    }
    if (i < assignments.length) {
        assignments[i] = null;
    } else {
        System.out.println("Assignment not found."); 
    }
}

// Method to display students enrolled in the course.
public void displayStudents() {
    System.out.println("Students enrolled in " + courseName + ":");
    int i = 0;
    while (i < students.length) {
        if (students[i] != null) {
            System.out.println(" - " + students[i].name); 
        }
        i++;
    }
}
    // Method to display assignments in the course.
    public void displayAssignments() {
        System.out.println("Assignments for " + courseName + ":");
        for (Assignment assignment : assignments) {
            if (assignment != null) {
                System.out.println(" - " + assignment.getTitle());
            }
        }
    }

    // Method to display course class details.
    public void displayDetails() {
        System.out.println("Course ID: " + courseID);
        System.out.println("Course Name: " + courseName);
        System.out.println("Instructor: " + instructor.name);
    }
}

// Assignment Class
class Assignment {
    private String assignmentID;
    private String title;
    private String description;
    private String dueDate;
    private Submission[] submissions;

    // Constructor to initialize the Assignment class
    public Assignment(String assignmentID, String title, String description, String dueDate) {
        this.assignmentID = assignmentID;
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.submissions = new Submission[50]; 
    }

    // Method to get the assignment title.
    public String getTitle() {
        return title;
    }

    // Method to add a submission to the assignment.
public void addSubmission(Submission submission) {
    int i = 0;
    while (i < submissions.length && submissions[i] != null) {
        i++; 
    }
    if (i < submissions.length) {
        submissions[i] = submission; 
    } else {
        System.out.println("Cannot add more submissions."); 
    }
}

// Method to remove a submission from the assignment.
public void removeSubmission(Submission submission) {
    int i = 0;
    while (i < submissions.length && !submission.equals(submissions[i])) {
        i++;
    }
}


    // Method to display submissions for the assignment.
    public void displaySubmissions() {
        System.out.println("Submissions for " + title + ":");
        for (Submission submission : submissions) {
            if (submission != null) {
                System.out.println(" - " + submission.getContent() + " (Grade: " + submission.getGrade() + ")");
            }
        }
    }

    // Method to display assignment details.
    public void displayDetails() {
        System.out.println("Assignment ID: " + assignmentID);
        System.out.println("Title: " + title);
        System.out.println("Description: " + description);
        System.out.println("Due Date: " + dueDate);
    }
}

// Class representing a specialized type of Assignment: Essay Assignment which inherite from Assignment class
class EssayAssignment extends Assignment {
    private int wordCount;

    // Constructor to initialize Essay Assignment details with word count.
    public EssayAssignment(String assignmentID, String title, String description, String dueDate, int wordCount) {
        super(assignmentID, title, description, dueDate);
        this.wordCount = wordCount;
    }

    // Overridden method to display essay assignment details adding wordCount
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Word Count: " + wordCount);
    }
}

// Class representing a specialized type of Assignment: Multiple Choice Assignment.
class MultipleChoiceAssignment extends Assignment {
    private int numberOfQuestions;

    // Constructor to initialize Multiple Choice Assignment details, adding the number of questions.
    public MultipleChoiceAssignment(String assignmentID, String title, String description, String dueDate, int numberOfQuestions) {
        super(assignmentID, title, description, dueDate);
        this.numberOfQuestions = numberOfQuestions;
    }

    // Overridden method to display multiple choice assignment details.
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Number of Questions: " + numberOfQuestions);
    }
}

// Class representing a Submission for an Assignment.
class Submission {
    private String submissionID;
    private Student student;
    private String content;
    private double grade;

    // Constructor for Submission class.
    public Submission(String submissionID, Student student, String content, double grade) {
        this.submissionID = submissionID;
        this.student = student;
        this.content = content;
        this.grade = grade;
    }

    // Method to get the submission content.
    public String getContent() {
        return content;
    }

    // Method to get the submission grade.
    public double getGrade() {
        return grade;
    }

    // Method to display submission details.
    public void displayDetails() {
        System.out.println("Submission ID: " + submissionID);
        System.out.println("Student: " + student.name);
        System.out.println("Content: " + content);
        System.out.println("Grade: " + grade);
    }
}


// Main class
public class LearningManagementSystem {
    public static void main(String[] args) {
        System.out.println("Welcome to the Online Learning Management System! Developed by: [Aya Zeyad and Farah Ammoura]");

        // Creating an instructor and a course a student.
        Instructor instructor = new Instructor("instructorone", "noor321", "NoorAldeen", "9110");
        Course course = new Course("310", "Introduction to Programming in JAVA", instructor);
        Student student = new Student("student_MM", "MAHMOOD2004", "Mahmood ", "2022904599");

        // Displaying details of the instructor, student, and course.
        instructor.displayDetails();
        student.displayDetails();
        course.displayDetails();

        // Adding student to the course.
        course.addStudent(student);
        student.displayDetails();

        // Adding assignments to the course.
        EssayAssignment essayAssignment = new EssayAssignment("2023-2024", "miniproject", "Online Learning Manegment System.", "2024-8-21", 1500);
        MultipleChoiceAssignment mcqAssignment = new MultipleChoiceAssignment("2023-2024", "QUIZ 1", "Multiple choice questions on Java basics.", "2024-8-4", 20);
        course.addAssignment(essayAssignment);
        course.addAssignment(mcqAssignment);

        // Displaying the list of assignments in the course.
        course.displayAssignments();

        // Adding submissions to the assignments.
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter grade: ");
        double grade = scanner.nextDouble();
        scanner.nextLine();
        Submission submission1 = new Submission("S1", student, "This is the essay content.", grade);
        System.out.println("Enter you garde the Multiple Choice Assignment submission. ");
        Submission submission2 = new Submission("S2", student, "This is the Multiple Choice Assignment submission.",grade);
        essayAssignment.addSubmission(submission1);
        mcqAssignment.addSubmission(submission2);

        // Displaying the submissions for the assignments.
        essayAssignment.displaySubmissions();
        mcqAssignment.displaySubmissions();
        // Closing Message.
        System.out.println("Thank you for using the Online Learning Management System. Goodbye!");
    }
}
