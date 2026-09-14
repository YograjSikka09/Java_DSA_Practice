package BasicQuestions;

import java.util.*;

public class DivideByZeroException {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        sc.close();
        try {
            System.out.print("Enter first number: ");
            int a = sc.nextInt();
            System.out.print("Enter second number: ");
            int b = sc.nextInt();
            System.out.println("Answer = " + (a / b));
        }
        catch(ArithmeticException e) {
            System.out.println("Cannot divide by zero");}
        catch(InputMismatchException e) {
            System.out.println("Please enter integers only");}

    }
}
