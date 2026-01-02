import java.util.Arrays;

public class nov26_25 {
    static final int MOD = 1000000007;
    public static int numberOfPaths(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        int[][][] dp = new int[n][m][k];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                Arrays.fill(dp[i][j], -1);
            }
        }
        return solve(0, 0, 0, grid, k, dp);
    }
    public static int solve(int i, int j, int sum, int[][] grid, int k, int[][][] dp){
        int n = grid.length;
        int m = grid[0].length;
        if(i == n-1 && j == m-1){
            sum = (sum + grid[i][j]) % k;
            return sum == 0 ? 1 : 0;
        }
        if(i >= n || j >= m){
            return 0;
        }
        if(dp[i][j][sum] != -1){
            return dp[i][j][sum];
        }
        int newSum = (sum + grid[i][j]) % k;
        int right = solve(i, j+1, newSum, grid, k, dp);
        int down = solve(i + 1, j, newSum, grid, k, dp);
        
        return dp[i][j][sum] = (right + down) % MOD;
    }
    public static void main(String[] args) {
        int[][] grid = {{5,2,4},{3,0,5},{0,7,2}};
        int[][] grid2 = {{0,0}};
        int[][] grid3 = {{7,3,4,9},{2,3,6,2},{2,3,7,0}};
        int k = 3;
        int k2 = 5;
        int k3 = 1;
        System.out.println(numberOfPaths(grid, k) + " " + numberOfPaths(grid2, k2) + " " + numberOfPaths(grid3, k3));
    }
}
