package SelfPractice;
import java.util.*;
public class ReverseStringWithStack {
    public static void main(String[] args) {
        Stack<Character> stack = new Stack<>();
        String str = "Hello";
        for (char c : str.toCharArray()) {
            stack.push(c);
        }
        StringBuilder reversed = new StringBuilder();
        while (!stack.isEmpty()) {
            reversed.append(stack.pop());
        }
        System.out.println(reversed);
    }
}
