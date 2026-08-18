public class aug17_26 {
    public static int largestInteger(int[] nums, int k) {
        int n = nums.length;
        // case 1 - k == n
        if(k == n){
            int ans = 0;
            for(int i = 0 ; i < n ; i++){
                ans = Math.max(ans, nums[i]);
            }
            return ans;
        }
        // case 2 - k == 1
        int[] freq = new int[51];
        for(int num : nums){
            freq[num]++;
        }
        if(k == 1){
            for(int num = 50 ; num >= 0 ; num--){
                if(freq[num] == 1){
                    return num;
                }
            }
        }
        // case 3 - 1 < k < n
        int res = -1;
        if(freq[nums[0]] == 1){
            res = Math.max(res, nums[0]);
        }
        if(freq[nums[n - 1]] == 1){
            res = Math.max(res, nums[n - 1]);
        }
        return res;
    }
    public static void main(String[] args) {
        int[] nums = {3,9,2,1,7};
        int k = 3;
        int[] nums1 = {3,9,7,2,1,7};
        int k1 = 4;
        System.out.println(largestInteger(nums, k) + " " + largestInteger(nums1, k1));
    }
}
