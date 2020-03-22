/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.com.michaelDavidis.privateSchool;

import java.util.ArrayList;
import java.util.Scanner;
import main.java.com.michaelDavidis.privateSchool.models.Assignment;
import main.java.com.michaelDavidis.privateSchool.models.Course;
import main.java.com.michaelDavidis.privateSchool.models.Student;
import main.java.com.michaelDavidis.privateSchool.models.Trainer;

public class main {

    public static void showChoices() {
        System.out.println("Press 1 for a student.");
        System.out.println("Press 2 for a course.");
        System.out.println("Press 3 for an assignment.");
        System.out.println("Press 4 for a trainer.");
    }

    public static ArrayList createTrainer(ArrayList<Trainer> trainers) {
        String cont = "y";
        while (cont.equalsIgnoreCase("y")) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Give me the first name of the trainer: ");
            String fname = sc.next();
            System.out.print("Give me the last name of the trainer: ");
            String lname = sc.next();
            System.out.print("Give me the subject he/her is teaching: ");
            String deathOfAScanner = sc.nextLine();
            String subject = sc.nextLine();
            Trainer trainer = new Trainer(fname, lname, subject);
            trainers.add(trainer);
            System.out.println("Do you want to continue and add another trainer? (Y/N)");
            cont = sc.next();
        }
        return trainers;
    }

    public static void showAllTrainers(ArrayList<Trainer> trainers) {
        int i = 1;
        for (Trainer trainer : trainers) {
            System.out.println(i + ". " + trainer.getFirstName() + " " + trainer.getLastName() + "," + " Subject: " + trainer.getSubject());
            i++;
        }
    }

    public static Trainer chooseTrainer(ArrayList trainerList, int x) {
        return (Trainer) trainerList.get(x - 1);
    }

    public static ArrayList createCourse(ArrayList<Course> courses, ArrayList<Trainer> trainerList) {
        String cont = "y";
        while (cont.equalsIgnoreCase("y")) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Give me the title of the course: ");
            String courseName = sc.nextLine();
            System.out.print("Give me the stream of the course: ");
            String courseStream = sc.next();
            System.out.print("Give me the type of the course: ");
            String courseType = sc.next();
            System.out.print("Give me the trainer of the course by choosing a number: ");
            showAllTrainers(trainerList);
            int trainerNum = sc.nextInt();
            Trainer trainer = chooseTrainer(trainerList, trainerNum);
            System.out.print("Give me the start date of the course: ");
            String courseStartDate = sc.next();
            System.out.print("Give me the end date of the course: ");
            String courseEndDate = sc.next();
            Course course = new Course(courseName, courseStream, courseType, trainer, courseStartDate, courseEndDate);
            courses.add(course);
            System.out.println("Do you want to continue and add another course? (Y/N)");
            cont = sc.next();
        }
        return courses;
    }

    public static void showAllCourses(ArrayList<Course> courseList) {
        int i = 1;
        for (Course course : courseList) {
            System.out.println(i + ". \"" + course.getTitle() + "\" with trainer " + course.getTrainer().getLastName() + " " + course.getTrainer().getFirstName());
            i++;
        }

    }

    public static Course chooseCourse(ArrayList courseList, int x) {
        return (Course) courseList.get(x - 1);
    }

    public static void createStudent(ArrayList courseList, ArrayList trainerList) {
        String cont = "Y";
        while (cont.equalsIgnoreCase("y")) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Give me the first name of the student: ");
            String fname = sc.next();
            System.out.print("Give me the last name of the student: ");
            String lname = sc.next();
            System.out.print("Give me the date of his/her birth: ");
            String dob = new String(sc.next());
            System.out.print("Give me his/her tuition fees: ");
            int fee = sc.nextInt();
            System.out.println("Give me his/her course: ");
            showAllCourses(courseList);
            int courseNum = sc.nextInt();
            Course course = chooseCourse(trainerList, courseNum);
//            Student student = new Student(fname, lname, dob, fee, course);
            
//            Student student = new Student(fname, lname, dob, fee, course, assignment);
//            studentsList.add(student);
            System.out.println("Do you want to continue and add another student? (Y/N)");
        }
    }

    public static void main(String[] args) {
        ArrayList<Trainer> trainerList = new ArrayList<>();
        ArrayList<Course> courseList = new ArrayList<>();
        System.out.println("Welcome to our private school!");

        trainerList = createTrainer(trainerList);
        courseList = createCourse(courseList, trainerList);
        System.out.println("\nWould you like to inquire about a student, a course, an assignment or a trainer?");
        showChoices();

        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        System.out.println(choice);
        while ((choice != 1) || (choice != 2) || (choice != 3) || (choice != 4)) {
            if (choice == 1) {
                System.out.println("You got a student.");
                break;
            } else if (choice == 2) {
                showAllCourses(courseList);
                int pickCourse = sc.nextInt();
                System.out.println("You picked" + (chooseCourse(courseList, pickCourse).getTitle() + "."));
                break;
            } else if (choice == 3) {
                System.out.println("You got an assignment");

                break;
            } else if (choice == 4) {
                showAllTrainers(trainerList);
                System.out.println("Pick a trainer:");
                int pickTrainer = sc.nextInt();
                System.out.println("You picked: " + (chooseTrainer(trainerList, pickTrainer).getFirstName()));
                break;
            } else {
                System.out.println("Choose one of the above.");
                choice = sc.nextInt();
            }
        }
    }

}
