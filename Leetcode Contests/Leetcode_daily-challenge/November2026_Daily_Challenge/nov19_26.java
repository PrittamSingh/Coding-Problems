import java.util.Arrays;

public class nov19_26 {
    public static int minimizeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int diff1 = nums[n - 2] - nums[1];
        int diff2 = nums[n - 3] - nums[0];
        int diff3 = nums[n - 1] - nums[2];
        return Math.min(diff1, Math.min(diff2, diff3));
    }
    public static void main(String[] args) {
        int[] nums = {1,4,7,8,5};
        System.out.println(minimizeSum(nums));
    }
}
