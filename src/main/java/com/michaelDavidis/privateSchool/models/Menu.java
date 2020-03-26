/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.com.michaelDavidis.privateSchool.models;

import java.util.ArrayList;
import static main.java.com.michaelDavidis.privateSchool.main.chooseCourse;
import static main.java.com.michaelDavidis.privateSchool.main.createStudent;
import static main.java.com.michaelDavidis.privateSchool.main.createTrainer;

/**
 *
 * @author Mike
 */
public class Menu {

    public static void intro() {
        System.out.println("*******************************************");
        System.out.println("*                                         *");
        System.out.println("*          Welcome to our school!         *");
        System.out.println("*                                         *");
        System.out.println("*******************************************\n");
    }

    public static void createOrSee() {
        System.out.println("Do you wish to create a new object\n or to see what you have?");
        System.out.print("Press 1 to create or 2 to access the database:");
        System.out.println("\n");
    }

    public static void showChoices() {
        System.out.println("Press 1 for a student.");
        System.out.println("Press 2 for a course.");
        System.out.println("Press 3 for an assignment.");
        System.out.println("Press 4 for a trainer.");
    }

    public static void showListObjects(ArrayList list) {
        int i = 1;

        if (list.get(0).getClass() == Trainer.class) {
            for (Object tmp : list) {
                Trainer trainer = (Trainer) tmp;
                System.out.println(i + ". " + trainer.getFirstName() + " " + trainer.getLastName());
                i++;
            }
        } else if (list.get(0).getClass() == Course.class) {
            for (Object tmp : list) {
                Course course = (Course) tmp;
                System.out.println(i + ". \"" + course.getTitle() + "\" ");
                i++;
            }
        } else if (list.get(0).getClass() == Assignment.class) {
            for (Object tmp : list) {
                Assignment assignment = (Assignment) tmp;
                System.out.println(i + ". " + assignment.getTitle());
            }
        }

    }

    public static void showAllObjectLists(int choiceFromObjects, ArrayList<Student> studentList, ArrayList<Course> courseList, ArrayList<Assignment> assignmentList, ArrayList<Trainer> trainerList) {

        switch (choiceFromObjects) {
            case 1:
                showListObjects(courseList);
                break;
            case 2:
                showListObjects(trainerList);
                break;
            case 3:
                showListObjects(assignmentList);
                break;
            case 4:
                showListObjects(studentList);
                break;
            default:
                System.out.println("Choose one of the above.");

                break;
        }

    }

}
