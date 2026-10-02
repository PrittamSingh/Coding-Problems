import java.util.*;
public class oct02_26 {
    public static List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        backtrack(ans, "", 0, 0, n);
        return ans;
    }
    public static void backtrack(List<String> ans, String sb, int open, int close, int n){
        //base case
        if(sb.length() == n * 2){
            ans.add(sb);
            return;
        }
        if(open < n){
            backtrack(ans, sb + "(", open + 1, close, n);
        }
        if(close < open){
            backtrack(ans, sb + ")", open, close + 1, n);
        }
    }
    public static void main(String[] args) {
        int n = 3;
        List<String> ans = generateParenthesis(n);
        for(int i = 0 ; i < ans.size() ; i++){
            System.out.print(ans.get(i) + " ");
        }
    }
}
