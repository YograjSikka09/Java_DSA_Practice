package BasicQuestions;

import java.util.*;
public class BasicCalculator {
    public static void main(String[] args) {
       
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the First number");
        int a = sc.nextInt();
        System.out.println("Enter the Second number");
        int b = sc.nextInt();
        
        System.out.println("Sum of 2 number is: " + (a+b));
        if (a>b){
        System.out.println("Difference of 2 number is: " + (a-b));}
        else{
            System.out.println("Difference of 2 number is: " + (b-a));} 
        
        System.out.println("Multiplication of two number is: " + a*b);
    
        if (a>b){
        System.out.println("Quotient of 2 number is: " + (a/b));}
        else{
            System.out.println("Quotient of 2 number is: " + (b/a));} 

        if (a>b){
        System.out.println("Remainder of 2 number is: " + (a%b));}
        else{
            System.out.println("Remainder of 2 number is: " + (b%a));}
            sc.close();
    }}