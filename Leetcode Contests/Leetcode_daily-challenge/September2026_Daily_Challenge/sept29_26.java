public class sept29_26 {
    // int n;
    // int m;
    // int[][][] t;
    // public boolean hasValidPath(char[][] grid) {
    //     n = grid.length;
    //     m = grid[0].length;
    //     if((m + n - 1) % 2 == 1){
    //         return false;
    //     }
    //     if(grid[0][0] == ')' || grid[n - 1][m - 1] == '('){
    //         return false;
    //     }
    //     t = new int[n + 1][m + 1][201];
    //     for(int[][] arr : t){
    //         for(int[] arr1 : arr){
    //             Arrays.fill(arr1, -1);
    //         }
    //     }
    //     return solve(grid, 0, 0, 0);
    // }
    // public boolean solve(char[][] grid, int i, int j, int openCount){
    //     openCount += (grid[i][j] == '(') ? 1 : -1;
    //     if(openCount < 0){
    //         return false;
    //     }
    //     if(t[i][j][openCount] != -1){
    //         return t[i][j][openCount] == 1;
    //     }
    //     if(i == n - 1 && j == m - 1){
    //         return openCount == 0;
    //     }
    //     if(i + 1 < n){
    //         if(solve(grid, i + 1, j, openCount)){
    //             t[i][j][openCount] = 1;
    //             return true;
    //         }
    //     }
    //     if(j + 1 < m){
    //         if(solve(grid, i, j + 1, openCount)){
    //             t[i][j][openCount] = 1;
    //             return true;
    //         }
    //     }
    //     t[i][j][openCount] = 0;
    //     return false;
    // }



    public static boolean hasValidPath(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        if((n + m - 1) % 2 == 1){
            return false;
        }
        if(grid[0][0] == ')' || grid[n - 1][m - 1] == '('){
            return false;
        }
        boolean[][][] dp = new boolean[n][m][201];
        for(int i = n - 1 ; i >= 0 ; i--){
            for(int j = m - 1 ; j >= 0 ; j--){
                for(int openCount = 0 ; openCount <= i + j + 1 ; openCount++){
                    if(i == n - 1 && j == m - 1){
                        dp[i][j][openCount] = (openCount == 0);
                        continue;
                    }
                    dp[i][j][openCount] = false;
                    if(i + 1 < n){
                        int newOpenCount = (grid[i + 1][j] == '(') ? openCount + 1 : openCount - 1;
                        if(newOpenCount >= 0 && dp[i + 1][j][newOpenCount]){
                            dp[i][j][openCount] = true;
                        }
                    }
                    if(j + 1 < m){
                        int newOpenCount = (grid[i][j + 1] == '(') ? openCount + 1 : openCount - 1;
                        if(newOpenCount >= 0 && dp[i][j + 1][newOpenCount]){
                            dp[i][j][openCount] = true;
                        }
                    }
                }
            }
        }
        return dp[0][0][1];
    }
    public static void main(String[] args) {
        char[][] grid = {{'(','(','('},{')','(',')'},{'(','(',')'},{'(','(',')'}};
        System.out.println(hasValidPath(grid));
    }
}
