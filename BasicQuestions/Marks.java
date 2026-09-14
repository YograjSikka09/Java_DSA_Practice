package BasicQuestions;

import java.util.*;

public class Marks {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter marks of 5 subjects:");

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();
        int e = sc.nextInt();

        int total = a+b+c+d+e;

        double percentage = (total / 500.0)*100;
        double average = total/5.0;

        System.out.println("Total Marks: " + total);
        System.out.println("Percentage: " + percentage+"%");
        System.out.println("Average: " + average);

        sc.close();
    }
}