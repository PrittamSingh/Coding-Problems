public class aug15_26 {
    public static int longestSubsequence(int[] nums) {
        int xor = 0;
        boolean allZero = true;
        for(int num : nums){
            xor = xor ^ num;
            if(num != 0){
                allZero = false;
            }
        }
        if(allZero){
            return 0;
        }
        if(xor != 0){
            return nums.length;
        }
        return nums.length - 1;
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        int[] nums1 = {2,3,4};
        System.out.println(longestSubsequence(nums) + " " + longestSubsequence(nums1));
    }
}
