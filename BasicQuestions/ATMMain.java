package BasicQuestions;

class InsufficientBalanceException extends Exception {

    InsufficientBalanceException(String msg) {
        super(msg);
    }
}

class ATM {
    double balance;

    ATM(double b) {
        balance = b;
    }

    void withdraw(double amount) throws InsufficientBalanceException {

        if(amount > balance) {
            throw new InsufficientBalanceException("Insufficient Balance");
        }

        balance = balance - amount;
        System.out.println("Withdrawal Successful");
        System.out.println("Balance: " + balance);
    }
}

public class ATMMain {
    public static void main(String[] args) {

        ATM a = new ATM(10000);

        try {
            a.withdraw(3000);
            a.withdraw(9000);
        }
        catch(InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        }
    }
}
