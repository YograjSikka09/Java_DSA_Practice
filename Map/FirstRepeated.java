package Map;

import java.util.HashMap;

public class FirstRepeated {
    public static void main(String[] args) {       
    
    int[] arr = {5, 3, 8, 2, 3, 9, 8};

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.get(num) == 2) {
                System.out.println(num);
                break;
            }
        }
}
}
