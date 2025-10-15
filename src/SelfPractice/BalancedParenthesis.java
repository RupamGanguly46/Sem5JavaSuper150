package SelfPractice;

import java.util.Stack;

public class BalancedParenthesis {
    public static void main(String[] args) {
        String str = "([]){w";
        System.out.println(isBalanced(str));

    }
    public static boolean isBalanced(String str) {
        Stack<Character> st = new Stack<>();
        for(char c: str.toCharArray()){
            if(c=='(' || c=='{' || c=='['){
                st.push(c);
            }
            else if(c==')' && !st.isEmpty() && st.peek()=='('){
                st.pop();
            }
            else if(c=='}' && !st.isEmpty() && st.peek()=='{'){
                st.pop();
            }
            else if(c==']' && !st.isEmpty() && st.peek()=='['){
                st.pop();
            }
            else{
                return false;
            }
        }
        return st.isEmpty();
    }
}
