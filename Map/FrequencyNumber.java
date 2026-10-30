package Map;
import java.util.*;
public class FrequencyNumber {
    public static void main(String[] args) {
        HashMap<String,Integer> marks = new HashMap<>();
        marks.put("Aman", 78);
        marks.put("Rahul", 92);
        marks.put("Neeraj", 88);
        marks.put("Riya", 95);
        marks.put("Karan", 81);

        String name = null;
        int max = 0;
        for (Map.Entry<String, Integer> students : marks.entrySet()) {
            if (students.getValue() > max) {
                max = students.getValue();
                name = students.getKey();
            }
        }

        System.out.println("Top Student: " + name);
        System.out.println("Marks: " + max);
    }
}
