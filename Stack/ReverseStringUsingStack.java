import java.util.*;
public class ReverseStringUsingStack {
    public static String reverse(String str){
        Stack<Character>st = new Stack<>();
        for(char ch:str.toCharArray()){
            st.push(ch);
        }
        StringBuilder res = new StringBuilder();
        while(!st.isEmpty()){
            res.append(st.pop());
        }
        return res.toString();
    }
    
    public static void main(String[] args) {
        String s1 = "Monik";
        System.out.println("Original: " + s1);
        System.out.println("Reversed: " + reverse(s1));
    }
}
