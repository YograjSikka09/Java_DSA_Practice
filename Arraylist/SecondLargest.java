import java.util.*;

public class SecondLargest {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);   
        
        int largest = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;

        for(int i = 0; i<list.size(); i++){
            int curr = list.get(i);

            if (curr>largest){
                second = largest;
                largest = curr;
            }
            else if (curr>second&& curr!=largest){
                second = curr;
            }
        }

        System.out.println("List: " + list);
        System.out.println("Largest: " + largest);
        System.out.println("Second Largest: " + second);
    }
}
