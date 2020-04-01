/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.com.michaelDavidis.privateSchool;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
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
            String deathOfAScanner = Tools.scan.nextLine(); // This variable is used only to compensate for a known problem of the nextLine() method
            String courseName = Tools.scan.nextLine();
//          Checking is the input is empty and or space and create a random object
            if (courseName.equalsIgnoreCase(" ") || courseName.equalsIgnoreCase("")) {
                coursesList.add(Course.createRandomCourse());
                System.out.println("A random course has been created.\n");
                System.out.println("Do you want to continue and add another course? (Y/N)");
                cont = Tools.scan.next();
            } else {
//          If it is not empty, we continue with creating a new object
                System.out.print("Give me the stream of the course: ");
                String courseStream = Tools.scan.nextLine();
                System.out.print("Give me the type of the course: ");
                String courseType = Tools.scan.nextLine();
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
            String deathOfAScanner = Tools.scan.nextLine();// This variable is used only to compensate for a known problem of the nextLine() method
            String fname = Tools.scan.nextLine();
//          Checking is the input is empty and or space and create a random object
            if (fname.equalsIgnoreCase(" ") || fname.equalsIgnoreCase("")) {
                trainersList.add(Trainer.createRandomTrainer());
                System.out.println("A random trainer has been created.\n");
                System.out.println("Do you want to continue and add another trainer? (Y/N)");
                cont = Tools.scan.next();
            } else {
//          If it is not empty, we continue with creating a new object
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
            String deathOfAScanner = Tools.scan.nextLine();// This variable is used only to compensate for a known problem of the nextLine() method
            String title = Tools.scan.nextLine();
//          Checking is the input is empty and or space and create a random object            
            if (title.equalsIgnoreCase(" ") || title.equalsIgnoreCase("")) {
                assignmentsList.add(Assignment.createRandomAssignment());
                System.out.println("A random assignment has been created.\n");
                System.out.println("Do you want to continue and add another assignment? (Y/N)");
                cont = Tools.scan.next();
            } else {
//          If it is not empty, we continue with creating a new object                
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
            String deathOfAScanner = Tools.scan.nextLine(); // This variable is used only to compensate for a known problem of the nextLine() method
            String fname = Tools.scan.nextLine();
//          Checking is the input is empty and or space and create a random object   
            if (fname.equalsIgnoreCase(" ") || fname.equalsIgnoreCase("")) {
                studentsList.add(Student.createRandomStudent());
                System.out.println("A random student has been created.\n");
                System.out.println("Do you want to continue and add another student? (Y/N)");
                cont = Tools.scan.next();
            } else {
//          If it is not empty, we continue with creating a new object
                System.out.print("Give me the last name of the student: ");
                String lname = Tools.scan.next();
                System.out.print("Give me the date of his/her birth in this format DD/MM/YYYY: ");
                String dob = Tools.scan.next();
                System.out.print("Give me his/her tuition fees: ");
                int fee = Tools.scan.nextInt();
                System.out.print("Give me his/her course: ");
//          Right here, we show all the courses so the user can choose
                System.out.println("Choose from one of these");
                if (coursesList.isEmpty()) {
                    createCourse(coursesList);
                }
                Menu.showListObjects(coursesList);
                System.out.println("\nChoose the course:");
                int courseNum = Tools.scan.nextInt();
                courses.add(Menu.chooseCourse(coursesList, courseNum));
                System.out.println("Is this student attending another course? (Y/N)");
                choice = Tools.scan.next();
                System.out.println("Give me his assignment: ");
//              Here, we show all the courses so the user can choose
                if (assignmentsList.isEmpty()) {
                    createAssignment(assignmentsList, coursesList);
                }
                Menu.showListObjects(assignmentsList);
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

    public static void createAllObjects(String choice, ArrayList<Course> coursesList, ArrayList<Trainer> trainersList, ArrayList<Assignment> assignmentsList, ArrayList<Student> studentsList) throws ParseException {
//      Creating Objects based on user input
        switch (choice) {
            case "1":
                System.out.println("-----------------------------");
                createCourse(coursesList);
                break;
            case "2":
                System.out.println("-----------------------------");
                createTrainer(trainersList, coursesList);
                break;
            case "3":
                System.out.println("-----------------------------");
                createAssignment(assignmentsList, coursesList);
                break;
            case "4":
                System.out.println("-----------------------------");
                createStudent(studentsList, coursesList, assignmentsList);
                break;
            default:
                System.out.println("Give me a valid number.");
                break;
        }
    }

    public static void mainCode(ArrayList<Course> coursesList, ArrayList<Trainer> trainersList, ArrayList<Assignment> assignmentsList, ArrayList<Student> studentsList) throws ParseException {
//      Starting condition of "while"
        String outerChoice = "n";
//      We use "IgnoreCase" to prevent any case discrepancy between the user input and what our code understands
        while (!outerChoice.equalsIgnoreCase("exit")) {
//          Showing the two choices of the menu and getting the input
            Menu.createOrSee();
            outerChoice = Tools.scan.next();
//          Starting condition of "while"
            String middleChoice = "n";
//          This "if" and this "while" used to prevent any invalid inputs
            if (Tools.intValidation(outerChoice)) {
                while (!Tools.intValidation(middleChoice)) {
                    if (outerChoice.equals("1")) {
//                      Value "1" is assigned for object creation
                        Menu.chooseToCreateFromList();
                        middleChoice = Tools.scan.next();
                        createAllObjects(middleChoice, coursesList, trainersList, assignmentsList, studentsList);
                    } else if (outerChoice.equals("2")) {
//                      Value "1" is assigned for object output
                        Menu.showChoicesWithAdditional();
                        middleChoice = Tools.scan.next();
                        Menu.showAllObjectListsWithAdditional(middleChoice, coursesList, trainersList, assignmentsList, studentsList);
                    } else {
//                      Case of invalid input
                        System.out.println("\n");
                        System.out.println("This is not a valid choice.");
                        System.out.println("Choose the appropriate number.\n");
                    }
                }
            } else if (!outerChoice.equalsIgnoreCase("exit")) {
//              Case of invalid input
                System.out.println("\n");
                System.out.println("This is not a valid choice.");
                System.out.println("Choose the appropriate number.\n");
            }
        }
    }
// These are the main lists used in our code. We add objects to them or we print them
    public static ArrayList<Trainer> trainersList = new ArrayList<>();
    public static ArrayList<Course> coursesList = new ArrayList<>();
    public static ArrayList<Assignment> assignmentsList = new ArrayList<>();
    public static ArrayList<Student> studentsList = new ArrayList<>();

    public static void main(String[] args) throws ParseException {
//      Starting our menu
        Menu.intro();
        mainCode(coursesList, trainersList, assignmentsList, studentsList);
//      When input is "exit" in mainCode, then Menu.exiting() shows the outro of our code
        Menu.outro();
    }
}
