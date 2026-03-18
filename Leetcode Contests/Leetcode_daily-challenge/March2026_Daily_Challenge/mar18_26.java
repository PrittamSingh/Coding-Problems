public class mar18_26 {
    public static int countSubmatrices(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(i > 0){
                    grid[i][j] += grid[i - 1][j];
                }
                if (j > 0) 
                  grid[i][j] += grid[i][j - 1];
                if (i > 0 && j > 0) 
                  grid[i][j] -= grid[i - 1][j - 1];

                if (grid[i][j] <= k) {
                    count++;
                } else {
                    break;
                }
            }
        }
        return count;







        //BRUTE FORCE
        // int n = grid.length;
        // int m = grid[0].length;
        // int count = 0;
        // for(int i = 0 ; i < n ; i++){
        //     for(int j = 0 ; j < m ; j++){
        //         int sum = 0;
        //         for(int n1 = 0 ; n1 <= i ; n1++){
        //             for(int m1 = 0 ; m1 <= j ; m1++){
        //                 sum += grid[n1][m1];
        //             }
        //         }
        //         if(sum <= k){
        //             count++;
        //         }
        //     }
        // }
        // return count;
    }
    public static void main(String[] args) {
        int[][] grid = {{7,6,3},{6,6,1}};
        int k = 18;
        System.out.println(countSubmatrices(grid, k));
    }
}
