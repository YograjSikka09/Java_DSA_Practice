package Map;

import java.util.HashMap;

public class StudentMarks {
    public static void main(String[] args) {
        HashMap<String,Integer> marks = new HashMap<>();
        marks.put("Aman",85);
        marks.put("Monik",88);
        marks.put("Lakshay", 87);

        String name = "Lakshay";
        if(marks.containsKey(name)){
            System.out.println("Marks: " + marks.get(name));

        }
        else{
            System.out.println("Student not found in the map");
        }
    }
}
