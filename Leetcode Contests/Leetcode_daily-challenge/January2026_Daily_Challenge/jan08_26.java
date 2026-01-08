public class jan08_26 {
    // static Integer dp[][];
    // public static int maxDotProduct(int[] nums1, int[] nums2) {
    //     int n = nums1.length;
    //     int m = nums2.length;
    //     dp = new Integer[n][m];
    //     return solve(0, 0, nums1, nums2);
    // }
    // public static int solve(int i, int j, int[] nums1, int[] nums2){
    //     if(i >= nums1.length || j >= nums2.length) return Integer.MIN_VALUE;
    //     if(dp[i][j] != null) return dp[i][j];
    //     int product = nums1[i] * nums2[j];
    //     int include = product + Math.max(0, solve(i + 1, j + 1, nums1, nums2));
    //     int exclude1 = solve(i + 1, j, nums1, nums2);
    //     int exclude2 = solve(i, j + 1, nums1, nums2);
    //     return dp[i][j] = Math.max(include, Math.max(exclude1, exclude2));
    // }

    //Bottom-Up Approach
    public static int maxDotProduct(int[] nums1, int[] nums2){
        int n = nums1.length;
        int m = nums2.length;
        int[][] dp = new int[n][m];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                int product = nums1[i] * nums2[j];
                dp[i][j] = product;
                if(i > 0 && j > 0){
                    dp[i][j] = Math.max(dp[i][j], product + Math.max(0, dp[i - 1][j - 1]));
                }
                if(i > 0){
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);
                }
                if(j > 0){
                    dp[i][j] = Math.max(dp[i][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n - 1][m - 1];
    }
    public static void main(String[] args) {
        // int[] nums1 = {2,1,-2,5}, nums2 = {3,0,-6};
        int[] nums1 = {3,-2}, nums2 = {2,-6,7};
        System.out.println(maxDotProduct(nums1, nums2));
    }
}
