import java.util.Stack;

public class july19_26 {
    public static String smallestSubsequence(String s) {
        int[] lastIdx = new int[26];
        boolean[] taken = new boolean[26];
        for(int i = 0 ; i < s.length() ; i++){
            lastIdx[s.charAt(i) - 'a'] = i;
        }
        Stack<Character> stack = new Stack<>();
        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);
            if(taken[ch - 'a']) continue;
            while(!stack.isEmpty() && stack.peek() > ch && lastIdx[stack.peek() - 'a'] > i){
                taken[stack.peek() - 'a'] = false;
                stack.pop();
            }
            stack.push(ch);
            taken[ch - 'a'] = true;
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            char ch = stack.pop();
            sb.append(ch);
        }
        return sb.reverse().toString();
    }
    public static void main(String[] args) {
        String s = "bcabc";
        System.out.println(smallestSubsequence(s));
    }
}
