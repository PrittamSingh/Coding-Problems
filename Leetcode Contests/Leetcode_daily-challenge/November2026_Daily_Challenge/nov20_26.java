import java.util.Arrays;

public class nov20_26 {
    // int n;
    // int[][] memo;
    // public int maxSelectedElements(int[] nums) {
    //     n = nums.length;
    //     Arrays.sort(nums);
    //     memo = new int[n + 1][2];
    //     for(int[] row : memo){
    //         Arrays.fill(row, -1);
    //     }
    //     int result = 1;
    //     for(int i = 0 ; i < n ; i++){
    //         result = Math.max(result, Math.max(solve(i, 0, nums), solve(i, 1, nums)));
    //     }
    //     return result;
    // }
    // public int solve(int i, int inc, int[] nums) {
    //     if(memo[i][inc] != -1){
    //         return memo[i][inc];
    //     }
    //     int currVal = nums[i] + inc;
    //     int len = 1;
    //     int j = findMethod(nums, i + 1, currVal + 1);
    //     if(j != -1){
    //         len = Math.max(len, 1 + solve(j, 0, nums));
    //     }
    //     j = findMethod(nums, i + 1, currVal);
    //     if(j != -1){
    //         len = Math.max(len, 1 + solve(j, 1, nums));
    //     }
    //     return memo[i][inc] = len;
    // }
    // private int findMethod(int[] nums, int start, int target) {
    //     int lo = start, hi = n;
    //     while(lo < hi){
    //         int mid = lo + (hi - lo) / 2;
    //         if(nums[mid] < target){
    //             lo = mid + 1;
    //         }
    //         else{
    //             hi = mid;
    //         }
    //     }
    //     if(lo < n && nums[lo] == target){
    //         return lo;
    //     }
    //     return -1;
    // }



    // BOTTOM UP
    static int n;
    static int[][] dp;
    public static int maxSelectedElements(int[] nums) {
        n = nums.length;
        Arrays.sort(nums);
        dp = new int[n + 1][2];
        int result = 1;
        for(int i = n - 1 ; i >= 0 ; i--){
            for(int inc = 0 ; inc <= 1 ; inc++){
                int currVal = nums[i] + inc;
                int len = 1;
                int j = findMethod(nums, i + 1, currVal + 1);
                if(j != -1){
                    len = Math.max(len, 1 + dp[j][0]);
                }
                j = findMethod(nums, i + 1, currVal);
                if(j != -1){
                    len = Math.max(len, 1 + dp[j][1]);
                }
                dp[i][inc] = len;
                result = Math.max(result, len);
            }
        }
        return result;
    }
    private static int findMethod(int[] nums, int start, int target) {
        int lo = start, hi = n;
        while(lo < hi){
            int mid = lo + (hi - lo) / 2;
            if(nums[mid] < target){
                lo = mid + 1;
            }
            else{
                hi = mid;
            }
        }
        if(lo < n && nums[lo] == target){
            return lo;
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] nums = {2,1,5,1,1};
        System.out.println(maxSelectedElements(nums));
    }
}
