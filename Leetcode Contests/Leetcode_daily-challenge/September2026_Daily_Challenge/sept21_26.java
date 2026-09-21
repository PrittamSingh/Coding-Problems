import java.util.*;
public class sept21_26 {
    // public int solve(int i, int j, int[] nums, int k) {
    //     long product = 1;
    //     for(int t = i ; t <= j ; t++){
    //         product = (product * nums[t]) % k;
    //     }
    //     return (int) product;
    // }
    // public long[] resultArray(int[] nums, int k) {
    //     int n = nums.length;
    //     long[] result = new long[k];
    //     for(int i = 0 ; i < n ; i++){
    //         for(int j = i ; j < n ; j++){
    //             int x = solve(i, j, nums, k);
    //             result[x]++;
    //         }
    //     }
    //     return result;
    // }




    // public int solve(int i, int j, int[] nums, int k, int[][] memo) {
    //     if (memo[i][j] != -1) return memo[i][j];
    //     if(i == j){
    //         return memo[i][j] = nums[i] % k;
    //     }
    //     int prev = solve(i, j - 1, nums, k, memo);
    //     return memo[i][j] = (prev * (nums[j] % k)) % k;
    // }
    // public long[] resultArray(int[] nums, int k) {
    //     int n = nums.length;
    //     int[][] memo = new int[n][n];
    //     for(int[] row : memo){
    //         Arrays.fill(row, -1);
    //     }
    //     long[] result = new long[k];
    //     for(int i = 0 ; i < n ; i++){
    //         for(int j = i ; j < n ; j++){
    //             int x = solve(i, j, nums, k, memo);
    //             result[x]++;
    //         }
    //     }
    //     return result;
    // }



    public static long[] resultArray(int[] nums, int k) {
        int n = nums.length;
        long[] result = new long[k];
        long[] prevCount = new long[k];
        for(int i = 0 ; i < n ; i++){
            long[] currCount = new long[k];
            int currElementRemainder = nums[i] % k;
            currCount[currElementRemainder]++;
            for(int oldRem = 0 ; oldRem <= k - 1 ; oldRem++){
                int newRemain = (int) (((long) oldRem * nums[i] % k) % k);
                currCount[newRemain] += prevCount[oldRem];
            }
            prevCount = currCount;
            for(int x = 0 ; x <= k - 1 ; x++){
                result[x] += prevCount[x];
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        int k = 3;
        System.out.println(Arrays.toString(resultArray(nums, k)));
    }
}
