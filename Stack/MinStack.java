import java.util.*;

public class MinStack {

    Stack<Integer> stack;
    Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {

        stack.push(val);

        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    public void pop() {

        int val = stack.pop();

        if (val == minStack.peek()) {
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {

        MinStack obj = new MinStack();

        obj.push(5);
        obj.push(3);
        obj.push(7);
        obj.push(2);

        System.out.println(obj.getMin()); 

        obj.pop();

        System.out.println(obj.getMin());  
        System.out.println(obj.top());   
    }
}