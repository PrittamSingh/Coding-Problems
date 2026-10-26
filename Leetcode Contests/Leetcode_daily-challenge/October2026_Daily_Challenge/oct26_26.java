public class oct26_26 {
    static int n, m;
    public static int countIslands(int[][] grid, int k) {
        n = grid.length;
        m = grid[0].length;
        int ans = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(grid[i][j] != 0){
                    long sum = dfs(grid, i, j);
                    if(sum % k == 0){
                        ans++;
                    }
                }
            }
        }
        return ans;
    }
    public static long dfs(int[][] grid, int i, int j){
        if(i >= n || i < 0 || j >= m || j < 0){
            return 0;
        }
        if(grid[i][j] == 0){
            return 0;
        }
        long sum = grid[i][j];
        grid[i][j] = 0;
        sum += dfs(grid, i, j - 1);
        sum += dfs(grid, i, j + 1);
        sum += dfs(grid, i + 1, j);
        sum += dfs(grid, i - 1, j);
        return sum;
    }
    public static void main(String[] args) {
        int[][] grid = {{0,2,1,0,0},{0,5,0,0,5},{0,0,1,0,0},{0,1,4,7,0},{0,2,0,0,8}};
        int k = 5;
        System.out.println(countIslands(grid, k));
    }
}
