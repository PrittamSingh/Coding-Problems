import java.util.Arrays;

public class aug24_26 {
// Recursion + memoization
    // int n;
    // int[] t;
    // public int solve(int i, int[] prefixSum) {
    //     if(i == n-1){
    //         return prefixSum[n-1];
    //     }
    //     if(t[i] != -1){
    //         return t[i];
    //     }
    //     int take = prefixSum[i] - solve(i+1, prefixSum);
    //     int skip = solve(i+1, prefixSum);
    //     return t[i] = Math.max(take, skip);
    // }

    // public int stoneGameVIII(int[] stones) {
    //     n = stones.length;
    //     t = new int[100001];
    //     Arrays.fill(t, -1);
    //     int[] prefixSum = new int[n];
    //     prefixSum[0] = stones[0];
    //     for(int i = 1 ; i < n ; i++){
    //         prefixSum[i] = prefixSum[i-1] + stones[i];
    //     }
    //     return solve(1, prefixSum);
    // }



    // Bottom up
    public static int stoneGameVIII(int[] stones) {
        int n = stones.length;
        int[] prefixSum = new int[n];
        Arrays.fill(prefixSum, 0);
        prefixSum[0] = stones[0];
        for(int i = 1 ; i < n ; i++){
            prefixSum[i] = prefixSum[i - 1] + stones[i];
        }
        int[] dp = new int[n];
        dp[n - 1] = prefixSum[n - 1];
        for(int i = n - 2 ; i >= 1 ; i--){
            int take = prefixSum[i] - dp[i + 1];
            int skip = dp[i+1];
            dp[i] = Math.max(take, skip);
        }
        return dp[1];
    }
    public static void main(String[] args) {
        int[] stones = {-1,2,-3,4,-5};
        System.out.println(stoneGameVIII(stones));
    }
}
