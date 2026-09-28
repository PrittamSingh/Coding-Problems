public class sept28_26 {
    public static int maxDepth(String s) {
        int ans = 0;
        int count = 0;
        for(int i = 0 ; i < s.length() ; i++){
            if(s.charAt(i) == '('){
                count++;
            }
            else if(s.charAt(i) == ')'){
                count--;
            }
            ans = Math.max(ans, count);
        }
        return ans;
    }
    public static void main(String[] args) {
        String s = "(1+(2*3)+((8)/4))+1";
        System.out.println(maxDepth(s));
    }
}
