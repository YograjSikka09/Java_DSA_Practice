package BasicQuestions;

import java.util.*;

public class MarksGrade {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter percentage: ");
        int percentage = sc.nextInt();

        if (percentage >= 90) {
            System.out.println("A+");} 
        else if (percentage >= 80) {
            System.out.println("A");} 
        else if (percentage >= 70) {
            System.out.println("B");} 
        else if (percentage >= 60) {
            System.out.println("C");} 
        else {
            System.out.println("Fail");

            sc.close();
        }
    }
}
