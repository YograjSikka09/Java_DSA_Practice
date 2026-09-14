import java.util.*;
public class Frequent2 {
    public static void mostF(ArrayList<Integer>nums){
        int maxCount=0;
        for(int i = 0; i <nums.size();i++){
            int count=0;
            for(int j=0; j<nums.size(); j++){
                if(nums.get(i).equals(nums.get(j))){
                count++;
                }
            }
                if(count>maxCount){
                maxCount=count;}
        }
        System.out.println("Maximun Frequency: " + maxCount);
        System.err.println("Most Frequent numbers: ");
                for(int i = 0; i <nums.size();i++){
            int count=0;
            for(int j=0; j<nums.size(); j++){
                



            }
        }
    }
}
