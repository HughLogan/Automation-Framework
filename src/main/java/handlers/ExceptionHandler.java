package handlers;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class ExceptionHandler {

    public static void ExceptionArithmetic(int random, int value) {

        System.out.println(" Before Exception ");
        try {
            int divide = random / value;
            System.out.println(divide);
        } catch (Exception e) {
            System.out.println("Error occurred in try block");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        System.out.println("End of Exception Arithmetic");
    }

    public static void ExceptionIndex(int aindex, int index, int value) {

        System.out.println("Before index initialisation");
        try {
            System.out.println("Initialise values");
            int[] i = new int[aindex];
            i[index] = value;
            System.out.println(i[index]);
        } catch (Exception e) {
            System.out.println("Error in Array Index Initialization");
            e.printStackTrace();
        }
        System.out.println("Passed");


    }

    public static String ExceptionIndexMessage(int aindex, int index, int value) throws ArrayIndexOutOfBoundsException {
        String st = "";
        try {
            int[] i = new int[aindex];
            i[index] = value;
            System.out.println(i[index]);
        } catch (Exception e) {
            st = e.getMessage();
        }
        return st;
    }

    public static void UserExceptionMessage() throws IOException {
        throw new IOException("Device error");
    }


    public static void ExceptionMessage() throws IOException {
        String st = "";
        try {
            throw new IOException("Device error");
        } catch (Exception e) {
            st = e.getMessage();
            System.out.println(st);
        }
    }

    public static void ExceptionURL(String a) throws MalformedURLException {
        new URL(a);
    }

    public static void ExceptionURLFinal(String a) throws MalformedURLException {
        try{
            new URL(a);
        } finally{
            System.out.println("In finally block");
        }
    }

    public static void ExceptionURLPass(String a) {
        try{
            new URL(a);
        } catch (MalformedURLException e) {
            System.out.println("Skip exception and continue");
        } finally {
            System.out.println("In finally block");
        }
    }
}


