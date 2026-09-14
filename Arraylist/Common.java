import java.util.ArrayList;

public class Common {
    public static void main(String[] args) {
        ArrayList<Integer>list1 = new ArrayList<>();
        ArrayList<Integer>list2 = new ArrayList<>();
        list1.add(10);
        list1.add(21);
        list1.add(30);
        list1.add(47);
        list1.add(50);  
        list1.add(1);      
        list2.add(14);
        list2.add(21);
        list2.add(47);
        list2.add(40);
        list2.add(50);
        list2.add(1);
        list2.add(2);
        list2.add(3);

        ArrayList<Integer>common = new ArrayList<>();
        for(int i = 0; i<list1.size(); i++){
            if(list2.contains(list1.get(i))){
                common.add(list1.get(i));
            }
        }

        System.out.println("List 1: " + list1);
        System.out.println("List 2: " + list2);
        System.out.println("Common Elements: " + common);
    }
}
