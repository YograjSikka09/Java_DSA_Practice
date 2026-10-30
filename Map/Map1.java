package Map;
import java.util.*;
public class Map1 {
    public static void main(String[] args) {
        Map<Integer,String>map = new HashMap<>();
        map.put(101,"Aman");
        map.put(102,"Neeraj");
        map.put(103, "Aman");
        map.put(104, "Neeraj");
        System.out.println(map);
        System.out.println(map.get(102));
        map.remove(103);
        System.out.println(map);
        System.out.println(map.containsKey(102));
        System.out.println(map.containsValue("Neeraj"));
        System.out.println(map.size());
        System.out.println(map.isEmpty());

        
    }
}
