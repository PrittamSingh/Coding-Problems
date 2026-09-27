import java.util.Stack;

public class sept27_26 {
    public static String reverseParentheses(String s) {
        int n = s.length();
        Stack<Integer> openBracket = new Stack<>();
        int[] door = new int[n];
        for(int i = 0 ; i < n ; i++){
            if(s.charAt(i) == '('){
                openBracket.push(i);
            }
            else if(s.charAt(i) == ')'){
                int j = openBracket.pop();
                door[i] = j;
                door[j] = i;
            }
        }
        StringBuilder res = new StringBuilder();
        int direction = 1;
        for(int i = 0 ; i < n ; i += direction){
            if(s.charAt(i) == '(' || s.charAt(i) == ')'){
                i = door[i];
                direction = -direction;
            }
            else{
                res.append(s.charAt(i));
            }
        }
        return res.toString();
    }




    // public String reverseParentheses(String s) {
    //     Stack<Integer> openBracket = new Stack<>();
    //     StringBuilder result = new StringBuilder();
    //     for(char ch : s.toCharArray()){
    //         if(ch == '('){
    //             openBracket.push(result.length());
    //         }
    //         else if(ch == ')'){
    //             int start = openBracket.pop();
    //             reverse(result, start, result.length() - 1);
    //         }
    //         else{
    //             result.append(ch);
    //         }
    //     }
    //     return result.toString();
    // }
    // public void reverse(StringBuilder sb, int start, int end){
    //     while(start < end){
    //         char temp = sb.charAt(start);
    //         sb.setCharAt(start, sb.charAt(end));
    //         sb.setCharAt(end, temp);
    //         start++;
    //         end--;
    //     }
    // }


    public static void main(String[] args) {
        String s = "(ed(et(oc))el)";
        System.out.println(reverseParentheses(s));
    }
}
