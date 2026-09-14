import java.util.HashSet;
import java.util.Set;

public class FirstRepeatedElement {
    public static void main(String[] args) {
        int arr[] = {1,2,3,1,2,4,5,3,4,5,6,7,6,7};
        Set<Integer>set = new HashSet<>();
        int ans = -1;
        for(int num:arr){
            if(set.contains(num)){
                ans=num;
                break;
            }
            set.add(num);
        }
        System.out.println("First Repeated Element: " + ans);
    }
}
