import java.util.*;
public class LinkedHashSet1 {
    public static void main(String[] args) {
    // LinkedHashSet<Integer> set = new LinkedHashSet<>();
    // set.add(1);
    // set.add(2);
    // set.add(3);
    // set.add(2); // Duplicate element, will not be added
    // set.add(4);

    // System.out.println(set); // Output: [1, 2, 3, 4]


    //Maintaining insertion order

    // int arr[] = {10,20,10,50,35,30,20,40};
    // LinkedHashSet<Integer> set = new LinkedHashSet<>();
    // for(int i=0;i<arr.length;i++){
    //     set.add(arr[i]);
    // }
    // System.out.println(set);


    //First element which is repeated in an array
//     int arr[] = {10,20,10,50,35,30,20,40};
//     LinkedHashSet<Integer> set = new LinkedHashSet<>();
//     for(int x:arr){
//         if(set.contains(x)){
//             System.out.println("First repeated element: " + x);
//             break;
//         }
//         else{
//             set.add(x);
//         }
        
// }



    // int arr1[] = {10,20,30,40,50};
    // int arr2[] = {30,40,50,60,70};
    // LinkedHashSet<Integer> set = new LinkedHashSet<>();
    // for(int x:arr1){
    //     set.add(x);}
    //     LinkedHashSet<Integer> res = new LinkedHashSet<>();
    //     for(int x:arr2){
    //         if(set.contains(x)){
    //             res.add(x);
    //         }
    //     }
    //     System.out.println(res);




    // Remove duplicate from string maintaining first occurance order
    // String str = "programming";
    // LinkedHashSet<Character> set = new LinkedHashSet<>();
    // for(char ch:str.toCharArray()){
    //     set.add(ch);
    // }
    // String res = "";
    // for(char ch:set){
    //     res+=ch;
    // }
    // System.out.println(res);




    // Given string: First non repeating char 
    // Swiss --- w

    // String str = "swiss";
    // LinkedHashSet<Character> set = new LinkedHashSet<>();
    // HashMap<Character,Integer> freq = new HashMap<>();
    // for(char ch:str.toCharArray()){
    //     set.add(ch);
    //     freq.put(ch,freq.getOrDefault(ch,0)+1);
    // }  

    // for(char ch:set){
    //     if(freq.get(ch)==1){
    //         System.out.println("First non repeating: " + ch);
    //         return;
    //     }
    // }

}
}

