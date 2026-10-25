public class oct25_26 {
    static int n, m;
    public static int closedIsland(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        int count = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(grid[i][j] == 0){
                    if(dfs(grid, i, j)){
                        count++;
                    }
                }
            }
        }
        return count;
    }
    public static boolean dfs(int[][] grid, int r, int c){
        if(r >= n || r < 0 || c >= m || c < 0){
            return false;
        }
        if(grid[r][c] == 1){
            return true;
        }
        grid[r][c] = 1;
        boolean left_closed = dfs(grid, r, c - 1);
        boolean right_closed = dfs(grid, r, c + 1);
        boolean up_closed = dfs(grid, r - 1, c);
        boolean down_closed = dfs(grid, r + 1, c);
        return (left_closed) && (right_closed) && (up_closed) && (down_closed);
    }
    public static void main(String[] args) {
        int[][] grid = {{1,1,1,1,1,1,1,0},{1,0,0,0,0,1,1,0},{1,0,1,0,1,1,1,0},{1,0,0,0,0,1,0,1},{1,1,1,1,1,1,1,0}};
        System.out.println(closedIsland(grid));
    }
}
