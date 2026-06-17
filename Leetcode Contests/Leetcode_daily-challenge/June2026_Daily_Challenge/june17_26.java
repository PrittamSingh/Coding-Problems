public class june17_26 {
    public static char processStr(String s, long k) {
        long len = 0;
        for(char ch : s.toCharArray()){
            if(ch >= 'a' && ch <= 'z'){
                len++;
            }
            else if(ch == '#'){
                len *= 2;
            }
            else if(ch == '*'){
                if(len > 0){
                    len--;
                }
            }
            else{
                continue;
            }
        }
        if(k >= len){
            return '.';
        }
        int n = s.length();
        for(int i = n - 1 ; i >= 0 ; i--){
            char ch = s.charAt(i);
            if(ch >= 'a' && ch <= 'z'){
                len--;
                if(len == k){
                    return ch;
                }
            }
            else if(ch == '#'){
                len = len / 2;
                if(k >= len){
                    k = k - len;
                }
            }
            else if(ch == '*'){
                len++;
            }
            else{
                k = len - k - 1;
            }
            if(k == len){
                return ch;
            }
        }
        return '.';
    }
    public static void main(String[] args) {
        String s = "a#b%*";
        long k = 1;
        System.out.println(processStr(s, k));
    }
}
