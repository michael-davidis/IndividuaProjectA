/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.com.michaelDavidis.privateSchool;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalField;
import java.time.temporal.WeekFields;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import main.java.com.michaelDavidis.privateSchool.models.Assignment;
import main.java.com.michaelDavidis.privateSchool.models.Course;
import main.java.com.michaelDavidis.privateSchool.models.Menu;
import main.java.com.michaelDavidis.privateSchool.models.Tools;
import main.java.com.michaelDavidis.privateSchool.models.Student;
import main.java.com.michaelDavidis.privateSchool.models.Trainer;

public class main {

    public static ArrayList createCourse(ArrayList<Course> coursesList) throws ParseException {
//       Creating a new course
        String cont = "y";
//      While loop for if we want to add another course
        while (cont.equalsIgnoreCase("y")) {
            Menu.showEmptyCourseList(coursesList);
            System.out.print("Give me the title of the course: ");
            String deathOfAScanner = Tools.scan.nextLine();
            String courseName = Tools.scan.nextLine();
            if (courseName.equalsIgnoreCase(" ") || courseName.equalsIgnoreCase("")) {
                coursesList.add(Course.createRandomCourse());
                System.out.println("A random course has been created.\n");
                System.out.println("Do you want to continue and add another course? (Y/N)");
                cont = Tools.scan.next();
            } else {
                System.out.print("Give me the stream of the course: ");
                String courseStream = Tools.scan.next();
                System.out.print("Give me the type of the course: ");
                String courseType = Tools.scan.next();
                System.out.print("Give me the start date of the course in the format DD/MM/YYYY: ");
                String courseStartDateStr = Tools.scan.next();
                LocalDate courseStartDate = Tools.stringToLocalDate(courseStartDateStr);
                System.out.print("Give me the end date of the course: ");
                String courseEndDateStr = Tools.scan.next();
                LocalDate courseEndDate = Tools.stringToLocalDate(courseEndDateStr);
                Course course = new Course(courseName, courseStream, courseType, courseStartDate, courseEndDate);
                coursesList.add(course);
//          Asking if we want to continue
                System.out.println("Do you want to continue and add another course? (Y/N)");
                cont = Tools.scan.next();
            }
        }
        return coursesList;
    }

    public static ArrayList createTrainer(ArrayList<Trainer> trainersList, ArrayList<Course> coursesList) throws ParseException {
//      Method for creating a new trainer
        String cont = "y";
        Menu.showEmptyTrainerList(trainersList);

//      While loop for if we want to add another trainer
        while (cont.equalsIgnoreCase("y")) {
            System.out.print("Give me the first name of the trainer: ");
            String deathOfAScanner = Tools.scan.nextLine();
            String fname = Tools.scan.nextLine();
            if (fname.equalsIgnoreCase(" ") || fname.equalsIgnoreCase("")) {
                trainersList.add(Trainer.createRandomTrainer());
                System.out.println("A random trainer has been created.\n");
                System.out.println("Do you want to continue and add another trainer? (Y/N)");
                cont = Tools.scan.next();
            } else {
                System.out.print("Give me the last name of the trainer: ");
                String lname = Tools.scan.next();
                System.out.println("Choose the course he/she is teaching: ");
                if (coursesList.isEmpty()) {
                    createCourse(coursesList);
                }
                Menu.showListObjects(coursesList);
                System.out.println("Choose the course you want the trainer to teach by typing the appropriate number: ");
                int x = Tools.scan.nextInt();
                Course course = Menu.chooseCourse(coursesList, x);
                Trainer trainer = new Trainer(fname, lname, course);
                trainersList.add(trainer);
//          Asking if we want to continue
                System.out.println("Do you want to continue and add another trainer? (Y/N)");
                cont = Tools.scan.next();
            }
        }
        return trainersList;
    }

    public static ArrayList createAssignment(ArrayList<Assignment> assignmentsList, ArrayList<Course> coursesList) throws ParseException {
        String cont = "y";
        Menu.showEmptyAssignmentList(assignmentsList);
        while (cont.equalsIgnoreCase("y")) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Give me the title of the assignment: ");
            String deathOfAScanner = Tools.scan.nextLine();
            String title = Tools.scan.nextLine();
            if (title.equalsIgnoreCase(" ") || title.equalsIgnoreCase("")) {
                assignmentsList.add(Assignment.createRandomAssignment());
                System.out.println("A random assignment has been created.\n");
                System.out.println("Do you want to continue and add another assignment? (Y/N)");
                cont = Tools.scan.next();
            } else {
                System.out.print("Give me the description of the assignment: ");
                String description = Tools.scan.nextLine();
                System.out.print("Choose the course that it is in: ");
                if (coursesList.isEmpty()) {
                    createCourse(coursesList);
                }
                Menu.showListObjects(coursesList);
                int x = Tools.scan.nextInt();
                Course course = Menu.chooseCourse(coursesList, x);
                System.out.print("Give me the submission date in the format DD/MM/YYYY: ");
                String orDate = Tools.scan.next();
                LocalDate dueDate = Tools.stringToLocalDate(orDate);
                System.out.print("Give me the oral mark: ");
                int oMark = Tools.scan.nextInt();
                System.out.print("Give me the total mark: ");
                int tMark = Tools.scan.nextInt();
                Assignment assignment = new Assignment(title, description, course, dueDate, oMark, tMark);
                assignmentsList.add(assignment);
                System.out.println("Do you want to continue and add another assignment? (Y/N)");
                cont = Tools.scan.next();
            }
        }
        return assignmentsList;
    }

    public static ArrayList createStudent(ArrayList<Student> studentsList, ArrayList<Course> coursesList, ArrayList<Assignment> assignmentsList) throws ParseException {
//      Create a student
        Menu.showEmptyStudentList(studentsList);
        String cont = "Y";
        String choice = "y";
        ArrayList<Course> courses = new ArrayList<>();
//      While loop for if we want to add another course
        while (cont.equalsIgnoreCase("y")) {
            System.out.print("Give me the first name of the student: ");
            String deathOfAScanner = Tools.scan.nextLine();
            String fname = Tools.scan.nextLine();
            if (fname.equalsIgnoreCase(" ") || fname.equalsIgnoreCase("")) {
                studentsList.add(Student.createRandomStudent());
                System.out.println("A random student has been created.\n");
                System.out.println("Do you want to continue and add another student? (Y/N)");
                cont = Tools.scan.next();
            } else {
                System.out.print("Give me the last name of the student: ");
                String lname = Tools.scan.next();
                System.out.print("Give me the date of his/her birth in this format \"DD/MM/YYYY\": ");
//          In order to enter a date using the Date class, we have to get it as a string and the convert is via SimpleDateFormat into a Date object 
                String dob = Tools.scan.next();
                System.out.print("Give me his/her tuition fees: ");
                int fee = Tools.scan.nextInt();
                System.out.print("Give me his/her course: ");
//          Right here, we show all the courses so the user can choose
                System.out.println("Choose from one of these");
                if (coursesList.isEmpty()) {
                    System.out.println("\nThere are no classes registered. You need to create one.");
                    System.out.println("If you don't want to create one, we can synthesize a new one");
                    System.out.println("using random, predifined data. In that case, press enter without typing");
                    System.out.println("anything in the first sentence.\n");
                    createCourse(coursesList);
                } else {
                    createCourse(coursesList);
                }
                Menu.showListObjects(coursesList);
                System.out.println("\nChoose the course:");
                int courseNum = Tools.scan.nextInt();
                courses.add(Menu.chooseCourse(coursesList, courseNum));
                System.out.println("Is this student attending another course? (Y/N)");
                choice = Tools.scan.next();
                System.out.println("Give me his assignment: ");
                if (assignmentsList.isEmpty()) {
                    System.out.println("\nThere are no asssignments registered. You need to create one.");
                    System.out.println("If you don't want to create one, we can synthesize a new one");
                    System.out.println("using random, predifined data. In that case, press enter without typing");
                    System.out.println("anything in the first sentence.\n");
                    createAssignment(assignmentsList, coursesList);
                }
                Menu.showListObjects(assignmentsList);
//              TODO: INDEX Out Of Bound FIX, Ask to add more assignments or choose from list
                int assignmentNum = Tools.scan.nextInt() - 1;
                Student student = new Student(fname, lname, Tools.stringToLocalDate(dob), fee, courses);
                while (assignmentsList.size() < assignmentNum) {
                    System.out.println("Please enter a number between 1 and " + assignmentsList.size());
                }
                student.setAssignment(assignmentsList.get(assignmentNum));
                studentsList.add(student);
                System.out.println("Do you want to continue and add another student? (Y/N)");
                cont = Tools.scan.next();
            }
        }
        return studentsList;
    }

    public static void createAllObjects(int choice, ArrayList<Course> coursesList, ArrayList<Trainer> trainersList, ArrayList<Assignment> assignmentsList, ArrayList<Student> studentsList) throws ParseException {

        switch (choice) {
            case 1:
                System.out.println("-----------------------------");
                createCourse(coursesList);
                break;
            case 2:
                System.out.println("-----------------------------");
                createTrainer(trainersList, coursesList);
                break;
            case 3:
                System.out.println("-----------------------------");
                createAssignment(assignmentsList, coursesList);
                break;
            case 4:
                System.out.println("-----------------------------");
                createStudent(studentsList, coursesList, assignmentsList);
                break;
            default:
                break;
        }
    }

    public static void main(String[] args) throws ParseException {
//      Declare the lists
        ArrayList<Trainer> trainersList = new ArrayList<>();
        ArrayList<Course> coursesList = new ArrayList<>();
        ArrayList<Assignment> assignmentsList = new ArrayList<>();
        ArrayList<Student> studentsList = new ArrayList<>();

//      Starting our menu
        Menu.intro();
        String outerChoice = "n";
        while (!outerChoice.equalsIgnoreCase("exit")) {
            Menu.createOrSee();
            outerChoice = Tools.scan.next();
            if (Tools.intValidation(outerChoice)) {
                if (outerChoice.equals("1")) {
                    Menu.chooseToCreateFromList();
                    int middleChoice = Tools.scan.nextInt();
                    createAllObjects(middleChoice, coursesList, trainersList, assignmentsList, studentsList);
                } else if (outerChoice.equals("2")) {
                    Menu.showChoicesWithAdditional();
                    int middleChoice = Tools.scan.nextInt();
                    Menu.showAllObjectListsWithAdditional(middleChoice, coursesList, trainersList, assignmentsList, studentsList);
                } else {
                    System.out.println("\n");
                    System.out.println("This is not a valid choice.");
                    System.out.println("Choose the appropriate number.\n");
                }
            } else if (!outerChoice.equalsIgnoreCase("exit")) {
                System.out.println("\n");
                System.out.println("This is not a valid choice.");
                System.out.println("Choose the appropriate number.\n");
            }
        }
        Menu.exiting();
    }
}
