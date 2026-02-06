import java.util.Arrays;

public class feb06_26 {
    public static int minRemoval(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int ans = n;
        int right = 0;
        for(int left = 0 ; left < n ; left++){
            while(right < n && nums[right] <= (long)nums[left] * k){
                right++;
            }
            ans = Math.min(ans, n - (right - left));
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] nums1 = {2,1,5};
        int k1 = 2;
        System.out.println(minRemoval(nums1, k1));
        int[] nums2 = {1,6,2,9};
        int k2 = 3;
        System.out.println(minRemoval(nums2, k2));
    }
}
