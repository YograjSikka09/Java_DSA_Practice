import java.util.*;

public class StackFSD {
    int[] stack;
    int top;

    StackFSD(int size) {
        stack = new int[size];
        top = -1;
    }

    void push(int value) {
        if (top == stack.length - 1) { 
            System.out.println("Stack Overflow!");
            return;
        }
        top++;
        stack[top] = value;
    }

    int peek() {
        if (top == -1) {
            System.out.println("Stack is empty!");
            return -1;
        }
        return stack[top];
    }

    boolean isEmpty() {
        return top == -1;
    }

    public static void main(String[] args) {
        StackFSD st = new StackFSD(5);
        
        st.push(10);
        st.push(20);
        st.push(30);
        st.push(40);
        System.out.println("Top element (peek): " + st.peek()); 
        System.out.println("Is stack empty? " + st.isEmpty());   
    }
}
