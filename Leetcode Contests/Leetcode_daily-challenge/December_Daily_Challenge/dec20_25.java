public class dec20_25 {
    public static int minDeletionSize(String[] strs) {
        // int n = strs.length;
        // int m = strs[0].length();
        // char[][] grid = new char[n][m];
        // for(int i = 0 ; i < n ; i++){
        //     for(int j = 0 ; j < m ; j++){
        //         grid[i][j] = strs[i].charAt(j);
        //     }
        // }
        // int delCol = 0;
        // boolean flag = false;
        // for(int k = 0 ; k < m ; k++){
        //     for(int p = 0 ; p < n - 1 ; p++){
        //         if(grid[p][k] > grid[p + 1][k]){
        //             flag = true;
        //         }
        //     }
        //     if(flag){
        //         delCol++;
        //     }
        //     flag = false;
        // }
        // return delCol;


        int n = strs.length;
        int m = strs[0].length();
        int delCol = 0;
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n - 1 ; j++){
                if(strs[j].charAt(i) > strs[j + 1].charAt(i)){
                    delCol++;
                    break;
                }
            }
        }
        return delCol;
    }
    public static void main(String[] args) {
        String[] strs = {"cba","daf","ghi"};
        String[] strs2 = {"a","b"};
        String[] strs3 = {"zyx","wvu","tsr"};
        System.out.println(minDeletionSize(strs) + " " + minDeletionSize(strs2) + " " + minDeletionSize(strs3));
    }
}
