package Map;
import java.util.*;
public class TotalBill {
    public static void main(String[] args) {
        HashMap<String,Integer>price = new HashMap<>();
        price.put("Pen", 20);
        price.put("Book", 200);
        price.put("Bag", 1500);
        price.put("Bottle", 250);
        price.put("Laptop", 95000);

        String[] cart = {"Pen", "Book", "Bag", "Laptop"};
        int total = 0;
        for(String item:cart){
            if(price.containsKey(item)){
                total+=price.get(item);
            }
        }

        System.out.println("Total Bill: " + total);
    }
}
