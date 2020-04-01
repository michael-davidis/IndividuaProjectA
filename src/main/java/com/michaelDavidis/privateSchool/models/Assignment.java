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

/**
 *
 * @author Mike
 */
public class Assignment {

    private String title;
    private String description;
    private Course course;
    private LocalDate subDateTime;
    private int oralMark;
    private int totalMark;
    private static ArrayList<String> titleList = new ArrayList<String>(Arrays.asList("Random stuff 1", "Random Stuff 2", "Random Stuff 3", "Random Stuff 4"));
    private static ArrayList<String> descriptionList = new ArrayList<String>(Arrays.asList("Random stuff 1", "Random Stuff 2", "Random Stuff 3", "Random Stuff 4"));
    private static ArrayList<String> subDateTimeList = new ArrayList<String>(Arrays.asList("25/06/2020", "28/06/2020", "30/7/2020", "19/08/2020"));

    public Assignment(String title, String description, Course course, LocalDate subDateTime, int oralMark, int totalMark) {
        this.title = title;
        this.description = description;
        this.course = course;
        this.subDateTime = subDateTime;
        this.oralMark = oralMark;
        this.totalMark = totalMark;
    }

    public static Assignment createRandomAssignment() throws ParseException {
        String title = titleList.get(Tools.randomIntInListSize(titleList));
        String description = descriptionList.get(Tools.randomIntInListSize(descriptionList));
        Course course = Course.createRandomCourse();
        LocalDate date = Tools.stringToLocalDate(subDateTimeList.get(Tools.randomIntInListSize(subDateTimeList)));
        int randOralMark = Tools.random.nextInt(101);
        int totalMark = 100;
        Assignment assignment = new Assignment(title, description, course, date, randOralMark, totalMark);
        main.java.com.michaelDavidis.privateSchool.main.coursesList.add(course);
        return assignment;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getOralMark() {
        return oralMark;
    }

    public void setOralMark(int oralMark) {
        this.oralMark = oralMark;
    }

    public int getTotalMark() {
        return totalMark;
    }

    public void setTotalMark(int totalMark) {
        this.totalMark = totalMark;
    }

    public LocalDate getSubDateTime() {
        return subDateTime;
    }

    public void setSubDateTime(LocalDate subDateTime) {
        this.subDateTime = subDateTime;
    }
}
