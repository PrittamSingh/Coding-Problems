public class dec30_25 {
    public static int numMagicSquaresInside(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        if(n < 3 || m < 3){
            return 0;
        }
        int count = 0;
        for(int i = 0 ; i <= n - 3; i++){
            for(int j = 0 ; j <= m - 3 ; j++){
                if(checkMagic(grid, i, j)){
                    count++;
                }
            }
        }
        return count;
    }
    public static boolean checkMagic(int[][] grid, int row, int col){

        //Distinction of the numbers checking
        boolean[] check = new boolean[10];
        for(int i = row ; i < row + 3 ; i++){
            for(int j = col ; j < col + 3 ; j++){
                int num = grid[i][j];
                if(num < 1 || num > 9 || check[num]){
                    return false;
                } 
                check[num] = true;
            }
        }

        //Equal row, column, diagonal sum checking
        int sum = grid[row][col] + grid[row][col + 1] + grid[row][col + 2];
        for(int p = 0 ; p < 3 ; p++){
            if(grid[row + p][col] + grid[row + p][col + 1] + grid[row + p][col + 2] != sum){
                return false;
            }
            if(grid[row][col + p] + grid[row + 1][col + p] + grid[row + 2][col + p] != sum){
                return false;
            }
        }
        if(grid[row][col] + grid[row + 1][col + 1] + grid[row + 2][col + 2] != sum){
            return false;
        }
        if(grid[row][col + 2] + grid[row + 1][col + 1] + grid[row + 2][col] != sum){
            return false;
        }
        return true;
    }
    public static void main(String[] args) {
        int[][] grid = {{4,3,8,4},{9,5,1,9},{2,7,6,2}};
        int[][] grid2 = {{8}};
        System.out.println(numMagicSquaresInside(grid) +" " + numMagicSquaresInside(grid2));
    }
}
