import java.util.Arrays;

public class nov10_26 {
    // int[] t;
    // public int climbStairs(int n, int[] costs) {
    //     t = new int[n + 1];
    //     Arrays.fill(t, -1);
    //     return solve(n, costs, 0);
    // }
    // public int solve(int n, int[] costs, int idx){
    //     if(idx == n){
    //         return 0;
    //     }
    //     if(t[idx] != -1){
    //         return t[idx];
    //     }
    //     int cost = 0;
    //     int j = idx + 1;
    //     if(j <= n){
    //         cost = costs[j - 1] + ((j - idx) * (j - idx)) + solve(n, costs, idx + 1);
    //     }
    //     j = idx + 2;
    //     if(j <= n){
    //         cost = Math.min(cost, costs[j - 1] + ((j - idx) * (j - idx)) + solve(n, costs, idx + 2));
    //     }
    //     j = idx + 3;
    //     if(j <= n){
    //         cost = Math.min(cost, costs[j - 1] + ((j - idx) * (j - idx)) + solve(n, costs, idx + 3));
    //     }
    //     return t[idx] = cost;
    // }



    //BOTTOM UP
    public static int climbStairs(int n, int[] costs) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 0);
        for(int i = n - 1 ; i >= 0 ; i--){
            int j = i + 1;
            int cost = costs[j - 1] + ((j - i) * (j - i)) + dp[j];
            j = i + 2;
            if(j <= n){
                cost = Math.min(cost, costs[j - 1] + ((j - i) * (j - i)) + dp[j]);
            }
            j = i + 3;
            if(j <= n){
                cost = Math.min(cost, costs[j - 1] + ((j - i) * (j - i)) + dp[j]);
            }
            dp[i] = cost;
        }
        return dp[0];
    }
    public static void main(String[] args) {
        int n = 4;
        int[] costs = {1,2,3,4};
        System.out.println(climbStairs(n, costs));
    }
}
