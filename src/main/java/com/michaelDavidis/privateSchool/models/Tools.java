/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.com.michaelDavidis.privateSchool.models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author Mike
 */
public class Tools {

    public static Scanner scan = new Scanner(System.in);
    public static Random random = new Random();
    private static ArrayList<String> numList = new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9"));

    public static LocalDate stringToLocalDate(String date) throws ParseException {
        Date dateD = new SimpleDateFormat("dd/MM/yyyy").parse(date);
        LocalDate dateLD = dateD.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        return dateLD;
    }

    public static int randomIntInRange(int min, int max) {
        int num = ThreadLocalRandom.current().nextInt(min, max);
        return num;
    }

    public static int randomIntInListSize(ArrayList list) {
        int i = random.nextInt(list.size());
        return i;
    }

    public static boolean intValidation(String input) {
        String inputIndex = input.substring(0);
        if (numList.contains(inputIndex)) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean strValidation(String input) {
        int x = 0;
        for (int i = 0; i < input.length(); i++) {
            String inputIndex = input.substring(i);
            if (numList.contains(inputIndex)) {
                x++;
                break;
            }
        }
        if (x > 0) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean strFirstTimeValidation(String input) {
        int x = 0;
        for (int i = 0; i < input.length(); i++) {
            String inputIndex = input.substring(i);
            if (numList.contains(inputIndex)) {
                x++;
                break;
            }
        }
        if (x > 0) {
            return false;
        } else if (x<0 &&(input.equalsIgnoreCase(" ") || input.equalsIgnoreCase(""))) {
            return true;
        }else{return false;}
    }

}
