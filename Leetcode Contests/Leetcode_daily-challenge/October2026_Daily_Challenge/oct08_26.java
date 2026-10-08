public class oct08_26 {
    public static String removeOuterParentheses(String s) {
        int n = s.length();
        int open = 0;
        int close = 0;
        StringBuilder res = new StringBuilder();
        int start = 0;
        for(int i = 0 ; i < n ; i++){
            if(s.charAt(i) == '('){
                open++;
            }
            else{
                close++;
            }
            if(open == close){
                res.append(s.substring(start + 1, i));
                start = i + 1;
            }
        }
        return res.toString();
    }
    public static void main(String[] args) {
        String s = "(()())(())";
        System.out.println(removeOuterParentheses(s));
    }
}
