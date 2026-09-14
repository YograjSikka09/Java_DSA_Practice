import java.util.*;
public class Sets1 {
    public static void main(String[] args) {
        int arr[] = {1,2,3,1,2,4,5,3,4,5,6,7,6,7};
        Set<Integer>set = new HashSet<>();
        for(int num: arr){
            set.add(num);
            
        }
        System.out.println("Unique elements: " + set);
        System.out.println("The no. of unique elements: " + set.size());
    }
}
