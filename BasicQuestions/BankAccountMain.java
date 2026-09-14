package BasicQuestions;

class BankAccount {
    long accountNumber;
    String accountHolderName;
    double balance;

    BankAccount(long a, String n, double b) {
        accountNumber = a;
        accountHolderName = n;
        balance = b;
    }

    void deposit(double amount) {
        balance = balance + amount;
        System.out.println("Deposited: " + amount);
    }

    void withdraw(double amount) {
        if(amount <= balance) {
            balance = balance - amount;
            System.out.println("Withdrawn: " + amount);
        }
        else {
            System.out.println("Insufficient Balance");
        }
    }

    void checkBalance() {
        System.out.println("Balance: " + balance);
    }
}

public class BankAccountMain {
    public static void main(String[] args) {

        BankAccount b = new BankAccount(4908, "Yograj", 100000);

        b.checkBalance();
        b.deposit(2000);
        b.withdraw(5000);
        b.checkBalance();
        b.withdraw(10000);
    }
}
