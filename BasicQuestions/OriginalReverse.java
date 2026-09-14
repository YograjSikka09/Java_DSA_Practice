package BasicQuestions;

import java.util.*;

public class OriginalReverse {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();
        int original = n;
        int reverse = 0;

        while(n>0) {
            int digit = n%10;
            reverse = reverse*10+digit;
            n = n/10;}
      
        if (original==reverse){
        System.out.println("It is Palindrome");}
        else{
            System.out.println("Not An Palindrome");

            sc.close();
        }
}}
