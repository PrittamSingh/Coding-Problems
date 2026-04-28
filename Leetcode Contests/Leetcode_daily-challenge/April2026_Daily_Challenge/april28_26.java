import java.util.Arrays;

public class april28_26 {
    public static int minOperations(int[][] grid, int x) {
        int m = grid.length;
        int n = grid[0].length;
        int[] arr = new int[m * n];
        int k = 0;
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                arr[k] = grid[i][j];
                k++;
            }
        }
        int mod = arr[0] % x;
        for(int num : arr){
            if(num % x != mod){
                return -1;
            }
        }
        Arrays.sort(arr);
        int mid = arr[(m * n) / 2];
        int operations = 0;
        for(int num : arr){
            operations += Math.abs(num - mid);
        }
        return operations / x;
    }
    public static void main(String[] args) {
        int[][] grid = {{2,4},{6,8}};
        int x = 2;
        System.out.println(minOperations(grid, x));
    }
}
