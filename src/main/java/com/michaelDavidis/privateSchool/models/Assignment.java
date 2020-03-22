/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.com.michaelDavidis.privateSchool.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Mike
 */
public class Assignment {

    static Scanner sc = new Scanner(System.in);
    public static ArrayList<Assignment> assignmentsList = new ArrayList<Assignment>();
    private String title;
    private String description;
    private Date subDateTime;
    private int oralMark;
    private int totalMark;

    public Assignment(String title, String description, Date subDateTime, int oralMark, int totalMark) {
        this.title = title;
        this.description = description;
        this.subDateTime = subDateTime;
        this.oralMark = oralMark;
        this.totalMark = totalMark;
    }

    public static void createAssignment() {

        System.out.print("Give me the title of the assignment: ");
        String title = sc.next();
        System.out.print("Give me the description of the assignment: ");
        String description = sc.next();
        System.out.print("Give me its due date: ");
        Date subDate = new Date(sc.next());
        System.out.print("Give me the oral mark: ");
        int oMark = sc.nextInt();
        System.out.print("Give me the total mark: ");
        int tMark = sc.nextInt();
        Assignment assignment = new Assignment(title, description, subDate, oMark, tMark);
        assignmentsList.add(assignment);
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

    public Date getSubDateTime() {
        return subDateTime;
    }

    public void setSubDateTime(Date subDateTime) {
        this.subDateTime = subDateTime;
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

}
