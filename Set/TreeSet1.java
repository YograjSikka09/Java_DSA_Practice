import java.util.*;

public class TreeSet1 {
    public static void main(String[] args) {
        // TreeSet<Integer> Set = new TreeSet<>();
        // Set.add(5);
        // Set.add(2);
        // Set.add(8);
        // Set.add(1);
        // Set.add(9);
        // Set.add(5);
        // Set.add(2);
        // System.out.println(Set);



        // int arr[] = { 45, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

        // TreeSet<Integer> Set = new TreeSet<>();
        // for (int i = 0; i < arr.length; i++) {
        //     Set.add(arr[i]);
        // }
        // System.out.println("Smallest: " + Set.first());
        // System.out.println("Largest: " + Set.last());




        // int arr[] = {50, 20, 10, 40, 30, 60, 70, 80, 90};
        // int k = 3;
        // TreeSet<Integer> set = new TreeSet<>();
        // for (int i = 0; i < arr.length; i++) {
        //     set.add(arr[i]);
        // }
        // if(k>set.size()){
        //     System.out.println("Kth smallest element does not exist");
        // } else {
        //     int count = 0;
        //     for (int num : set) {
        //         count++;
        //         if (count == k) {
        //             System.out.println("Kth smallest element is: " + num);
        //             break;
        //         }
        //     }
        // }


        // // closest number
        // int arr[] = { 10, 20, 30, 40, 50 };
        // int x = 26;
        // TreeSet<Integer> set = new TreeSet<>();
        // for (int num: arr) {
        //     set.add(num);
        // }
        // Integer smaller = set.floor(x);
        // Integer greater = set.ceiling(x);

        // int ans;

        // if (smaller == null) {
        //     ans = greater;
        // } else if (greater == null) {
        //     ans = smaller;
        // } else {
        //     int diff1 = x-smaller;
        //     int diff2 = greater-x;
        //     if(diff1<=diff2){
        //         ans=smaller;
        //     } else {
        //         ans=greater;
        //     }
        // }
        // System.out.println("Closest number to " + x + " is: " + ans);






// [10,15,20,25,30,35,40,45,50];
// Range:
//L=20
//R=35
//20 25b 30 35
// int[]arr={10,15,20,25,30,35,40,45,50};
// int l=20;
// int r=35;
// TreeSet<Integer>set=new TreeSet<>();
// for(int num:arr){
//   set.add(num);
// }
// // set.removeAll(set.subSet(l,true,r,true));
// set.removeAll(new TreeSet<>(set.subSet(l,true,r,true)));
// System.out.println("After Removing range "+set);


    }
}

