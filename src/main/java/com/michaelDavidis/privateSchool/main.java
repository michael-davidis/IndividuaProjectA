/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.com.michaelDavidis.privateSchool;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import main.java.com.michaelDavidis.privateSchool.models.Assignment;
import main.java.com.michaelDavidis.privateSchool.models.Course;
import main.java.com.michaelDavidis.privateSchool.models.Menu;
import main.java.com.michaelDavidis.privateSchool.models.Student;
import main.java.com.michaelDavidis.privateSchool.models.Trainer;

public class main {

    public static ArrayList createTrainer(ArrayList<Trainer> trainers, ArrayList<Course> coursesList) {
//      Method for creating a new trainer
        String cont = "y";
//      While loop for if we want to add another trainer
        while (cont.equalsIgnoreCase("y")) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Give me the first name of the trainer: ");
            String fname = sc.next();
            System.out.print("Give me the last name of the trainer: ");
            String lname = sc.next();
            System.out.print("Choose the course he/she is teaching: ");
            Menu.showListObjects(coursesList);
            int x = sc.nextInt();
            Course course = chooseCourse(coursesList, x);
            Trainer trainer = new Trainer(fname, lname, course);
            trainers.add(trainer);
//          Asking if we want to continue
            System.out.println("Do you want to continue and add another trainer? (Y/N)");
            cont = sc.next();
        }
        return trainers;
    }

    public static Trainer chooseTrainer(ArrayList<Trainer> trainerList, int x) {
//      This one is pretty straight-forward. We choose an existing trainer according to its position in our list.
        return trainerList.get(x - 1);
    }

    public static ArrayList createCourse(ArrayList<Course> coursesList) {
//       Creating a new course
        String cont = "y";
//      While loop for if we want to add another course
        while (cont.equalsIgnoreCase("y")) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Give me the title of the course: ");
            String courseName = sc.nextLine();
            System.out.print("Give me the stream of the course: ");
            String courseStream = sc.next();
            System.out.print("Give me the type of the course: ");
            String courseType = sc.next();
            System.out.print("Give me the start date of the course: ");
            String courseStartDate = sc.next();
            System.out.print("Give me the end date of the course: ");
            String courseEndDate = sc.next();
            Course course = new Course(courseName, courseStream, courseType, courseStartDate, courseEndDate);
            coursesList.add(course);
//          Asking if we want to continue
            System.out.println("Do you want to continue and add another course? (Y/N)");
            cont = sc.next();
        }
        return coursesList;
    }

    public static Course chooseCourse(ArrayList<Course> courseList, int x) {
//      This one is pretty straight-forward. We choose an existing course according to its position in our list.
        return courseList.get(x - 1);
    }

    public static ArrayList createStudent(ArrayList<Student> studentsList, ArrayList<Course> courseList, ArrayList<Trainer> trainerList, ArrayList<Assignment> assignmentList) throws ParseException {
//      Create a student
        String cont = "Y";
//      While loop for if we want to add another course
        while (cont.equalsIgnoreCase("y")) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Give me the first name of the student: ");
            String fname = sc.next();
            System.out.print("Give me the last name of the student: ");
            String lname = sc.next();
            System.out.print("Give me the date of his/her birth in this format \"DD-MM-YYYY\": ");
//          In order to enter a date using the Date class, we have to get it as a string and the convert is via SimpleDateFormat into a Date object 
            String dob = sc.next();
            SimpleDateFormat date = new SimpleDateFormat("dd-MM-yyyy");
            Date dateOfBirth = date.parse(dob);
            String date2 = dateOfBirth.toString();
            System.out.print("Give me his/her tuition fees: ");
            int fee = sc.nextInt();
            System.out.print("Give me his/her course: ");
//          Right here, we show all the courses so the user can choose
            Menu.showListObjects(courseList);
            int courseNum = sc.nextInt();
            System.out.println("Give me his assignment: ");
            Menu.showListObjects(assignmentList);
            int assignmentNum = sc.nextInt();
            Student student = new Student(fname, lname, date2, fee, chooseCourse(courseList, courseNum), chooseAssignment(assignmentList, assignmentNum));
            studentsList.add(student);
            System.out.println("Do you want to continue and add another student? (Y/N)");
            cont = sc.next();
        }
        return studentsList;
    }

    public static ArrayList createAssignment(ArrayList<Assignment> assignmentList, ArrayList<Course> coursesList) {
        String cont = "y";
        while (cont.equalsIgnoreCase("y")) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Give me the title of the assignment: ");
            String title = sc.nextLine();
            System.out.print("Give me the description of the assignment: ");
            String description = sc.nextLine();
            System.out.print("Choose the course that it is in: ");
            Menu.showListObjects(coursesList);
            int x = sc.nextInt();
            Course course = chooseCourse(coursesList, x);
            System.out.print("Give me the submission date in the format DD-MM-YYYY: ");
            String date = sc.next();
            System.out.print("Give me the oral mark: ");
            int oMark = sc.nextInt();
            System.out.println("Give me the totalMark");
            int tMark = sc.nextInt();
            Assignment assignment = new Assignment(title, description, course, date, oMark, tMark);
            assignmentList.add(assignment);
            System.out.println("Do you want to continue and add another assignment? (Y/N)");
            cont = sc.next();
        }
        return assignmentList;
    }

    public static Assignment chooseAssignment(ArrayList<Assignment> assignmentList, int x) {
        return assignmentList.get(x - 1);
    }

    public static ArrayList showStudentsPerCourse(ArrayList<Student> studentsList, ArrayList<Course> coursesList) {
        int i = 0;
        ArrayList<String> spc = new ArrayList<>();
        for (Course course : coursesList) {
            if (studentsList.get(i).getCourse().equals(course.getTitle())) {
                String student = (studentsList.get(i).getLastName() + " " + studentsList.get(i).getFirstName());
                spc.add(student);
            }
            i++;
        }
        return spc;
    }

    public static void showTrainersPerCourse(ArrayList<Trainer> trainersList, ArrayList<Course> coursesList) {

        for (Course course : coursesList) {

            System.out.println("The trainers for " + course.getTitle() + " are :");
            for (Trainer tr : trainersList) {
                if (tr.getCourse().getTitle().equalsIgnoreCase(course.getTitle())) {
                    System.out.println(tr.getLastName() + " " + tr.getFirstName());
                }
            }
        }
    }

    public static void showAssignmentsPerCourse(ArrayList<Assignment> assignmentsList, ArrayList<Course> coursesList) {
        int i = 0;
        for (Course course : coursesList) {
            System.out.println("The assignmets of " + course.getTitle() + " are :");
            for (Assignment as : assignmentsList) {
                if (as.getTitle().equalsIgnoreCase(course.getTitle())) {
                    System.out.println(as.getTitle());
                }
            }
        }
    }

    public static void createAllObjects(int i, ArrayList<Trainer> trainersList, ArrayList<Course> coursesList, ArrayList<Assignment> assignmentsList, ArrayList<Student> studentsList) throws ParseException {
        if (i == 0) {
            System.out.println("***First, we need to create our trainers***");
            createCourse(coursesList);
            System.out.println("*************Then our courses**************");
            createTrainer(trainersList, coursesList);
            System.out.println("***********Now our assignments*************");
            createAssignment(assignmentsList, coursesList);
            System.out.println("********And finally our students***********");
            createStudent(studentsList, coursesList, trainersList, assignmentsList);
        } else {
            if (i == 1) {
                System.out.println("-----------------------------");
                createCourse(coursesList);
            } else if (i == 2) {
                System.out.println("-----------------------------");
                createTrainer(trainersList, coursesList);
            } else if (i == 3) {
                System.out.println("-----------------------------");
                createAssignment(assignmentsList, coursesList);
            } else if (i == 4) {
                System.out.println("-----------------------------");
                createStudent(studentsList, coursesList, trainersList, assignmentsList);
            }
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
        int choiceFromMenu = 0;
        createAllObjects(choiceFromMenu, trainersList, coursesList, assignmentsList, studentsList);
        Scanner sc = new Scanner(System.in);
        String quit = "n";
        String stay = "y";
        while (!quit.equalsIgnoreCase("y")) {
            Menu.createOrSee();
            choiceFromMenu = sc.nextInt();
            if (choiceFromMenu == 1) {
                createAllObjects(choiceFromMenu, trainersList, coursesList, assignmentsList, studentsList);
            } else if (choiceFromMenu == 2) {
                while (stay.equalsIgnoreCase("y")) {
                    System.out.print("Which one of these do you want to expand? ");
                    Menu.showChoices();
                    int choice = sc.nextInt();
                    Menu.showAllObjectLists(choice, studentsList, coursesList, assignmentsList, trainersList);
                    System.out.println("Do you want to stay");
                    stay = sc.next();
                }
            }
            System.out.println("Do you wish to quit? (Y/N)");
            quit = sc.next();
        }
        System.out.println("Thank you for using our school's app.");
    }
}
