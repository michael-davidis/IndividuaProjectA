/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.com.michaelDavidis.privateSchool.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Mike
 */
public class Student {

    static Scanner sc = new Scanner(System.in);
    public static ArrayList<Student> studentsList = new ArrayList<Student>();
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private int tuitionFees;
    private Course course;
    private Assignment assignment;

    public Student(String firstName, String lastName, String dateOfBirth, int tuitionFees, Course course, Assignment assignment) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.tuitionFees = tuitionFees;
        this.course = course;
        this.assignment = assignment;
    }

    public static void createStudent() {
        String cont = "Y";
        while (cont.equalsIgnoreCase("y")) {
            System.out.print("Give me the first name of the student: ");
            String fname = sc.next();
            System.out.print("Give me the last name of the student: ");
            String lname = sc.next();
            System.out.print("Give me the date of his/her birth: ");
            Date dob = new Date(sc.next());
            System.out.print("Give me his/her tuition fees: ");
            int fee = sc.nextInt();
            System.out.println("Give me his/her course: ");

//            Student student = new Student(fname, lname, dob, fee, course, assignment);
//            studentsList.add(student);
            System.out.println("Do you want to continue and add another student? (Y/N)");
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Assignment getAssignment() {
        return assignment;
    }

    public void setAssignment(Assignment assignment) {
        this.assignment = assignment;
    }

    public int getTuitionFees() {
        return tuitionFees;
    }

    public void setTuitionFees(int tuitionFees) {
        this.tuitionFees = tuitionFees;
    }

}