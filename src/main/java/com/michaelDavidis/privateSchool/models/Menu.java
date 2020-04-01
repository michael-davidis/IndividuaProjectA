/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.com.michaelDavidis.privateSchool.models;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.temporal.TemporalField;
import java.time.temporal.WeekFields;
import java.util.ArrayList;
import java.util.Locale;

/**
 *
 * @author Mike
 */
public class Menu {

    public static void intro() {
        System.out.println("*******************************************");
        System.out.println("*                                         *");
        System.out.println("*          Welcome to our school's        *");
        System.out.println("*                database                 *");
        System.out.println("*                                         *");
        System.out.println("*******************************************\n");
    }

    public static void exiting() {
        System.out.println("\n*******************************************");
        System.out.println("*             Thank you for               *");
        System.out.println("*             using our app!              *");
        System.out.println("*******************************************");
    }

    public static void createOrSee() {
        System.out.println("\nDo you wish to create a new object\nor to see what you have?");
        System.out.println("During this menu, you can type \"Exit\" and exit our app.");
        System.out.print("Press 1 to create or 2 to access the database: ");
    }

    public static void chooseToCreateFromList() {
        System.out.println("\nYou can choose to create anything you want from this list.");
        showChoices();
        System.out.print("Just type the number that you want: ");
        System.out.print("\n");
    }

    public static void chooseToShowFromList() {
        System.out.println("\nYou can choose to see anything you want from this list.");
        showChoices();
        System.out.print("Just type the number that you want: ");
        System.out.print("\n");
    }

    public static void showChoices() {
        System.out.println("\nPress 1 for a course.");
        System.out.println("Press 2 for a trainer.");
        System.out.println("Press 3 for an assignment.");
        System.out.println("Press 4 for a student.");
    }

    public static void showChoicesWithAdditional() {
        System.out.println("\nPress 1 for a course.");
        System.out.println("Press 2 for a trainer.");
        System.out.println("Press 3 for an assignment.");
        System.out.println("Press 4 for a student.");
        System.out.println("Press 5 for a list of all the students per course.");
        System.out.println("Press 6 for a list of all the assignments per course.");
        System.out.println("Press 7 for a list of all trainers per course.");
        System.out.println("Press 8 for a list of all students with 2+ courses.");
        System.out.println("Press 9 to see if there are any students that need to submit");
        System.out.println("one or more assignments in the same week as the date that you want.");
    }

    public static void showListObjects(ArrayList list) {
        int i = 1;
        if (!list.isEmpty()) {
            if (list.get(0).getClass() == Trainer.class) {
                for (Object tmp : list) {
                    Trainer trainer = (Trainer) tmp;
                    System.out.println(i + ". " + trainer.getFirstName() + " " + trainer.getLastName() + " is teaching " + trainer.getCourse().getTitle());
                    i++;
                }
            } else if (list.get(0).getClass() == Course.class) {
                for (Object tmp : list) {
                    Course course = (Course) tmp;
                    System.out.println(i + ". \"" + course.getTitle() + "\", " + course.getType() + ". Starting on " + course.getStartDate() + " and ending on " + course.getEndDate() + ".");
                    i++;
                }
            } else if (list.get(0).getClass() == Assignment.class) {
                for (Object tmp : list) {
                    Assignment assignment = (Assignment) tmp;
                    System.out.println(i + ". \n" + assignment.getTitle() + "\n in " + assignment.getCourse().getTitle() + ", With date of submission " + assignment.getSubDateTime()
                            + ". The mark is " + assignment.getOralMark() + "/" + assignment.getTotalMark());
                    i++;
                }
            } else if (list.get(0).getClass() == Student.class) {
                for (Object tmp : list) {
                    Student student = (Student) tmp;
                    int x = 0;
                    String firstPart = i + ". " + student.getFirstName() + " " + student.getLastName();
                    String secondPart = ", ";
                    while (x < student.getCourse().size()) {
                        secondPart += student.getCourse().get(x).getTitle();
                        x++;
                    }
                    System.out.println(firstPart + secondPart);
                    i++;
                }
            }
        } else {
            System.out.println("There is nothing to access here. If you want to create objects, choose 1 in the main menu.\n");
        }
    }

    public static void showAllObjectLists(int choiceFromObjects, ArrayList<Course> coursesList, ArrayList<Trainer> trainersList, ArrayList<Assignment> assignmentsList, ArrayList<Student> studentsList) {
        switch (choiceFromObjects) {
            case 1:
                showListObjects(coursesList);
                break;
            case 2:
                showListObjects(trainersList);
                break;
            case 3:
                showListObjects(assignmentsList);
                break;
            case 4:
                showListObjects(studentsList);
                break;
            default:
                System.out.print("Choose one of the above by typing the appropriate number.");

                break;
        }
    }

    public static void showAllObjectListsWithAdditional(String choiceFromObjects, ArrayList<Course> coursesList, ArrayList<Trainer> trainersList, ArrayList<Assignment> assignmentsList, ArrayList<Student> studentsList) throws ParseException {

        switch (choiceFromObjects) {
            case "1":
                showListObjects(coursesList);
                break;
            case "2":
                showListObjects(trainersList);
                break;
            case "3":
                showListObjects(assignmentsList);
                break;
            case "4":
                showListObjects(studentsList);
                break;
            case "5":
                showStudentsPerCourse(studentsList, coursesList);
                break;
            case "6":
                showAssignmentsPerCourse(assignmentsList, coursesList);
                break;
            case "7":
                showTrainersPerCourse(trainersList, coursesList);
                break;
            case "8":
                showStudentsWith2Courses(studentsList);
                break;
            case "9":
                showStudentsWithInweekSubmissions(studentsList);
                break;
            default:
                System.out.print("Choose one of the above by typing the appropriate number.");

                break;
        }
    }

    public static void showStudentsPerCourse(ArrayList<Student> studentsList, ArrayList<Course> coursesList) {
        System.out.println("The students per course are the following: ");
        if (studentsList.isEmpty()) {
            System.out.println("There are no students registered.\n");
        }
        coursesList.stream().map((course) -> {
            System.out.println("The students of " + course.getTitle() + " are: ");
            return course;
        }).forEachOrdered((course) -> {
            studentsList.forEach((student) -> {
                student.getCourse().stream().filter((fromCoursesList) -> (fromCoursesList.getTitle().equalsIgnoreCase(course.getTitle()))).forEachOrdered((_item) -> {
                    System.out.println(student.getLastName() + " " + student.getFirstName());
                });
            });
        });
    }

    public static void showTrainersPerCourse(ArrayList<Trainer> trainersList, ArrayList<Course> coursesList) {
        System.out.println("The trainers per course are the following: ");
        if (trainersList.isEmpty()) {
            System.out.println("There are no trainers registered.\n");
        }
        coursesList.stream().map((course) -> {
            System.out.println("The trainers for " + course.getTitle() + " are :");
            return course;
        }).forEachOrdered((course) -> {
            trainersList.stream().filter((tr) -> (tr.getCourse().getTitle().equalsIgnoreCase(course.getTitle()))).forEachOrdered((tr) -> {
                System.out.println(tr.getLastName() + " " + tr.getFirstName());
            });
        });
    }

    public static void showAssignmentsPerCourse(ArrayList<Assignment> assignmentsList, ArrayList<Course> coursesList) {
        int i = 0;
        System.out.println("The assignments in each course are the following:");
        if (assignmentsList.isEmpty()) {
            System.out.println("There are no assignments registered.\n");
        }
        coursesList.stream().map((course) -> {
            System.out.println("The assignmets of " + course.getTitle() + " are :");
            return course;
        }).forEachOrdered((course) -> {
            assignmentsList.stream().filter((as) -> (as.getTitle().equalsIgnoreCase(course.getTitle()))).forEachOrdered((as) -> {
                System.out.println(as.getTitle());
            });
        });
    }

    public static void showStudentsWith2Courses(ArrayList<Student> studentsList) {
        System.out.println("The students with 2 or more courses are the following: ");
        if (studentsList.isEmpty()) {
            System.out.println("There are no students registered.\n");
        }
        studentsList.stream().filter((student) -> (student.getCourse().size() > 1)).forEachOrdered((student) -> {
            System.out.println(student.getLastName() + " " + student.getFirstName());
        });
    }

    public static void showEmptyCourseList(ArrayList<Course> coursesList) {
        if (coursesList.isEmpty()) {
            System.out.println("\nThere are no classes registered. You need to create one.");
            System.out.println("If you don't want to create one, we can synthesize a new one");
            System.out.println("using random, predifined data. In that case, press enter without typing");
            System.out.println("anything in the first sentence.\n");
        }
    }

    public static void showEmptyTrainerList(ArrayList<Trainer> trainersList) {
        if (trainersList.isEmpty()) {
            System.out.println("\nThere are no trainer registered. You need to create one.");
            System.out.println("If you don't want to create one, we can synthesize a new one");
            System.out.println("using random, predifined data. In that case, press enter without typing");
            System.out.println("anything in the first sentence.\n");
        }
    }

    public static void showEmptyAssignmentList(ArrayList<Assignment> assignmentsList) {
        if (assignmentsList.isEmpty()) {
            System.out.println("\nThere are no assignment registered. You need to create one.");
            System.out.println("If you don't want to create one, we can synthesize a new one");
            System.out.println("using random, predifined data. In that case, press enter without typing");
            System.out.println("anything in the first sentence.\n");
        }
    }

    public static void showEmptyStudentList(ArrayList<Student> studentsList) {
        if (studentsList.isEmpty()) {
            System.out.println("\nThere are no student registered. You need to create one.");
            System.out.println("If you don't want to create one, we can synthesize a new one");
            System.out.println("using random, predifined data. In that case, press enter without typing");
            System.out.println("anything in the first sentence.\n");
        }
    }

    public static void showStudentsWithInweekSubmissions(ArrayList<Student> studentsList) throws ParseException {
        ArrayList<Student> validStudentList = new ArrayList<>();
        System.out.println("Type the date that you want in this format \"DD/MM/YYYY\"");
        String dateStr = Tools.scan.next();
        LocalDate date = Tools.stringToLocalDate(dateStr);
//      Find week that the date is in.
        TemporalField woy = WeekFields.of(Locale.getDefault()).weekOfWeekBasedYear();
        int weekNumberGiven = date.get(woy);
//      For each asssignment in each student, check if submission date is in same week as date.
        for (Student student : studentsList) {
            for (int i = 0; i < student.getAssignment().size(); i++) {
                int dueDate = student.getAssignment().get(i).getSubDateTime().get(woy);
                if (dueDate == weekNumberGiven) {
                    validStudentList.add(student);
                }
            }
        }
        if (validStudentList.isEmpty()) {
            System.out.println("There are no students with their assignments' submission date");
            System.out.println("in the week to which you are referring.\n");
        }
        int i = 1;
        for (Student student : validStudentList) {
            System.out.println(i + ". " + student.getFirstName() + " " + student.getLastName());
            i++;
        }
    }

    public static Course chooseCourse(ArrayList<Course> coursesList, int x) {
//      This one is pretty straight-forward. We choose an existing course according to its position in our list.
        return coursesList.get(x - 1);
    }

    public static Trainer chooseTrainer(ArrayList<Trainer> trainersList, int x) {
//      This one is pretty straight-forward. We choose an existing trainer according to its position in our list.
        return trainersList.get(x - 1);
    }

    public static Assignment chooseAssignment(ArrayList<Assignment> assignmentsList, int x) {
        return assignmentsList.get(x - 1);
    }

    public static Student chooseStudent(ArrayList<Student> studentsList, int x) {
        return studentsList.get(x - 1);
    }
}
