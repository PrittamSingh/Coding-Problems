public class mar04_26 {
    public static int numSpecial(int[][] mat) {
        // Approach-2 Better Approach O(m * n)
        int n = mat.length;
        int m = mat[0].length;
        int[] rowArr = new int[n];
        int[] colArr = new int[m];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(mat[i][j] == 1){
                    rowArr[i]++;
                    colArr[j]++;
                }
            }
        }
        int ans = 0;
        for(int row = 0 ; row < n ; row++){
            for(int col = 0 ; col < m ; col++){
                if(mat[row][col] != 1) continue;
                if(rowArr[row] == 1 && colArr[col] == 1){
                    ans++;
                }
            }
        }
        return ans;



        // Approach-1 Brute Force O(m*n * m+n)
        // int n = mat.length;
        // int m = mat[0].length;
        // int count = 0;
        // for(int i = 0 ; i < n ; i++){
        //     for(int j = 0 ; j < m ; j++){
        //         if(mat[i][j] == 1){
        //             boolean special = true;
        //             //CHECKING COLUMN FOR 1
        //             for(int k = 0 ; k < n ; k++){
        //                 if(i == k) continue;
        //                 if(mat[k][j] == 1){
        //                     special = false;
        //                     break;
        //                 }
        //             }
        //             if(special){ //ROW ME SARA ELEMENT ZERO HAI
        //                 //CHECKING ROWS FOR 1
        //                 for(int k = 0 ; k < m ; k++){
        //                     if(j == k) continue;
        //                     if(mat[i][k] == 1){
        //                         special = false;
        //                         break;
        //                     }
        //                 }
        //             }
        //             if(special) count++;
        //         }
        //     }
        // }
        // return count;
    }
    public static void main(String[] args) {
        int[][] mat = {{1,0,0},{0,0,1},{1,0,0}};
        int[][] mat2 = {{1,0,0},{0,1,0},{0,0,1}};
        System.out.println(numSpecial(mat) + " " + numSpecial(mat2));
    }
}
