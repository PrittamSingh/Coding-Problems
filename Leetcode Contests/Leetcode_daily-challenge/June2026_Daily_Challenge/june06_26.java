import java.util.*;
public class june06_26 {
    public static int[] leftRightDifference(int[] nums) {
        int n = nums.length;
        int[] leftSum = new int[n];
        leftSum[0] = 0;
        for(int i = 1 ; i < n ; i++){
            leftSum[i] = leftSum[i - 1] + nums[i - 1];
        }
        // for(int i = 0 ; i < n ; i++){
        //     System.out.print(leftSum[i] + " ");
        // }
        // System.out.println();
        int[] rightSum = new int[n];
        rightSum[n - 1] = 0;
        for(int i = n - 2 ; i >= 0 ; i--){
            rightSum[i] = rightSum[i + 1] + nums[i + 1];
        }
        // for(int i = 0 ; i < n ; i++){
        //     System.out.print(rightSum[i] + " ");
        // }
        // System.out.println();
        int[] ans = new int[n];
        for(int i = 0 ; i < n ; i++){
            ans[i] = Math.abs(leftSum[i] - rightSum[i]);
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] nums = {10,4,8,3};
        System.out.println(Arrays.toString(leftRightDifference(nums)));
    }
}
