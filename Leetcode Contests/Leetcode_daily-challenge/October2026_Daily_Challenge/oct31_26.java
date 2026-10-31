public class oct31_26 {
    // int LEFT = 0;
    // int UP = 1;
    // int MOD = 1_000_000_007;
    // int m;
    // int n;
    // int[][][] t;
    // public int uniquePaths(int[][] grid) {
    //     m = grid.length;
    //     n = grid[0].length;
    //     t = new int[m][n][2];
    //     for(int i = 0 ; i < m ; i++){
    //         for(int j = 0 ; j < n ; j++){
    //             t[i][j][0] = -1;
    //             t[i][j][1] = -1;
    //         }
    //     }
    //     return solve(grid, 0, 0, LEFT);
    // }
    // int solve(int[][] grid, int i, int j, int cameFrom) {
    //     if(i >= m || j >= n){
    //         return 0;
    //     }
    //     if(i == m - 1 && j == n - 1)
    //         return 1;
    //     if(t[i][j][cameFrom] != -1){
    //         return t[i][j][cameFrom];
    //     }
    //     if(grid[i][j] == 1){
    //         if(cameFrom == LEFT){
    //             return t[i][j][cameFrom] = solve(grid, i + 1, j, UP);
    //         }
    //         else{
    //             return t[i][j][cameFrom] = solve(grid, i, j + 1, LEFT);
    //         }
    //     }
    //     int totalPathsCount = 0;
    //     totalPathsCount = (totalPathsCount + solve(grid, i, j + 1, LEFT)) % MOD;
    //     totalPathsCount = (totalPathsCount + solve(grid, i + 1, j, UP)) % MOD;
    //     return t[i][j][cameFrom] = totalPathsCount;
    // }



    // int LEFT = 0;
    // int UP = 1;
    // int MOD = 1000000007;
    // int m, n;
    // public int uniquePaths(int[][] grid) {
    //     m = grid.length;
    //     n = grid[0].length;
    //     int[][][] t = new int[m][n][2];
    //     t[0][0][LEFT] = 1;
    //     for(int col = 1 ; col < n ; col++){
    //         t[0][col][LEFT] = 1;
    //         if(grid[0][col] == 1)
    //             break;
    //     }
    //     for(int row = 1 ; row < m ; row++){
    //         t[row][0][UP] = 1;
    //         if(grid[row][0] == 1)
    //             break;
    //     }
    //     for(int row = 1 ; row < m ; row++){
    //         for(int col = 1 ; col < n ; col++){
    //             if (grid[row][col - 1] == 1)
    //                 t[row][col][LEFT] = t[row][col - 1][UP];
    //             else
    //                 t[row][col][LEFT] = (t[row][col - 1][LEFT] + t[row][col - 1][UP]) % MOD;
    //             if (grid[row - 1][col] == 1)
    //                 t[row][col][UP] = t[row - 1][col][LEFT];
    //             else
    //                 t[row][col][UP] = (t[row - 1][col][LEFT] + t[row - 1][col][UP]) % MOD;
    //         }
    //     }
    //     return (t[m - 1][n - 1][LEFT] + t[m - 1][n - 1][UP]) % MOD;
    // }



    static int LEFT = 0;
    static int UP = 1;
    static int MOD = 1_000_000_007;
    static int m, n;
    public static int uniquePaths(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int[][][] t = new int[m + 1][n + 1][2];
        for(int row = m - 1 ; row >= 0 ; row--){
            for(int col = n - 1 ; col >= 0 ; col--){
                for(int cameFrom = 0 ; cameFrom < 2 ; cameFrom++){
                    if(row == m - 1 && col == n - 1){
                        t[row][col][cameFrom] = 1;
                        continue;
                    }
                    if(grid[row][col] == 1){
                        if(cameFrom == LEFT)
                            t[row][col][cameFrom] = t[row + 1][col][UP];
                        else
                            t[row][col][cameFrom] = t[row][col + 1][LEFT];
                        continue;
                    }
                    long total = 0;
                    total += t[row][col + 1][LEFT];
                    total += t[row + 1][col][UP];
                    t[row][col][cameFrom] = (int) (total % MOD);
                }
            }
        }
        return t[0][0][LEFT];
    }
    public static void main(String[] args) {
        int[][] grid = {{0,1,0},{0,0,1},{1,0,0}};
        System.out.println(uniquePaths(grid));
    }
}
