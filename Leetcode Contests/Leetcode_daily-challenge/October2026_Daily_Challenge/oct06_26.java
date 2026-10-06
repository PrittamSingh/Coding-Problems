import java.util.Stack;

public class oct06_26 {
    public static int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);
            if(!stack.isEmpty()){
                if(stack.peek() == '(' && ch == ')'){
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
        int count = 0;
        while(!stack.isEmpty()){
            count++;
            stack.pop();
        }
        return count;
    }
    public static void main(String[] args) {
        String s = "(((";
        System.out.println(minAddToMakeValid(s));
    }
}
