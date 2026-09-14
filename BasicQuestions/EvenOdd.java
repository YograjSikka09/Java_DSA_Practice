package BasicQuestions;

import java.util.*;

public class EvenOdd {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int n = sc.nextInt();

        if (n % 2 == 0) {
            System.out.println("Even");} 
        else {
            System.out.println("Odd"); }

        if (n > 0) {
            System.out.println("Positive");} 
        else if (n < 0) {
            System.out.println("Negative");} 
        else {
            System.out.println("Zero");}

            sc.close();
    }
}