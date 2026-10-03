import java.util.Stack;

public class oct03_26 {
    public static int longestValidParentheses(String s) {
        int n = s.length();
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int maxLen = 0;
        for(int i = 0 ; i < n ; i++){
            char ch = s.charAt(i);
            if(ch == '('){
                stack.push(i);
            }
            else{
                stack.pop();
                if(stack.isEmpty()){
                    stack.push(i);
                }
                else{
                    maxLen = Math.max(maxLen, i - stack.peek());
                }
            }
        }
        return maxLen;
    }
    public static void main(String[] args) {
        String s = ")()())";
        String s2 = "(()";
        System.out.println(longestValidParentheses(s) + " " + longestValidParentheses(s2));
    }




    // public int longestValidParentheses(String s) {
    //     int n = s.length();
    //     int ans = 0;
    //     for(int i = 0 ; i < n ; i++){
    //         for(int j = i ; j < n ; j++){
    //             String substr = s.substring(i, j + 1);
    //             if(isValid(substr)){
    //                 ans = Math.max(ans, substr.length());
    //             }
    //         }
    //     }
    //     return ans;
    // }
    // public boolean isValid(String substr){
    //     Stack<Character> stack = new Stack<>();
    //     for(int i = 0 ; i < substr.length() ; i++){
    //         if(stack.isEmpty()){
    //             stack.push(substr.charAt(i));
    //         }
    //         else{
    //             if(stack.peek() == '(' && substr.charAt(i) == ')'){
    //                 stack.pop();
    //             }
    //             else{
    //                 stack.push(substr.charAt(i));
    //             }
    //         }
    //     }
    //     return stack.isEmpty();
    // }
}
