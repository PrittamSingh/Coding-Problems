import java.util.*;
public class oct26 {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(char ch : s.toCharArray()){
            if(!stack.isEmpty()){
                char c = stack.peek();
                if((ch == ')' && c == '(') || (ch == '}' && c == '{') || (ch == ']' && c == '[')){
                    stack.pop();
                }
                else{
                    stack.push(ch);
                }
            }
            else{
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }
    public static void main(String[] args) {
        String s = "()[]{}";
        String s2 = "(]";
        System.out.println(isValid(s) + " " + isValid(s2));
    }
}
