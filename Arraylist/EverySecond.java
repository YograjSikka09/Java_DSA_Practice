import java.util.*;
public class EverySecond {

    public static void remove(ArrayList<Integer>nums){
        for(int i = nums.size()-1;i>=0; i--){
            if (i%2==1) {
                nums.remove(i);
                
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer>nums = new ArrayList<>();
        nums.add(10);
        nums.add(20);
        nums.add(30);
        nums.add(40);
        nums.add(50);
        nums.add(60);
        System.out.println("Before: " + nums);
        remove(nums);
        System.out.println("After " + nums);
    }
}
