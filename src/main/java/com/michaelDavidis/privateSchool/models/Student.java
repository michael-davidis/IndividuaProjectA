/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.com.michaelDavidis.privateSchool.models;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Mike
 */
public class Student {

    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private int tuitionFees;
    private ArrayList<Course> course;
    private ArrayList<Assignment> assignment;
    private static ArrayList<String> firstNameList = new ArrayList<>(Arrays.asList("Jim", "Jessie", "Seth", "Tina", "Celia", "Jake", "Steve"));
    private static ArrayList<String> lastNameList = new ArrayList<>(Arrays.asList("Abrams", "Salvio", "Travis", "Cicero", "Jones", "Surtis", "Ansel"));
    private static ArrayList<String> dobList = new ArrayList<>(Arrays.asList("19/08/1986", "14/12/2000", "17/01/1990", "01/05/1981", "31/01/1996", "10/10/1999"));

    public Student(String firstName, String lastName, LocalDate dateOfBirth, int tuitionFees, ArrayList<Course> course) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.tuitionFees = tuitionFees;
        this.course = course;
        this.assignment = new ArrayList<Assignment>();
    }

    public static Student createRandomStudent() throws ParseException {
        String firstName = firstNameList.get(Tools.randomIntInListSize(firstNameList));
        String lastName = lastNameList.get(Tools.randomIntInListSize(lastNameList));
        int day = Tools.random.nextInt(32);
        int month = Tools.randomIntInRange(1, 13);
        int year = Tools.randomIntInRange(1975, 2003);
        LocalDate dob = Tools.stringToLocalDate(day + "/"+month+"/"+year);
        ArrayList<Course> courseList = new ArrayList<>(Arrays.asList(Course.createRandomCourse()));
        ArrayList<Assignment> assignment = new ArrayList<>(Arrays.asList(Assignment.createRandomAssignment()));
        int tuitionFees = Tools.random.nextInt(10001);
        Student student = new Student(firstName, lastName, dob, tuitionFees, courseList);
        student.setAssignment(assignment.get(0));
        return student;
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

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public ArrayList<Assignment> getAssignment() {
        return assignment;
    }

    public void setAssignment(Assignment assignment) {
        this.assignment.add(assignment);
    }

    public int getTuitionFees() {
        return tuitionFees;
    }

    public void setTuitionFees(int tuitionFees) {
        this.tuitionFees = tuitionFees;
    }

    public ArrayList<Course> getCourse() {
        return course;
    }

    public void setCourse(ArrayList<Course> course) {
        this.course = course;
    }

}
