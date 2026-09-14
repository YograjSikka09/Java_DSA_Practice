import java.util.ArrayList;

public class FirstLonely {

    public static int FindLonely(ArrayList<Integer>nums){
        for(int i = 0; i < nums.size(); i++){
            int count = 0;
            for(int j = 0; j < nums.size(); j++){
                if(nums.get(i).equals(nums.get(j))){
                    count++;
                }
            }
            if(count==1){
                return nums.get(i);
            }
        }
        return -1;
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

        System.out.println("ArrayList" + nums);
        int ans = FindLonely(nums);
        System.out.println("Lonely Number: " + ans);
    }
}
