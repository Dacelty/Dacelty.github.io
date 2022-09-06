import java.util.*;

public class bt20 {
    public static void main(String[] args) {
        System.out.println(isValid("()"));
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("(]"));
    }

    public static boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c=='(' || c=='[' || c=='{')  st.push(c);
            else if(!st.isEmpty() && c==')' &&  st.peek()=='(') st.pop();
            else if(!st.isEmpty() && c==']' &&  st.peek()=='[') st.pop();
            else if(!st.isEmpty() && c=='}' &&  st.peek()=='{') st.pop();
            else return false;
        }
        return st.isEmpty();
    }
}
