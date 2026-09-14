package Queue;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue; // Add this import

public class QueueFSD {
    public static void main(String[] args) {
        // Queue<Integer>q = new ArrayDeque<>();
        // q.add(10);
        // q.add(20);
        // q.add(30);
        // q.add(40);

        // System.out.println(q);
        // q.offer(50);
        // q.add(60); 

        // System.out.println(q);



        // Queue<Integer>q = new ArrayBlockingQueue<>(2);
        // q.add(10);
        // q.add(20);
        // System.out.println(q);
        // // q.add(30);   it will not add
        
        // System.out.println(q.offer(30));


        // Queue<Integer>q = new LinkedList<>();
        // q.offer(10);
        // q.offer(20);
        // q.offer(30);
        // System.out.println(q);
        // int x = q.poll(); // it will remove the first element
        // System.out.println(x);
        // System.out.println(q);
        // System.out.println(q.peek()); // it will return the first element but not remove it


        // Queue<Integer>q = new LinkedList<>();
        // System.out.println(q.poll()); // it will return null because queue is empty 
        // System.out.println(q.remove()); // it will throw NoSuchElementException because queue is empty



        Queue<Integer>q = new LinkedList<>();
        System.out.println(q.peek()); // it will return null because queue is empty
        System.out.println(q.element()); // it will throw NoSuchElementException because queue is empty
    }
}
