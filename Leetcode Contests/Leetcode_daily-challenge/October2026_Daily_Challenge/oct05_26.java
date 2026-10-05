import java.util.Stack;

public class oct05_26 {
    public static int scoreOfParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);
            if(ch == '('){
                stack.push(0);
            }
            else{
                int inner = stack.pop();
                int score;
                if(inner == 0){
                    score = 1;
                }
                else{
                    score = 2 * inner;
                }
                int top = stack.pop();
                stack.push(top + score);
            }
        }
        return stack.pop();
    }
    public static void main(String[] args) {
        String s = "(())";
        System.out.println(scoreOfParentheses(s));
    }
}
