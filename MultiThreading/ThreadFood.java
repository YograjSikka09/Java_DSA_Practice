public class ThreadFood {
    public static void main(String[] args) {
        FoodTask res=new FoodTask("Restaurant ");
        FoodTask del=new FoodTask("Delivery Partner ");
        FoodTask cus=new FoodTask("Customer ");
        res.start();
        del.start();
        cus.start(); 
        // Long.
    }
}
class FoodTask extends Thread{
    FoodTask(String name){
        super(name);
    }
    public void run(){
        try{
            for(int i=1;i<=3;i++){
                System.out.println(
                    Thread.currentThread().getName()
                    +"-> Step "+i
                );
                Thread.sleep(1000);
                // Thread.sl
            }
        }catch(InterruptedException e){
            System.out.println("Task Interuppted : ");
        }
    }
}