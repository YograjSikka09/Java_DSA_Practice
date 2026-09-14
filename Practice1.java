// Question Number 1:

// import java.util.*;
// public class Main {
//     public static void main(String[] args) {
       
//         Scanner sc = new Scanner(System.in);
//         System.out.println("Enter the First number");
//         int a = sc.nextInt();
//         System.out.println("Enter the Second number");
//         int b = sc.nextInt();
        
//         System.out.println("Sum of 2 number is: " + (a+b));
//         if (a>b){
//         System.out.println("Difference of 2 number is: " + (a-b));}
//         else{
//             System.out.println("Difference of 2 number is: " + (b-a));} 
        
//         System.out.println("Multiplication of two number is: " + a*b);
    
//         if (a>b){
//         System.out.println("Quotient of 2 number is: " + (a/b));}
//         else{
//             System.out.println("Quotient of 2 number is: " + (b/a));} 

//         if (a>b){
//         System.out.println("Remainder of 2 number is: " + (a%b));}
//         else{
//             System.out.println("Remainder of 2 number is: " + (b%a));}
//     }}

// Question Number 2:

// import java.util.*;
// public class Main {
//     public static void main(String[] args) {
        
//         Scanner sc = new Scanner(System.in);
//         System.out.println("Enter the first Number: ");
//         int a = sc.nextInt();
//         System.out.println("Enter the Second Number: ");
//         int b = sc.nextInt();
        
//         a = a+b;
//         b= a-b;
//         a= a-b;
//         System.out.println("Swapped number is: " + a + "," + b);
        
//     }
// }

// Question Number 3:

// import java.util.*;

// public class Main {
//     public static void main(String[] args) {

//         Scanner sc = new Scanner(System.in);
//         System.out.println("Enter a number: ");
//         int n = sc.nextInt();

//         if (n % 2 == 0) {
//             System.out.println("Even");} 
//         else {
//             System.out.println("Odd"); }

//         if (n > 0) {
//             System.out.println("Positive");} 
//         else if (n < 0) {
//             System.out.println("Negative");} 
//         else {
//             System.out.println("Zero");}
//     }
// }

// Question Number 4:

// import java.util.*;

// public class Main {
//     public static void main(String[] args) {

//         Scanner sc = new Scanner(System.in);
//         System.out.println("Enter marks of 5 subjects:");

//         int a = sc.nextInt();
//         int b = sc.nextInt();
//         int c = sc.nextInt();
//         int d = sc.nextInt();
//         int e = sc.nextInt();

//         int total = a+b+c+d+e;

//         double percentage = (total / 500.0)*100;
//         double average = total/5.0;

//         System.out.println("Total Marks: " + total);
//         System.out.println("Percentage: " + percentage+"%");
//         System.out.println("Average: " + average);
//     }
// }

// Question Number 5:

// import java.util.*;

// public class Main {
//     public static void main(String[] args) {

//         Scanner sc = new Scanner(System.in);
//         System.out.println("Enter first number: ");
//         int a = sc.nextInt();
        
//         System.out.println("Enter second number: ");
//         int b = sc.nextInt();
        
//         System.out.println("Enter third number: ");
//         int c = sc.nextInt();

//         if (a>b && a>c) {
//             System.out.println("First number is largest which is: "+ a);} 
//         else if(b>a && b>c) {
//             System.out.println("Second number is largest which is: "+b); }
//         else {
//             System.out.println("Third number is largest which is: "+c);}
//     }
// }

// Question Number 6:

// import java.util.*;

// public class Main {
//     public static void main(String[] args) {

//         Scanner sc = new Scanner(System.in);
//         System.out.println("Enter units: ");
//         int units = sc.nextInt();

//         int bill = 0;

//         if (units <= 100) {
//             bill = units * 5; } 
//         else if (units <= 200) {
//             bill = (100 * 5) + ((units - 100) * 7); } 
//         else {
//             bill = (100 * 5) + (100 * 7) + ((units - 200) * 10);}

//         System.out.println("Electricity Bill = Rs." + bill);
//     }
// }

// Question Number 7:


// import java.util.*;

// public class Main {
//     public static void main(String[] args) {

//         Scanner sc = new Scanner(System.in);
//         System.out.println("Enter year: ");
//         int year = sc.nextInt();

//         if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
//             System.out.println("Leap Year");} 
//         else {
//             System.out.println("Not a Leap Year");}
//     }
// }

// Question Number 8:

// import java.util.*;

// public class Main {
//     public static void main(String[] args) {

//         Scanner sc = new Scanner(System.in);
//         System.out.print("Enter percentage: ");
//         int percentage = sc.nextInt();

//         if (percentage >= 90) {
//             System.out.println("A+");} 
//         else if (percentage >= 80) {
//             System.out.println("A");} 
//         else if (percentage >= 70) {
//             System.out.println("B");} 
//         else if (percentage >= 60) {
//             System.out.println("C");} 
//         else {
//             System.out.println("Fail");
//         }
//     }
// }

// Question Number 9:

// import java.util.*;
// public class Main {
//     public static void main(String[] args) {

//         for (int i = 1; i <= 100; i++) {

//             if (i % 2 == 0) {
//                 System.out.println(i); }}
//     }
// }

// Question Number 10:

// import java.util.*;

// public class Main {
//     public static void main(String[] args) {

//         Scanner sc = new Scanner(System.in);
//         System.out.print("Enter a number: ");
//         int n = sc.nextInt();
//         long factorial = 1;

//         for (int i = 1; i <= n; i++) {
//             factorial = factorial * i;}
//         System.out.println("Factorial: " + factorial);
//     }
// }

// Question Number 11:

// import java.util.*;

// public class Main {
//     public static void main(String[] args) {

//         Scanner sc = new Scanner(System.in);
//         System.out.print("Enter a number: ");
//         int n = sc.nextInt();
//         int reverse = 0;

//         while(n>0) {
//             int digit = n%10;
//             reverse = reverse*10+digit;
//             n = n/10;}
//         System.out.println("Reverse is: " + reverse);

// }}

// Question Number 12:

// import java.util.*;

// public class Main {
//     public static void main(String[] args) {

//         Scanner sc = new Scanner(System.in);
//         System.out.print("Enter a number: ");
//         int n = sc.nextInt();
//         int original = n;
//         int reverse = 0;

//         while(n>0) {
//             int digit = n%10;
//             reverse = reverse*10+digit;
//             n = n/10;}
      
//         if (original==reverse){
//         System.out.println("It is Palindrome");}
//         else{
//             System.out.println("Not An Palindrome");
//         }
// }}

// Question Number 13:

// import java.util.*;

// public class Main {
//     public static void main(String[] args) {

//         Scanner sc = new Scanner(System.in);
//         System.out.print("Enter number of terms: ");
//         int n = sc.nextInt();
//         int a = 0;
//         int b = 1;

//         for (int i = 1; i <= n; i++) {
//             System.out.print(a + " ");

//             int c = a + b;
//             a = b;
//             b = c;}
//     }}

// Question Number 14:

// import java.util.*;

// public class Main {
//     public static void main(String[] args) {

//         Scanner sc = new Scanner(System.in);
//         System.out.print("Enter a number: ");
//         int n = sc.nextInt();
//         int sum = 0;

//         while (n > 0) {
//             int digit = n % 10;
//             sum = sum + digit;
//             n = n / 10;}
//         System.out.println("Sum of digits: " + sum);
//     }}

// Question Number 15:

// import java.util.*;

// class Student {
//     int id;
//     String name;
//     String course;
//     double marks;

//     void inputDetails() {
//         Scanner sc = new Scanner(System.in);
//         System.out.print("Enter Student ID: ");
//         id = sc.nextInt();
//         sc.nextLine();
//         System.out.print("Enter Student Name: ");
//         name = sc.nextLine();
//         System.out.print("Enter Course: ");
//         course = sc.nextLine();
//         System.out.print("Enter Marks: ");
//         marks = sc.nextDouble();}

//     void calculateGrade() {

//         if (marks >= 90) {
//             System.out.println("Grade: A+");}
//         else if (marks >= 80) {
//             System.out.println("Grade: A");}
//         else if (marks >= 70) {
//             System.out.println("Grade: B");}
//         else if (marks >= 60) {
//             System.out.println("Grade: C");}
//         else {
//             System.out.println("Grade: Fail");}
//     }
//     void displayDetails() {
//         System.out.println("Student Details: ");
//         System.out.println("ID: " + id);
//         System.out.println("Name: " + name);
//         System.out.println("Course: " + course);
//         System.out.println("Marks: " + marks);

//         calculateGrade();
//     }
// }

// public class Main {
//     public static void main(String[] args) {

//         Student s = new Student();

//         s.inputDetails();
//         s.displayDetails();
//     }
// }

// Question Number 16:

// import java.util.*;

// class BankAccount {
//     long accountNumber;
//     String accountHolderName;
//     double balance;

//     BankAccount(long a, String n, double b) {
//         accountNumber = a;
//         accountHolderName = n;
//         balance = b;
//     }

//     void deposit(double amount) {
//         balance = balance + amount;
//         System.out.println("Deposited: " + amount);
//     }

//     void withdraw(double amount) {
//         if(amount <= balance) {
//             balance = balance - amount;
//             System.out.println("Withdrawn: " + amount);
//         }
//         else {
//             System.out.println("Insufficient Balance");
//         }
//     }

//     void checkBalance() {
//         System.out.println("Balance: " + balance);
//     }
// }

// public class Main {
//     public static void main(String[] args) {

//         BankAccount b = new BankAccount(4908, "Yograj", 100000);

//         b.checkBalance();
//         b.deposit(2000);
//         b.withdraw(5000);
//         b.checkBalance();
//         b.withdraw(10000);
//     }
// }

// Question Number 17:

// import java.util.*;
// class Employee {
//     int id;
//     String name;
//     double basicSalary;

//     Employee(int i, String n, double s) {
//         id = i;
//         name = n;
//         basicSalary = s;
//     }

//     double calculateHRA() {
//         return basicSalary * 0.20;
//     }

//     double calculateDA() {
//         return basicSalary * 0.10;
//     }

//     double calculateGrossSalary() {
//         return basicSalary + calculateHRA() + calculateDA();
//     }
// }

// public class Main {
//     public static void main(String[] args) {

//         Employee e = new Employee(4908, "Yogeraj", 20000);

//         System.out.println("HRA = " + e.calculateHRA());
//         System.out.println("DA = " + e.calculateDA());
//         System.out.println("Gross Salary = " + e.calculateGrossSalary());
//     }
// }

// Question Number 18:

// import java.util.*;
// class Person {
//     String name;
//     int age;

//     void displayPerson() {
//         System.out.println("Name: " + name);
//         System.out.println("Age: " + age);
//     }
// }

// class Student extends Person {
//     int rollNumber;
//     String course;

//     void displayStudent() {
//         displayPerson();
//         System.out.println("Roll Number: " + rollNumber);
//         System.out.println("Course: " + course);
//     }
// }

// public class Main {
//     public static void main(String[] args) {

//         Student s = new Student();
//         s.name = "Yograj";
//         s.age = 21;
//         s.rollNumber = 4908;
//         s.course = "Programming Abstraction using Java";
//         s.displayStudent();
//     }
// }

// Question Number 19:

// import java.util.*;

// public class Main {
//     public static void main(String[] args) {

//         Scanner sc = new Scanner(System.in);
//         try {
//             System.out.print("Enter first number: ");
//             int a = sc.nextInt();
//             System.out.print("Enter second number: ");
//             int b = sc.nextInt();
//             System.out.println("Answer = " + (a / b));
//         }
//         catch(ArithmeticException e) {
//             System.out.println("Cannot divide by zero");}
//         catch(InputMismatchException e) {
//             System.out.println("Please enter integers only");}
//     }
// }

// Question Number 20:

// class InsufficientBalanceException extends Exception {

//     InsufficientBalanceException(String msg) {
//         super(msg);
//     }
// }

// class ATM {
//     double balance;

//     ATM(double b) {
//         balance = b;
//     }

//     void withdraw(double amount) throws InsufficientBalanceException {

//         if(amount > balance) {
//             throw new InsufficientBalanceException("Insufficient Balance");
//         }

//         balance = balance - amount;
//         System.out.println("Withdrawal Successful");
//         System.out.println("Balance: " + balance);
//     }
// }

// public class Main {
//     public static void main(String[] args) {

//         ATM a = new ATM(10000);

//         try {
//             a.withdraw(3000);
//             a.withdraw(9000);
//         }
//         catch(InsufficientBalanceException e) {
//             System.out.println(e.getMessage());
//         }
//     }
// }

// Question Number 21:

// import java.util.*;

// public class Main {
//     public static void main(String[] args) {

//         Scanner sc = new Scanner(System.in);
//         System.out.print("Enter the string: ");
//         String s = sc.nextLine();
//         int vowels = 0;
//         int consonants = 0;

//         for(int i = 0; i < s.length(); i++) {
//             char ch = Character.toLowerCase(s.charAt(i));

//             if(ch >= 'a' && ch <= 'z') {
//                 if(ch == 'a' || ch == 'e' || ch == 'i' ||
//                    ch == 'o' || ch == 'u') {
//                     vowels++;}
//                 else {
//                     consonants++;}}}
//         System.out.println("Vowels = " + vowels);
//         System.out.println("Consonants = " + consonants);
//     }
// }

// Question Number 22:

// import java.util.*;

// public class Main {
//     public static void main(String[] args) {

//         Scanner sc = new Scanner(System.in);
//         System.out.print("Enter number: ");
//         int n = sc.nextInt();
//         int original = n;
//         int sum = 0;

//         while(n > 0) {
//             int digit = n % 10;
//             sum = sum + digit * digit * digit;
//             n = n / 10;}
//         if(sum == original) {
//             System.out.println("Armstrong Number");}
//         else {
//             System.out.println("Not Armstrong Number");}
//     }
// }

// Question Number 23:

// import java.util.*;
// public class Main {
//     public static void main(String[] args) {

//         for(int i = 1; i <= 5; i++) {

//             for(int j = 1; j <= i; j++) {
//                 System.out.print("*");}
//             System.out.println();}
//     }
// }

// Question Number 24:

// import java.util.*;
// public class Main {
//     public static void main(String[] args) {
//         int num = 1;
        
//         for(int i = 1; i <= 4; i++) {
//             for(int j = 1; j <= i; j++) {
//                 System.out.print(num + " ");
//                 num++;}
//             System.out.println();}
//     }
// }

// Question Number 25:

// import java.util.*;

// class Book {
//     String name;
//     boolean issued;

//     Book(String name) {
//         this.name = name;
//         issued = false;
//     }
// }

// public class Main {
//     public static void main(String[] args) {

//         Scanner sc = new Scanner(System.in);
//         ArrayList<Book> books = new ArrayList<>();

//         while(true) {

//             System.out.println("1. Add Book");
//             System.out.println("2. Issue Book");
//             System.out.println("3. Return Book");
//             System.out.println("4. Display Books");
//             System.out.println("5. Exit");

//             System.out.print("Enter your choice: ");
//             int choice = sc.nextInt();

//             if(choice == 1) {

//                 System.out.print("Enter book name: ");
//                 String name = sc.next();

//                 books.add(new Book(name));
//                 System.out.println("Book Added");
//             }

//             else if(choice == 2) {

//                 System.out.print("Enter book name: ");
//                 String name = sc.next();

//                 for(int i = 0; i < books.size(); i++) {

//                     if(books.get(i).name.equalsIgnoreCase(name)) {

//                         if(!books.get(i).issued) {
//                             books.get(i).issued = true;
//                             System.out.println("Book Issued");
//                         }
//                         else {
//                             System.out.println("Book already issued");
//                         }
//                     }
//                 }
//             }

//             else if(choice == 3) {

//                 System.out.print("Enter book name: ");
//                 String name = sc.next();

//                 for(int i = 0; i < books.size(); i++) {

//                     if(books.get(i).name.equalsIgnoreCase(name)) {
//                         books.get(i).issued = false;
//                         System.out.println("Book Returned");
//                     }
//                 }
//             }

//             else if(choice == 4) {

//                 System.out.println("Available Books:");

//                 for(int i = 0; i < books.size(); i++) {

//                     if(!books.get(i).issued) {
//                         System.out.println(books.get(i).name);
//                     }
//                 }
//             }

//             else if(choice == 5) {
//                 System.out.println("Exiting...");
//                 break;
//             }

//             else {
//                 System.out.println("Invalid Choice");
//             }
//         }
//     }
// }
