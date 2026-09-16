public class sept16_26 {
    // int MOD = 1000000007;
    // int[][] t;
    // public int numberOfSets(int n, int k) {
    //     /*
    //         1 2 3 4 5 6 7 8
    //         at any idx i -
    //         Options - 
    //         1. start from idx i
    //         2.skip and move to next point i + 1
    //         Recursion
    //         solve(n, k, 0(idx));
    //         int solve(int n, int k, int i){
    //             if(k == 0) return 1; //found 1 way 
    //             if(i >= n) return 0; //out of bound
    //             skip = solve(n, k, i + 1);
    //             // take - start a segment from this ith point
    //             for(int j = i + 1 ; j <= n - 1 ; j++){ //possible ending points
    //                 take += solve(n, k - 1, j);
    //             }
    //             return skip + take;
    //         }


    //         Memoization
    //         t[1001][1001];
    //     */ 

    //     t = new int[1001][1001];
    //     for(int[] arr : t){
    //         Arrays.fill(arr, -1);
    //     }
    //     return solve(n, k, 0) % MOD;
    // }
    // public int solve(int n, int k, int idx){
    //     if(k == 0) return 1;
    //     if(idx >= n) return 0;
    //     if(t[k][idx] != -1){
    //         return t[k][idx];
    //     }
    //     int take = 0;
    //     for(int j = idx + 1 ; j <= n - 1 ; j++){
    //         take = (take + solve(n, k - 1, j)) % MOD;
    //     }
    //     int skip = solve(n, k, idx + 1) % MOD;
    //     return t[k][idx] = (take + skip) % MOD;
    // }


    //BOTTOM UP
    //T.C -> O(N^2 * k)
    // int MOD = 1000000007;
    // public int numberOfSets(int n, int k) {
    //     int[][] dp = new int[k + 1][n + 1];
    //     for(int i = 0 ; i < n ; i++){
    //         dp[0][i] = 1;
    //     }
    //     for(int i = 1 ; i <= k ; i++){
    //         for(int j = n - 1 ; j >= 0 ; j--){
    //             int skip = dp[i][j + 1] % MOD;
    //             int take = 0;
    //             for(int m = j + 1 ; m <= n - 1 ; m++){
    //                 take = (take + dp[i - 1][m]) % MOD;
    //             }
    //             dp[i][j] = (take + skip) % MOD;
    //         }
    //     }
    //     return dp[k][0];
    // }



    //BOTTOM UP WITH SPACE OPTIMIZED
    //T.C -> O(N * K)
    static int MOD = 1000000007;
    public static int numberOfSets(int n, int k) {
        int[][] dp = new int[k + 1][n + 1];
        for(int i = 0 ; i < n ; i++){
            dp[0][i] = 1;
        }
        for(int i = 1 ; i <= k ; i++){
            int[] prevRowSum = new int[n + 1];
            for(int x = n - 1 ; x >= 0 ; x--){
                prevRowSum[x] = (prevRowSum[x + 1] + dp[i - 1][x]) % MOD;
            }
            for(int j = n - 1 ; j >= 0 ; j--){
                int skip = dp[i][j + 1] % MOD;
                int take = prevRowSum[j + 1];
                dp[i][j] = (take + skip) % MOD;
            }
        }
        return dp[k][0];
    }
    public static void main(String[] args) {
        int n = 30, k = 7;
        System.out.println(numberOfSets(n, k));
    }
}
