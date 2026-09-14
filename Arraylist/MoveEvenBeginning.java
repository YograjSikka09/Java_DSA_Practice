import java.util.ArrayList;

public class MoveEvenBeginning {
    public static void main(String[] args) {
        ArrayList<Integer>list = new ArrayList<>();
        list.add(10);
        list.add(21);
        list.add(30);
        list.add(47);
        list.add(50);        
        list.add(14);
        list.add(23);
        list.add(37);
        list.add(40);
        list.add(59);

        ArrayList<Integer>res = new ArrayList<>();
        for(int i = 0; i<list.size(); i++){
            if(list.get(i)%2 == 0){
                res.add(list.get(i));
            }
        }
            for(int i = 0; i<list.size(); i++){
            if(list.get(i)%2 != 0){
                res.add(list.get(i));
            }

    }

    System.out.println("Original List: " + list);
    System.out.println("Result " + res);
}
}
