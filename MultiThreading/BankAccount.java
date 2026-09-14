import java.util.*;

public class BankAccount {
    public static void main(String[] args) {

        BankAccount1 account = new BankAccount1();
        BankAccount1.Person p1 = account.new Person("Person A", 700, account);

        BankAccount1.Person p2 = account.new Person("Person B", 700, account);

        p1.start();
        p2.start();
    }
}

class BankAccount1 {

    private int balance = 2000;
    synchronized void withdraw(String name, int amount) {

        if (balance >= amount) {

            System.out.println(name + " is going to withdraw " + amount);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e);
            }

            balance -= amount;

            System.out.println("Remaining balance after " + name + " withdraws: " + balance);

        } else {
            System.out.println("Not enough balance for " + name);
        }
    }

    class Person extends Thread {

        private String name;
        private int amount;
        private BankAccount1 account;

        Person(String name, int amount, BankAccount1 account) {
            this.name = name;
            this.amount = amount;
            this.account = account;
        }

        public void run() {
            account.withdraw(name, amount);
        }
    }
}