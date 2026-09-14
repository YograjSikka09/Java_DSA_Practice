import java.util.*;
public class TwoPlayers{
    public static void main(String[] args){
        Player p1 = new Player("Player A ");
        Player p2 = new Player("Player B ");
        p1.start();
        p2.start();
    }
}

class Player extends Thread{
    private String name;
    Player(String name){
        this.name = name;
    }

    public void run(){
        for(int i=0; i<10; i++){
            System.out.println(name + "Position " + i);
            try{
                Thread.sleep(1000);
            }catch(InterruptedException e){
                System.out.println(e);
            }
        }
    }
}