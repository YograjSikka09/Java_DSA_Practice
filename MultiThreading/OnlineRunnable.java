public class OnlineRunnable {
    public static void main(String[] args){
        FoodOrder pizza = new FoodOrder("Pizza");
        FoodOrder burger = new FoodOrder("Burger");
        FoodOrder pasta = new FoodOrder("Pasta");
        Thread t1 = new Thread(pizza, "Order-1");
        Thread t2 = new Thread(burger, "Order-2");
        Thread t3 = new Thread(pasta, "Order-3");
        t1.start();
        t2.start();
        t3.start();
    }
}

class FoodOrder implements Runnable{
    private String orderName;

    public FoodOrder(String orderName) {
        this.orderName = orderName;
    }

    public void run(){
        try{
            System.out.println(Thread.currentThread().getName()+" -> "+orderName+" Order recieved");
            Thread.sleep(10000);
            System.out.println(Thread.currentThread().getName()+" -> "+orderName+" Order is being prepared");
            Thread.sleep(10000);
            System.out.println(Thread.currentThread().getName()+" -> "+orderName+" Order is ready");
            Thread.sleep(10000);
            System.out.println(Thread.currentThread().getName()+" -> "+orderName+" Order is delivered");
        } catch (InterruptedException e) {
            System.out.println("Order Interrupted");
        }
    }
} 