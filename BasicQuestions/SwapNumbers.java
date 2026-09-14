package BasicQuestions;

import java.util.*;
public class SwapNumbers {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the first Number: ");
        int a = sc.nextInt();
        System.out.println("Enter the Second Number: ");
        int b = sc.nextInt();
        
        a = a+b;
        b= a-b;
        a= a-b;
        System.out.println("Swapped number is: " + a + "," + b);
        sc.close();
    }
}