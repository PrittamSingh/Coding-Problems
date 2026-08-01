public class aug01_26 {
    public static boolean predictTheWinner(int[] nums){
        int n = nums.length;
        int[][] dp = new int[n][n];
        for(int i = 0 ; i < n ; i++){
            dp[i][i] = nums[i];
        }
        for(int len = 2 ; len <= n ; len++){
            for(int i = 0 ; i + len - 1 < n ; i++){
                int j = i + len - 1;
                int left = nums[i] - dp[i + 1][j]; // differnece
                int right = nums[j] - dp[i][j - 1];
                dp[i][j] = Math.max(left, right);
            }
        }
        return dp[0][n - 1] >= 0;
    }



    // int[][] t = new int[21][21];
    // public boolean predictTheWinner(int[] nums){
    //     int n = nums.length;
    //     for(int[] row : t){
    //         Arrays.fill(row, -1);
    //     }
    //     return solve(nums, 0, n - 1) >= 0;
    // }
    // public int solve(int[] nums, int i, int j){
    //     if(i > j) return 0;
    //     if(i == j) return nums[i];
    //     if(t[i][j] != -1){
    //         return t[i][j];
    //     }
    //     int take_i = nums[i] - solve(nums, i + 1, j);
    //     int take_j = nums[j] - solve(nums, i, j - 1);
    //     return t[i][j] = Math.max(take_i, take_j);
    // }



    // int[][] t = new int[21][21];
    // public boolean predictTheWinner(int[] nums) {
    //     // T.C -> O(2 ^ n)
    //     int n = nums.length;
    //     for(int[] row : t){
    //         Arrays.fill(row, -1);
    //     }
    //     int total_score = 0;
    //     for(int i = 0 ; i < n ; i++){
    //         total_score += nums[i];
    //     }
    //     int player1_score = solve(0, n - 1, nums);
    //     int player2_score = total_score - player1_score;
    //     return player1_score >= player2_score;
    // }
    // public int solve(int i, int j, int[] nums){
    //     if(i > j){
    //         return 0;
    //     }
    //     if(i == j){
    //         return nums[i];
    //     }
    //     if(t[i][j] != -1){
    //         return t[i][j];
    //     }
    //     int take_i = nums[i] + Math.min(solve(i + 2, j, nums), solve(i + 1, j - 1, nums));
    //     int take_j = nums[j] + Math.min(solve(i + 1, j - 1, nums), solve(i, j - 2, nums));
    //     return t[i][j] = Math.max(take_i, take_j);
    // }




    // public boolean predictTheWinner(int[] nums) {
    //     int n = nums.length;
    //     return solve(nums, 0, n - 1, 0, 0, true); // true -> A AND false -> B
    // }
    // public boolean solve(int[] nums, int i, int j, int sumA, int sumB, boolean turnA){
    //     if(i > j){
    //         return sumA >= sumB;
    //     }
    //     if(i == j){
    //         if(turnA){
    //             sumA = sumA + nums[i];
    //         }
    //         else{
    //             sumB = sumB + nums[i];
    //         }
    //         return sumA >= sumB;
    //     }
    //     if(turnA){
    //         boolean left = solve(nums, i + 1, j, sumA + nums[i], sumB, false);
    //         boolean right = solve(nums, i, j - 1, sumA + nums[j], sumB, false);
    //         return left || right;
    //     }
    //     else{
    //         boolean left = solve(nums, i + 1, j, sumA, sumB + nums[i], true);
    //         boolean right = solve(nums, i, j - 1, sumA, sumB + nums[j], true);
    //         return left && right;
    //     }
    // }
    public static void main(String[] args) {
        int[] nums = {1,5,233,7};
        System.out.println(predictTheWinner(nums));
    }
}
