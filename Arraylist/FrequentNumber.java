import java.util.*;
public class FrequentNumber {
    public static int frequent(ArrayList<Integer>nums){
        int ans = nums.get(0);
        int maxCount = 0;

        for(int i = 0; i<nums.size(); i++){
            int count = 0;
            for(int j = 0; j<nums.size(); j++){
                if(nums.get(i).equals(nums.get(j))){
                    count++;
                }
            }
            if(count>maxCount){
                maxCount=count;
                ans=nums.get(i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        ArrayList<Integer>nums = new ArrayList<>();
        nums.add(4);
        nums.add(7);
        nums.add(4);
        nums.add(9);
        nums.add(7); 
        nums.add(2);
        nums.add(9);
        nums.add(5);
        nums.add(9);

        System.out.println("ArrayList: " + nums);
        System.out.println("Frequent number: " + frequent(nums));
    }
}
