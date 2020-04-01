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
public class Course {

    static ArrayList<Course> coursesList = new ArrayList<Course>();
    private String title;
    private String stream;
    private String type;
    private LocalDate startDate;
    private LocalDate endDate;
    private static ArrayList<String> randTitlesList = new ArrayList<String>(Arrays.asList("Java", "Math", "C#", "History", "SexEd", "Spanish", "P.E."));
    private static ArrayList<String> randStream = new ArrayList<String>(Arrays.asList("www.privateschool.com"));
    private static ArrayList<String> randType = new ArrayList<String>(Arrays.asList("Mandatory Course", "Optional Course"));
    private static ArrayList<String> randStartDate = new ArrayList<String>(Arrays.asList("13/02/2020", "14/02/2020","15/03/2020", "16/03/2020", "20/03/2020", "21/03/2020"));
    private static ArrayList<String> randEndDate = new ArrayList<String>(Arrays.asList("13/09/2020", "14/09/2020","15/09/2020", "16/10/2020", "20/10/2020", "21/10/2020"));
    

    public Course(String title, String stream, String type, LocalDate startDate, LocalDate endDate) {
        this.title = title;
        this.stream = stream;
        this.type = type;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public static Course createRandomCourse() throws ParseException {
//      Getting random items from the lists
        String title = randTitlesList.get(Tools.randomIntInListSize(randTitlesList));
        String stream = randStream.get(Tools.randomIntInListSize(randStream));
        String type = randType.get(Tools.randomIntInListSize(randType));
//      Creating a LocalDate object using the custom method we created
        LocalDate courseStartDate = Tools.stringToLocalDate(randStartDate.get(Tools.randomIntInListSize(randStartDate)));   
        LocalDate courseEndDate = Tools.stringToLocalDate(randEndDate.get(Tools.randomIntInListSize(randEndDate)));
        Course course = new Course(title, stream, type, courseStartDate, courseEndDate);
        return course;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStream() {
        return stream;
    }

    public void setStream(String stream) {
        this.stream = stream;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

}
