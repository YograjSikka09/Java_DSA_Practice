package BasicQuestions;

import java.util.*;

class Book {
    String name;
    boolean issued;

    Book(String name) {
        this.name = name;
        issued = false;
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Book> books = new ArrayList<>();

        while(true) {

            System.out.println("1. Add Book");
            System.out.println("2. Issue Book");
            System.out.println("3. Return Book");
            System.out.println("4. Display Books");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            if(choice == 1) {

                System.out.print("Enter book name: ");
                String name = sc.next();

                books.add(new Book(name));
                System.out.println("Book Added");
            }

            else if(choice == 2) {

                System.out.print("Enter book name: ");
                String name = sc.next();

                for(int i = 0; i < books.size(); i++) {

                    if(books.get(i).name.equalsIgnoreCase(name)) {

                        if(!books.get(i).issued) {
                            books.get(i).issued = true;
                            System.out.println("Book Issued");
                        }
                        else {
                            System.out.println("Book already issued");
                        }
                    }
                }
            }

            else if(choice == 3) {

                System.out.print("Enter book name: ");
                String name = sc.next();

                for(int i = 0; i < books.size(); i++) {

                    if(books.get(i).name.equalsIgnoreCase(name)) {
                        books.get(i).issued = false;
                        System.out.println("Book Returned");
                    }
                }
            }

            else if(choice == 4) {

                System.out.println("Available Books:");

                for(int i = 0; i < books.size(); i++) {

                    if(!books.get(i).issued) {
                        System.out.println(books.get(i).name);
                    }
                }
            }

            else if(choice == 5) {
                System.out.println("Exiting...");
                break;
            }

            else {
                System.out.println("Invalid Choice");
            }
        }
    }
}
