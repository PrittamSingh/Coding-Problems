import java.util.*;
public class dec06_25 {
    // final int mod = 1000000007;
    // public int countPartitions(int[] nums, int k) {
    //     int n = nums.length;
    //     int[] dp = new int[n];
    //     Arrays.fill(dp, -1);
    //     return solve(0, nums, k, dp);
    // }
    // private int solve(int i, int[] nums, int k, int[] dp){
    //     int n = nums.length;
    //     if(i == n) return 1;
    //     if(dp[i] != -1) return dp[i];
    //     int mini = nums[i];
    //     int maxi = nums[i];

    //     int ways = 0;
    //     for(int j = i ; j < n ; j++){
    //         mini = Math.min(mini, nums[j]);
    //         maxi = Math.max(maxi, nums[j]);
    //         if(maxi - mini > k){
    //             break;
    //         }
    //         ways = (ways + solve(j + 1, nums, k, dp)) % mod;
    //     }
    //     return dp[i] = ways;
    // }

    static final int mod = 1000000007;
    public static int countPartitions(int[] nums, int k) {
        int n = nums.length;
        long[] dp = new long[n + 1];
        long[] prefix = new long[n + 1];

        dp[0] = 1;
        prefix[0] = 1;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int j = 0;

        for(int i = 0 ; i < n ; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);

            while(j <= i && (map.lastKey() - map.firstKey()) > k){
                int val = nums[j];
                int cnt = map.get(val);
                if(cnt == 1) map.remove(val);
                else map.put(val, cnt - 1);

                j++;
            }
            if (j > 0) {
                dp[i + 1] = (prefix[i] - prefix[j - 1] + mod) % mod;
            } else {
                dp[i + 1] = prefix[i] % mod;
            }

            prefix[i + 1] = (prefix[i] + dp[i + 1]) % mod;
        }
        return (int) dp[n];
    } 
    public static void main(String[] args) {
        int[] nums1 = {9,4,1,3,7};
        int k1 = 4;
        int[] nums2 = {3,3,4};
        int k2 = 0;
        System.out.println(countPartitions(nums1, k1) + " " + countPartitions(nums2, k2));
    }
}
