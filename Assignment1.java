import java.util.Scanner;
import java.util.Arrays;

/*
//* 
//* Kean University
//* Fall 2024
//* Course: CPS*2231 - Computer Programming*
//* Author: John Cunha, Computer Programming
//* 
//* HW Assignment: 1
//* 
//*/

public class Assignment1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("How many students? ");
        int numofstudents = input.nextInt();
        
        int[] id = new int[numofstudents];
        String[] name = new String[numofstudents];
        String[] major = new String[numofstudents];
        
        System.out.println("Enter your Students' Names: ");
        for (int i = 0; i < name.length; i++) {
            name[i] = input.next();
        }
        
        System.out.println("Enter your Students' IDs: ");
        for (int i = 0; i < id.length; i++) {
            id[i] = input.nextInt();
        }
        
        System.out.println("Enter your Students' Majors: ");
        for (int i = 0; i < major.length; i++) {
            major[i] = input.next();
        }
        
        int answer;
        do {
        	System.out.println("-----------------------------");
            System.out.println("For ID Search: Enter 1");
            System.out.println("For Major Enrollment: Enter 2");
            System.out.println("For Exit: Enter 3");
        	System.out.println("-----------------------------");
            System.out.print("Enter: ");
            answer = input.nextInt();

            if (answer == 1) {
                System.out.print("Enter an ID to search for: ");
                int id_to_search = input.nextInt();
                int index = searchStudentID(id, id_to_search);
                
                if (index != -1) {
                    System.out.println("Name: " + name[index]);
                    System.out.println("Major: " + major[index]);
                } else {
                    System.out.println("ID not found.");
                }
            } else if (answer == 2) {
                System.out.print("Enter a Major to search for: ");
                String major_to_search = input.next();
                searchStudentMajor(major, name, major_to_search);
            }
 
        } while (answer == 1 || answer == 2);

        System.out.println("Program Terminates.");
    }
    
    static int searchStudentID(int[] array, int id_to_search) {
        for (int i = 0; i < array.length; i++) {
            if (id_to_search == array[i]) {
                return i;
            }
        }
        return -1;
    }
    
    static void searchStudentMajor(String[] majorarray, String[] nameArray, String major_to_search) {
        boolean found = false;
        for (int i = 0; i < majorarray.length; i++) {
            if (majorarray[i].equalsIgnoreCase(major_to_search)) {
                System.out.println(nameArray[i]);
                found = true;
            }
        }
        
        if(!found) {
        	System.out.println("No student enrolled in the major");
        }
    }
}