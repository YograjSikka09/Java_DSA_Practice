public class ThreadSignal {

    public static void main(String[] args) {
        TrafficSignal signal=new TrafficSignal();
        signal.start();
    }
}
class TrafficSignal extends Thread{
    public void run(){
        try{
            System.out.println("RED");
            Thread.sleep(1000);
            System.out.println("YELLOW");
            Thread.sleep(1000);
            System.out.println("GREEN");
            // System.out.println();
            Thread.sleep(1000);
            System.out.println("Signal Completed ");
        }
        catch(InterruptedException e){
            System.out.println("Signal Interrupted ");
        }
    }
}