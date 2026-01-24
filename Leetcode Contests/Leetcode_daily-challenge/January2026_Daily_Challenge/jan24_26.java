import java.util.Arrays;

public class jan24_26 {
    public static int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int i = 0;
        int j = nums.length - 1;
        int maxSum = Integer.MIN_VALUE;
        while(i < j){
            int sum = nums[i] + nums[j];
            maxSum = Math.max(maxSum, sum);
            i++;
            j--;
        }
        return maxSum;
    }
    public static void main(String[] args) {
        int[] nums = {3,5,2,3};
        int[] nums2 = {3,5,4,2,4,6};
        System.out.println(minPairSum(nums) + " " + minPairSum(nums2));
    }
}
