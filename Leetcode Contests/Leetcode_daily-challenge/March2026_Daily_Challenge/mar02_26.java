import java.util.Arrays;

public class mar02_26 {
    public static int minSwaps(int[][] grid) {
        int n = grid.length;
        int[] endZeros = new int[n];
        Arrays.fill(endZeros, 0);
        for(int i = 0 ; i < n ; i++){
            int j = n - 1;
            int count = 0;
            while(j >= 0 && grid[i][j] == 0){
                count++;
                j--;
            }
            endZeros[i] = count;
        }
        int minSteps = 0;
        for(int i = 0 ; i < n ; i++){
            int need = n - i - 1;
            int j = i;
            while(j < n && endZeros[j] < need){
                j++;
            }
            if(j == n){
                return -1;
            }
            minSteps += j - i;
            while(j > i){
                int temp = endZeros[j];
                endZeros[j] = endZeros[j - 1];
                endZeros[j - 1] = temp;
                j--;
            }
        }
        return minSteps;
    }
    public static void main(String[] args) {
        int[][] grid = {{0,0,1},{1,1,0},{1,0,0}};
        int[][] grid2 = {{0,1,1,0},{0,1,1,0},{0,1,1,0},{0,1,1,0}};
        System.out.println(minSwaps(grid) + " " + minSwaps(grid2));
    }
}
