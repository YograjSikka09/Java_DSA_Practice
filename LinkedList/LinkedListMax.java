import java.util.Collections;
import java.util.LinkedList;

public class LinkedListMax {
    public static void main(String[] args) {
        // Create the list inside the method
        LinkedList<Integer> list = new LinkedList<>(); 
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);
        // int max = list.get(0);
        // for(int i=1;i<list.size();i++){
        //     if(list.get(i)>max){
        //         max = list.get(i);
        //     }
        // }
        
        // System.out.println("Max " + max);

        // System.out.println("Before Reverse: " + list);

        // Collections.reverse(list);

        // System.out.println("After reverse: " + list);

        int slow = 0;
        int fast = 0;

        while(fast<list.size()-1&&fast+1<list.size()){
            slow++;
            fast+=2;
        }

        System.out.println("Middle: " + list.get(slow));
    }
}
