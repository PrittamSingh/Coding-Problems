import java.util.Arrays;

public class nov02_26 {
    public static int minMoves2(int[] nums) {
        // int n = nums.length;
        // Arrays.sort(nums);
        // int ans = 0;
        // int midEle = nums[n / 2];
        // for(int i = 0 ; i < n ; i++){
        //     ans += Math.abs(nums[i] - midEle);
        // }
        // return ans;



        int n = nums.length;
        Arrays.sort(nums);
        int ans = 0;
        int midEle = nums[n / 2];
        for(int i = 0 ; i < n / 2 ; i++){
            ans += Math.abs(nums[i] - midEle);
            ans += Math.abs(nums[n - i - 1] - midEle);
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] nums = {1,10,2,9};
        System.out.println(minMoves2(nums));
    }
}
