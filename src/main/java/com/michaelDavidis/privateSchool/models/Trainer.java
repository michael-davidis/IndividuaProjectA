/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.com.michaelDavidis.privateSchool.models;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Mike
 */
public class Trainer {
    private String firstName;
    private String lastName;
    private Course course;
    private static ArrayList<String> firstNamesList = new ArrayList<String>(Arrays.asList("John", "James", "Jack", "Michael", "Nick", "Christina", "Diana", "Clarice"));
    private static ArrayList<String> lastNamesList = new ArrayList<String>(Arrays.asList("Jones", "Keegan", "Clay", "Peralta", "Skiba", "Griffin"));
    

    public Trainer(String firstName, String lastName, Course course) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.course = course;
    }
    
    public static Trainer createRandomTrainer() throws ParseException{
//      Getting random names from lists
        String fname = firstNamesList.get(Tools.randomIntInListSize(firstNamesList));
        String lname = lastNamesList.get(Tools.randomIntInListSize(lastNamesList));
//      Creating a random course
        Course course = Course.createRandomCourse();
        Trainer trainer = new Trainer(fname, lname, course);
        return trainer;
    }
    
    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
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

}
