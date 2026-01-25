import java.util.Arrays;

public class jan25_26 {
    public static int minimumDifference(int[] nums, int k) {
        if(k == 1) return 0;
        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE; 
        int l = 0;
        for(int r = k - 1 ; r < nums.length ; ){
            diff = Math.min(diff, nums[r] - nums[l]);
            l++;
            r++;
        }
        return diff;
    }
    public static void main(String[] args) {
        int[] nums = {90};
        int[] nums2 = {9,4,1,7};
        System.out.println(minimumDifference(nums,1) + " " + minimumDifference(nums2, 2));
    }
}
