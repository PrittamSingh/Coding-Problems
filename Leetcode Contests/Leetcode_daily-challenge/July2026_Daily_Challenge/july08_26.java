import java.util.Arrays;

public class july08_26 {
    static int MOD = 1000000007;
    public static int[] sumAndMultiply(String s, int[][] queries) {
        int n = s.length();
        long[] digitSum = new long[n];
        digitSum[0] = s.charAt(0) - '0';
        for(int i = 1 ; i < n ; i++){
            digitSum[i] = digitSum[i - 1] + s.charAt(i) - '0';
        }
        long[] numberUpto = new long[n];
        numberUpto[0] = s.charAt(0) - '0';
        for(int i = 1 ; i < n ; i++){
            if(s.charAt(i) - '0' != 0){
                numberUpto[i] = (numberUpto[i - 1] * 10 + (s.charAt(i) - '0')) % MOD;
            }
            else{
                numberUpto[i] = numberUpto[i - 1];
            }
        }
        int[] nonZeroDigit = new int[n];
        nonZeroDigit[0] = (s.charAt(0) - '0' == 0) ? 0 : 1;
        for(int i = 1 ; i < n ; i++){
            nonZeroDigit[i] = nonZeroDigit[i - 1] + ((s.charAt(i) - '0' == 0) ? 0 : 1);
        }
        long[] pow10 = new long[n + 1];
        pow10[0] = 1;
        for(int i = 1 ; i <= n ; i++){
            pow10[i] = (pow10[i - 1] * 10) % MOD;
        }
        int[] ans = new int[queries.length];
        for(int i = 0 ; i < queries.length ; i++){
            int[] query = queries[i];
            int l = query[0];
            int r = query[1];
            int k = nonZeroDigit[r] - (l == 0 ? 0 : nonZeroDigit[l - 1]);
            long x = (numberUpto[r] - (l == 0 ? 0 : (numberUpto[l - 1] * pow10[k]) % MOD) + MOD) % MOD;
            long sum = digitSum[r] - (l == 0 ? 0 : digitSum[l - 1]);
            ans[i] = (int)((x * sum) % MOD);
        }
        return ans;
    }
    public static void main(String[] args) {
        String s = "10203004";
        int[][] queries = {{0,7},{1,3},{4,6}};
        System.out.println(Arrays.toString(sumAndMultiply(s, queries)));
    }
}
