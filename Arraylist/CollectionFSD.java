import java.util.ArrayList;

public class CollectionFSD {
    public static void main(String[] args) {
        ArrayList<String>students = new ArrayList<>();
        students.add("Monik");
        students.add("Yograj");
        students.add("Kuli");
        students.add("Tanish");
        System.out.println(students);
        System.out.println("Size: " + students.size());
        System.out.println("First student " + students.get(0));
        System.out.println(students.contains("Kuli"));
        students.remove("Kuli");
        System.out.println(students);
        

    }
}
