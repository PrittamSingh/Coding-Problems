import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class may09_26 {
    public static int[][] rotateGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int layers = Math.min(m, n) / 2;
        for(int layer = 0 ; layer < layers ; layer++){
            List<Integer> list = new ArrayList<>();
            int top = layer;
            int bottom = m - layer - 1;
            int left = layer;
            int right = n - layer - 1;
            for(int j = left ; j <= right ; j++){
                list.add(grid[top][j]);
            }
            for(int i = top + 1 ; i <= bottom - 1 ; i++){
                list.add(grid[i][right]);
            }
            for(int j = right ; j >= left ; j--){
                list.add(grid[bottom][j]);
            }
            for(int i = bottom - 1 ; i >= top + 1 ; i--){
                list.add(grid[i][left]);
            }
            int len = list.size();
            int normalizedK = k % len;
            Collections.rotate(list, -normalizedK);
            int idx = 0;
            for(int j = left ; j <= right ; j++){
                grid[top][j] = list.get(idx);
                idx++;
            }
            for(int i = top + 1 ; i <= bottom - 1 ; i++){
                grid[i][right] = list.get(idx);
                idx++;
            }
            for(int j = right ; j >= left ; j--){
                grid[bottom][j] = list.get(idx);
                idx++;
            }
            for(int i = bottom - 1 ; i >= top + 1 ; i--){
                grid[i][left] = list.get(idx);
                idx++;
            }
        }
        return grid;
    }
    public static void main(String[] args) {
        int[][] grid = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        int k = 2;
        int[][] ans = rotateGrid(grid, k);
        for(int i = 0 ; i < ans.length ; i++){
            for(int j = 0 ; j < ans[0].length ; j++){
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }
}
