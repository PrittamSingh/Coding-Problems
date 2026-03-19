public class mar19_26 {
    public static int numberOfSubmatrices(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;
        //3D array
        // int[][][] prefix = new int[n + 1][m + 1][2];
        // for(int i = 1 ; i <= n ; i++){
        //     for(int j = 1 ; j <= m ; j++){
        //         prefix[i][j][0] = prefix[i - 1][j][0] + prefix[i][j - 1][0] - prefix[i - 1][j - 1][0] + (grid[i - 1][j - 1] == 'X' ? 1 : 0);
        //         prefix[i][j][1] = prefix[i - 1][j][1] + prefix[i][j - 1][1] - prefix[i - 1][j - 1][1] + (grid[i - 1][j - 1] == 'Y' ? 1 : 0);
        //         if(prefix[i][j][0] > 0 && prefix[i][j][0] == prefix[i][j][1]){
        //             count++;
        //         }
        //     }
        // }
        // 2 - 2D array
        int[][] prefixX = new int[n + 1][m + 1];
        int[][] prefixY = new int[n + 1][m + 1];
        for(int i = 1 ; i <= n ; i++){
            for(int j = 1 ; j <= m ; j++){
                prefixX[i][j] = prefixX[i - 1][j] + prefixX[i][j - 1] - prefixX[i - 1][j - 1];
                prefixY[i][j] = prefixY[i - 1][j] + prefixY[i][j - 1] - prefixY[i - 1][j - 1];
                if(grid[i - 1][j - 1] == 'X'){
                    prefixX[i][j]++;
                }
                if(grid[i - 1][j - 1] == 'Y'){
                    prefixY[i][j]++;
                }
            }
        }
        for(int i = 1 ; i <= n ; i++){
            for(int j = 1 ; j <= m ; j++){
                int countX = prefixX[i][j];
                int countY = prefixY[i][j];
                if(countX > 0 && countX == countY){
                    count++;
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {
        char[][] grid = {{'X','Y','.'},{'Y','.','.'}};
        System.out.println(numberOfSubmatrices(grid));
    }
}
