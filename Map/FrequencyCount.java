package Map;
import java.util.*;
public class FrequencyCount {
    public static void main(String[] args) {
     int arr[] = {2,3,2,5,3,2,4,5};
     HashMap<Integer,Integer>map = new HashMap<>();

     for (int num : arr) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
  
        
      
    }
}
