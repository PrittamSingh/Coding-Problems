public class dec28_25 {
    // Approach-1 O(n^2)
    // public static int countNegatives(int[][] grid) {
        // int m = grid.length;
        // int n = grid[0].length;
        // int count = 0;
        // for(int i = 0 ; i < m ; i++){
        //     for(int j = 0 ; j < n ; j++){
        //         if(grid[i][j] < 0){
        //             count++;
        //         }
        //     }
        // }
        // return count;
    // }


    // Approach-2 O(nlog m)
    // public static int countNegatives(int[][] grid) {
    //     int m = grid.length;
    //     int n = grid[0].length;
    //     int count = 0;
    //     for(int[] g : grid){
    //         int idx = search(g, n);
    //         if(idx == n){
    //             continue;
    //         }
    //         count += (n - idx);
    //     }
    //     return count;
    // }
    // public static int search(int[] arr, int m){
    //     int low = 0;
    //     int high = m - 1;
    //     int ans = m;
    //     while(low <= high){
    //         int mid = (low + high) / 2;
    //         if(arr[mid] < 0){
    //             ans = mid;
    //             high = mid - 1;
    //         }
    //         else{
    //             low = mid + 1;
    //         }
    //     }
    //     return ans;
    // }

    // Approach-3 O(n + m)
    public static int countNegatives(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        int row = 0;
        int col = n - 1;
        while(row < m && col >= 0){
            if(grid[row][col] < 0){
                count += (m - row);
                col--;
            }
            else{
                row++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int[][] grid = {{4,3,2,-1},{3,2,1,-1},{1,1,-1,-2},{-1,-1,-2,-3}};
        System.out.println(countNegatives(grid));
    }
}
