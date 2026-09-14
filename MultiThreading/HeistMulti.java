import java.util.*;

public class HeistMulti {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("=====================");
        System.out.println("Bank Heist Game");
        System.out.println("#####################");
        System.out.print("Enter your Hacker Name: ");
        String hacker = sc.nextLine();
        System.out.print("Enter your Runner Name: ");
        String runner = sc.nextLine();
        System.out.print("Enter your Collector Name: ");
        String collector = sc.nextLine();  
        System.out.println("Now the Team is ready: ");
        System.out.println("Hacker      "+ hacker);
        System.out.println("Runner      "+ runner);
        System.out.println("Collector   "+ collector);
        System.out.println("\nMission Started");

        HeistTask task1 = new HeistTask("Hacker " + hacker);
        HeistTask task2 = new HeistTask("Runner " + runner);
        HeistTask task3 = new HeistTask("Collector " + collector);

        Thread t1 = new Thread(task1);
        Thread t2 = new Thread(task2);
        Thread t3 = new Thread(task3);

        t1.start();
        t2.start();
        t3.start();

        try{
            t1.join();
            t2.join();
            t3.join();
        }catch (InterruptedException e){
            System.out.println("Mission Interrupted");
        }
        System.out.println("====================");
        System.out.println("      Mission Completed    ");
        System.out.println("====================");
        System.out.println("Your Team escaped with money");
        System.out.println("Chori successfully");

    }
}

class HeistTask implements Runnable{
    private String name;
    private Random random = new Random();
    HeistTask(String name){
        this.name = name;
    }

    public void run() {
    try {
        System.out.println("[" + name + "] Entered the bank");

        Thread.sleep(10000);

        int event = random.nextInt(4);

        if (event == 0) {
            System.out.println("[" + name + "] Found security camera");
            Thread.sleep(10000);
            System.out.println("[" + name + "] Avoided the camera");
        }

        else if (event == 1) {
            System.out.println("[" + name + "] Triggered the Alarm");
            Thread.sleep(10000);
            System.out.println("[" + name + "] Quickly disabled the alarm");
        }

        else if (event == 2) {
            System.out.println("[" + name + "] Found the door locked");
            Thread.sleep(10000);
            System.out.println("[" + name + "] Opened the door");
        }

        else {
            System.out.println("[" + name + "] Found the money room");
            Thread.sleep(10000);
            System.out.println("[" + name + "] Grabbed the cash");
        }

        Thread.sleep(10000);
        System.out.println("[" + name + "] is escaping");

        Thread.sleep(10000);
        System.out.println("[" + name + "] escaped successfully");

    } catch (InterruptedException e) {
        System.out.println("[" + name + "] got caught");
    }
}

}
