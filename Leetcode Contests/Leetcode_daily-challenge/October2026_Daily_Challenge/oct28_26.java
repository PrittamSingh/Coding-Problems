import java.util.Arrays;

public class oct28_26 {
    static int n, m;
    static int[][][] t;
    static int ans = Integer.MAX_VALUE;
    public static int minCost(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        t = new int[n + 1][m + 1][10001];
        for(int[][] a : t){
            for(int[] b : a){
                Arrays.fill(b, -1);
            }
        }
        solve(grid, 0, 0, grid[0][0]);
        return ans;
    }
    public static int solve(int[][] grid, int i, int j, int xor){
        if(i == n - 1 && j == m - 1){
            ans = Math.min(ans, xor);
            return t[i][j][xor] = Math.min(ans, xor);
        }
        if(t[i][j][xor] != -1){
            return t[i][j][xor];
        }
        int right = Integer.MAX_VALUE;
        int down = Integer.MAX_VALUE;
        if(j + 1 < m){
            right = solve(grid, i, j + 1, xor ^ grid[i][j + 1]);
        }
        if(i + 1 < n){
            down = solve(grid, i + 1, j, xor ^ grid[i + 1][j]);
        }
        return t[i][j][xor] = Math.min(right, down);
    }
    public static void main(String[] args) {
        int[][] grid = {{6,7},{5,8}};
        System.out.println(minCost(grid));
    }
}
