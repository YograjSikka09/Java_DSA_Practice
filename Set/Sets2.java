import java.util.HashSet;
import java.util.Set;

public class Sets2 {
    public static void main(String[] args) {
        int[] arr1 = {1,2,3,4,5};
        int[] arr2 = {7,8,9,1,2};

        Set<Integer>set = new HashSet<>();
        for(int num:arr1){
            set.add(num);
        }
        
        System.out.println("Common elements: ");

        for(int num:arr2){
            if(set.contains(num)){
                System.out.println(num+ " ");
            }
        }
    }
}
