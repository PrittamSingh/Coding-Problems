import java.util.Arrays;

public class may10_26 {
    // BOTTOM - UP
    public static int maximumJumps(int[] nums, int target) {
        int n = nums.length;
        int[] t = new int[n+1];
        Arrays.fill(t, Integer.MIN_VALUE);
        t[n-1] = 0;
        for(int i = n-2; i >= 0; i--) {
            for(int j = i+1; j < n; j++) {
                if(Math.abs(nums[i] - nums[j]) <= target &&
                   t[j] != Integer.MIN_VALUE) {

                    int temp = 1 + t[j];

                    t[i] = Math.max(t[i], temp);
                }
            }
        }
        return t[0] < 0 ? -1 : t[0];
    }



    // RECURSION + MEMO
    // int n;
    // public int solve(int i, int[] nums, int target, int[] t) {
    //     if(i == n-1) {
    //         return t[i] = 0;
    //     }
    //     if(t[i] != Integer.MIN_VALUE) {
    //         return t[i];
    //     }
    //     int result = Integer.MIN_VALUE;
    //     for(int j = i+1; j < n; j++) {
    //         if(Math.abs(nums[i] - nums[j]) <= target) {
    //             int temp = 1 + solve(j, nums, target, t);
    //             result = Math.max(result, temp);
    //         }
    //     }
    //     return t[i] = result;
    // }
    // public int maximumJumps(int[] nums, int target) {
    //     n = nums.length;
    //     int[] t = new int[n+1];
    //     Arrays.fill(t, Integer.MIN_VALUE);
    //     int result = solve(0, nums, target, t);
    //     return result < 0 ? -1 : result;
    // }
    public static void main(String[] args) {
        int[] nums = {1,3,6,4,1,2};
        int target = 2;
        System.out.println(maximumJumps(nums, target));
    }
}
