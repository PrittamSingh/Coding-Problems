public class april30_26 {
    public static int maxPathScore(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int[][][] dp = new int[m][n][k+1];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++) {
                for (int c=0; c<=k; c++){
                    dp[i][j][c] = -1;
                }
            }
        }
        dp[0][0][0] = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int c = 0; c <= k; c++) {
                    if (dp[i][j][c] == -1) continue;
                    if (i + 1 < m) {
                        int newCost = c + ((grid[i + 1][j] == 0) ? 0 : 1);
                        if (newCost <= k) {
                            int newScore = dp[i][j][c] + grid[i + 1][j];
                            dp[i + 1][j][newCost] = Math.max(dp[i + 1][j][newCost], newScore);
                        }
                    }
                    if (j + 1 < n) {
                        int newCost = c + ((grid[i][j + 1] == 0) ? 0 : 1);
                        if (newCost <= k) {
                            int newScore = dp[i][j][c] + grid[i][j + 1];
                            dp[i][j + 1][newCost] = Math.max(dp[i][j + 1][newCost], newScore);
                        }
                    }
                }
            }
        }
        int ans = -1;
        for (int c = 0; c <= k; c++) {
            ans = Math.max(ans, dp[m - 1][n - 1][c]);
        }
        return ans;
    }
    public static void main(String[] args) {
        int[][] grid = {{0, 1},{2, 0}};
        int k = 1;
        int[][] grid1 = {{0, 1},{1, 2}};
        int k1 = 1;
        System.out.println(maxPathScore(grid, k) + " " + maxPathScore(grid1, k1));
    }
}
