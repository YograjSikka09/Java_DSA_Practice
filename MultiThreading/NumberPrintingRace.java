public class NumberPrintingRace {
    //We have to create Two Threads using Thread:
    //by extending Thread class
    //By implementing Runnable interface:
    //Thread 1: print numbers 1-5
    //Thread 2: print numbers 6-10
    //both Threads Run simultanously
    //also print the name of the thread:
    public static void main(String[] args) {
        NumberThread t1=new NumberThread("Thread - A", 1, 5);
        NumberThread t2=new NumberThread("Thread - B", 6, 10);
        t1.start();;
        t2.start();
    }

}
class NumberThread extends Thread{
    private int start;
    private int end;
    NumberThread(String name,int start,int end){
        super(name);
        this.start=start;
        this.end=end;

    }
    public void run(){
        for(int i=start;i<=end;i++){
            System.out.println(
                Thread.currentThread().getName()
                +" -> "+i
            );
        }
    }

}