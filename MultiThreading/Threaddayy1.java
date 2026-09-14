public class Threaddayy1 {
    public static void main(String[] args) {
        MyThreadd m=new MyThreadd();
        m.start();
        System.out.println("main Thread");

    }

}
class MyThreadd extends Thread{
    public void run(){
        // System.out.println("Thread is Running :");
        for(int i=1;i<=5;i++){
            System.out.println(i);
        }
    }
}
