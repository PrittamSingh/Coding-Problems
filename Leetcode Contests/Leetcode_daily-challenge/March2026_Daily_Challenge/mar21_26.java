public class mar21_26 {
    public static int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        int row2 = x + k - 1;
        for(int row1 = x ; row1 < x + k ; row1++){
            if(row1 >= row2){
                break;
            }
            for(int col = y ; col < y + k ; col++){
                int temp = grid[row1][col];
                grid[row1][col] = grid[row2][col];
                grid[row2][col] = temp;
            }
            row2--;
        }
        return grid;
    }
    public static void main(String[] args) {
        int[][] grid = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        int x = 1, y = 0, k = 3;
        int[][] res = reverseSubmatrix(grid, x, y, k);
        for(int i = 0 ; i < res.length ; i++){
            for(int j = 0 ; j < res[0].length ; j++){
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
    }
}
