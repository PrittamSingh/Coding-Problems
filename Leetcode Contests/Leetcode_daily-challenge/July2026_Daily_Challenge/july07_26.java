public class july07_26 {
    public static long sumAndMultiply(int n) {
        StringBuilder sb = new StringBuilder();
        while(n > 0){
            int d = n % 10;
            if(d > 0){
                sb.append(d);
            }
            n /= 10;
        }
        int sum = 0;
        for(int i = 0 ; i < sb.length() ; i++){
            sum += sb.charAt(i) - '0';
        }
        if(sb.toString() == ""){
            return 0;
        }
        int x = Integer.valueOf(sb.reverse().toString());
        long ans = (long)x * sum;
        return ans;
    }
    public static void main(String[] args) {
        int n = 10203004;
        System.out.println(sumAndMultiply(n));
    }
}
