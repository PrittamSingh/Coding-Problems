import java.util.ArrayList;
import java.util.List;

public class july20_26 {
    public static List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        while(k-- > 0){
            int prev = grid[0][0];
            for(int i = 0 ; i < m ; i++){
                for(int j = 0 ; j < n ; j++){
                    if(j == n - 1 && i != m - 1){
                        int temp = grid[i + 1][0];
                        grid[i + 1][0] = prev;
                        prev = temp;
                    }
                    else if(i == m - 1 && j == n - 1){
                        grid[0][0] = prev;
                    }
                    else{
                        int temp = grid[i][j + 1];
                        grid[i][j + 1] = prev;
                        prev = temp;
                    }
                }
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0 ; i < m ; i++){
            ans.add(new ArrayList<>());
        }
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                ans.get(i).add(grid[i][j]);
                System.out.print(ans.get(i).get(j) + " ");
            }
            System.out.println();
        }
        return ans;
    }
    public static void main(String[] args) {
        int[][] grid = {{1,2,3},{4,5,6},{7,8,9}};
        int k = 1;
        shiftGrid(grid, k);
    }
}
