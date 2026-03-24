public class mar24_26 {
    public static int[][] constructProductMatrix(int[][] grid) {
        int MOD = 12345;
        int n = grid.length;
        int m = grid[0].length;
        int[][] p = new int[n][m];
        long suffix = 1;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                p[i][j] = (int) suffix;
                suffix = (suffix * grid[i][j]) % MOD;
            }
        }
        long prefix = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                p[i][j] = (int) ((prefix * p[i][j]) % MOD);
                prefix = (prefix * grid[i][j]) % MOD;
            }
        }
        return p;
    }
    public static void main(String[] args) {
        int[][] grid = {{1,2},{3,4}};
        int[][] res = constructProductMatrix(grid);
        for(int i = 0 ; i < res.length ; i++){
            for(int j = 0 ; j < res[0].length ; j++){
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
    }
}
