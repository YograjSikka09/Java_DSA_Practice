public class OnlineATM {
    public static void main(String[] args) {
        ATM c1 = new ATM("Monik"); 
        ATM c2 = new ATM("Yograj");
        ATM c3 = new ATM("Neeraj");  
        Thread t1 = new Thread(c1);
        Thread t2 = new Thread(c2);
        Thread t3 = new Thread(c3);
        t1.start();
        t2.start();
        t3.start();
    }
}

class ATM implements Runnable{
    private String customer;
    ATM(String customer){
        this.customer = customer;
    }

    public void run(){
        try{
            System.out.println(customer + " -> Card Inserted");
            Thread.sleep(10000);
            System.out.println(customer + " -> Pin verified");
            Thread.sleep(10000); 
            System.out.println(customer + " -> Transaction processing");
            Thread.sleep(10000);
            System.out.println(customer + " -> Transaction completed");
            Thread.sleep(10000);
        }
        catch(InterruptedException e){
            System.out.println(customer + " Transaction interrupted");
        }
    }

}
