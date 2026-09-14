import java.util.ArrayList;

public class FSDZArrayList {
    public static void main(String[] args) {
        ArrayList<Integer>list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(20);
        list.add(30);

        System.out.println(list);

        ArrayList<Integer>un = new ArrayList<>();
        for(int i = 0; i < list.size(); i++){
            if(!un.contains(list.get(i))){
                un.add(list.get(i));
            }
        }

        System.out.println("Original list: " + list);
        System.out.println("Unique Element List: " + un);

    }
}
