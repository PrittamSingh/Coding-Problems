public class nov23_25 {
    // public static int maxSumDivThree(int[] nums) {
    //     int n = nums.length;
    //     int[][] dp = new int[n][3];
    //     for(int a = 0 ; a < n ; a++){
    //         for(int b = 0 ; b < 3 ; b++){
    //             dp[a][b] = -1;
    //         }
    //     }
    //     return solve(0, 0, nums, dp);
    // }
    // public int solve(int i, int sum, int[] nums, int[][] dp){
    //     int n = nums.length;
    //     if(i == n){
    //         return (sum == 0) ? 0 : (int)-1e9;
    //     }
    //     if(dp[i][sum] != -1){
    //         return dp[i][sum];
    //     }
    //     int pick = nums[i] + solve(i + 1, (sum + nums[i]) % 3, nums, dp);
    //     int skip = solve(i + 1, sum, nums, dp);
    //     return dp[i][sum] = Math.max(skip, pick);
    // }
    public static int maxSumDivThree(int[] nums) {
        int sum = 0;
        int min1 = Integer.MAX_VALUE, secondMin1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE, secondMin2 = Integer.MAX_VALUE;
        for(int num : nums){
            sum += num;
            int r = num % 3;
            if(r == 1){
                if(num < min1){
                    secondMin1 = min1;
                    min1 = num;
                }
                else if(num < secondMin1){
                    secondMin1 = num;
                }
            }
            else if(r == 2){
                if(num < min2){
                    secondMin2 = min2;
                    min2 = num;
                }
                else if(num < secondMin2){
                    secondMin2 = num;
                }
            }
        }
        if(sum % 3 == 0) return sum;
        int remainder = sum % 3;
        int result = 0;
        if(remainder == 1){
            int option1 = (min1 == Integer.MAX_VALUE) ? 0 : sum - min1;
            int option2 = (min2 == Integer.MAX_VALUE || secondMin2 == Integer.MAX_VALUE) ? 0 : sum - min2 - secondMin2;
            result = Math.max(option1, option2);
        }
        else{
            int option1 = (min2 == Integer.MAX_VALUE) ? 0 : sum - min2;
            int option2 = (min1 == Integer.MAX_VALUE || secondMin1 == Integer.MAX_VALUE) ? 0 : sum - min1 - secondMin1;
            result = Math.max(option1 , option2);
        }
        return result;
    }
    public static void main(String[] args) {
        int[] nums = {3,6,5,1,8}, nums2 = {4} , nums3 = {1,2,3,4,4};
        System.out.println(maxSumDivThree(nums) + " " + maxSumDivThree(nums2) + " " + maxSumDivThree(nums3));
    }
}
