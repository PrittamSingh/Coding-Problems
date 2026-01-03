import java.util.Arrays;

public class jan03_25 {
    //Approach - 1 Most Optimal Solution
    // int MOD = 1000000007;
    // public int numOfWays(int n) {
    //     if(n == 0) return 0;
    //     long two = 6;
    //     long three = 6;
    //     n--;
    //     while(n > 0){
    //         long nextTwo =(2 * three + 3 * two) % MOD;
    //         three = (2 * three + 2 * two) % MOD;
    //         two = nextTwo;
    //         n--;
    //     }
    //     return (int) (two + three) % MOD;
    // }

    //Approach-2 DP Approach
    static int MOD = 1000000007;
    public static int numOfWays(int n){
        int[][][][] dp = new int[n + 1][4][4][4];
        for(int[][][] l1 : dp){
            for(int[][] l2 : l1){
                for(int[] l3 : l2){
                    Arrays.fill(l3, -1);
                }
            }
        }
        return solve(0, n, -1, -1, -1, dp);
    }
    public static int solve(int i, int n, int prev1, int prev2, int prev3, int[][][][] dp){
        if(i == n) return 1;
        if(dp[i][prev1 + 1][prev2 + 1][prev3 + 1] != -1){
            return dp[i][prev1 + 1][prev2 + 1][prev3 + 1];
        }
        long ans = 0;
        for(int c1 = 0 ; c1 < 3 ; c1++){
            for(int c2 = 0 ; c2 < 3 ; c2++){
                for(int c3 = 0 ; c3 < 3 ; c3++){
                    if(c1 != c2 && c2 != c3 && c1 != prev1 && c2 != prev2 && c3 != prev3){
                        ans = (ans + solve(i + 1, n, c1, c2, c3, dp)) % MOD;
                    }
                }
            }
        }
        return dp[i][prev1 + 1][prev2 + 1][prev3 + 1] = (int) ans;
    }
    public static void main(String[] args) {
        int n = 1;
        int n2 = 5000;
        System.out.println(numOfWays(n) + " " + numOfWays(n2));
    }
}
