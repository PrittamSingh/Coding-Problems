import java.util.TreeSet;

public class mar20_26 {
    public static int[][] minAbsDiff(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] result = new int[m - k + 1][n - k + 1];
        for (int i = 0; i <= m - k; i++) {
            for (int j = 0; j <= n - k; j++) {
                TreeSet<Integer> vals = new TreeSet<>();
                for (int r = i; r <= i + k - 1; r++) {
                    for (int c = j; c <= j + k - 1; c++) {
                        vals.add(grid[r][c]);
                    }
                }
                if (vals.size() == 1) {
                    continue;
                }
                int minAbsDiff = Integer.MAX_VALUE;
                Integer prev = null;
                for (int val : vals) {
                    if (prev != null) {
                        minAbsDiff = Math.min(minAbsDiff, val - prev);
                    }
                    prev = val;
                }
                result[i][j] = minAbsDiff;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[][] grid = {{1,8},{3,-2}};
        int k = 2;
        int[][] res  = minAbsDiff(grid, k);
        for(int i = 0 ; i < res.length ; i++){
            for(int j = 0 ; j < res[0].length ; j++){
                System.err.print(res[i][j]);
            }
            System.out.println();
        }
    }
}
