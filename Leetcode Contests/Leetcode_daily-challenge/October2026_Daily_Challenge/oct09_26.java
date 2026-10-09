public class oct09_26 {
    public static int minInsertions(String s) {
        int n = s.length();
        int i = 0;
        int count = 0;
        int res = 0;
        while(i < n){
            if(s.charAt(i) == '('){
                count++;
                i++;
            }
            else if(s.charAt(i) == ')'){
                if(i < n - 1 && s.charAt(i + 1) == ')'){
                    count--;
                    i += 2;
                }
                else{
                    res += 1;
                    count--;
                    i++;
                }
            }
            if(count < 0){
                res++;
                count++;
            }
        }
        if(count > 0){
            res += 2 * (count);
        }
        return res;
    }
    public static void main(String[] args) {
        String s = "))())(";
        System.out.println(minInsertions(s));
    }
}
