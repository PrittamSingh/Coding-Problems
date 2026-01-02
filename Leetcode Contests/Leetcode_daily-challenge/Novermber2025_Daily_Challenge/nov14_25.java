public class nov14_25 {

    //BRUTE FORCE APPROACH (TLE ho skta hai)
    // public static int[][] rangeAddQueries(int n, int[][] queries){
    //     int[][] mat = new int[n][n];
    //     for(int[] q : queries){
    //         int r1 = q[0], c1 = q[1], r2 = q[2], c2 = q[3];
    //         for(int i = r1 ; i <= r2 ; i++){
    //             for(int j = c1 ; j <= c2 ; j++){
    //                 mat[i][j]++;
    //             }
    //         } 
    //     }
    //     return mat;
    // }

    //OPTIMAL SOLUTION (USING PREFIX SUM IN 2D AND DIFFERENCE ARRAY IN 2D)
    public static int[][] rangeAddQueries(int n, int[][] queries){
        int[][] diff = new int[n + 1][n + 1];
        for(int[] q : queries){
            int r1 = q[0] , c1 = q[1] , r2 = q[2] , c2 = q[3];
            diff[r1][c1] += 1;
            diff[r1][c2 + 1] -= 1;
            diff[r2 + 1][c1] -= 1;
            diff[r2 + 1][c2 + 1] += 1;
        }
        for(int i = 0 ; i < n ; i++){
            for(int j = 1; j < n ; j++){
                diff[i][j] += diff[i][j - 1];
            }
        }
        for(int j = 0 ; j < n ; j++){
            for(int i = 1; i < n ; i++){
                diff[i][j] += diff[i - 1][j];
            }
        }
        int[][] result = new int[n][n];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                result[i][j] = diff[i][j];
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int n = 3;
        int[][] queries = {{1,1,2,2},{0,0,1,1}};
        int[][] ans = rangeAddQueries(n, queries);
        for(int[] row : ans){
            for(int value : row){
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}
