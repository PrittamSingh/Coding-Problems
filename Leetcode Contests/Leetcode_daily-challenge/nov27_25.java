public class nov27_25 {
    public static long maxSubarraySum(int[] nums, int k) {
        // int n = nums.length;
        // long[] prefix = new long[n + 1];
        
        // for(int i = 0 ; i < n ; i++){
        //     prefix[i + 1] = prefix[i] + nums[i];
        // }
        // long ans = Long.MIN_VALUE;
        // for(int l = 0 ; l < n ; l++){
        //     for(int r = l ; r < n ; r++){
        //         int len = r - l + 1;
        //         if(len % k == 0){
        //             long sum = prefix[r + 1] - prefix[l];
        //             ans = Math.max(ans, sum);
        //         }
        //     }
        // }
        // return ans;


        int n = nums.length;
        long[] prefix = new long[n + 1];

        for(int i = 0 ; i < n ; i++){
            prefix[i + 1] = prefix[i] + nums[i];
        }

        long ans = Long.MIN_VALUE;

        for(int l = 0 ; l < n ; l++){
            for(int r = l + k - 1 ; r < n ; r += k){
                long sum = prefix[r + 1] - prefix[l];
                ans = Math.max(ans, sum);
            }
        }
        return ans;


        // int n = nums.length;
        // long[] minPrefix = new long[k];
        // Arrays.fill(minPrefix , Long.MAX_VALUE);
        // minPrefix[0] = 0;
        // long prefix = 0;
        // long ans = Long.MIN_VALUE;
        // for(int i = 0 ; i < n ; i++){
        //     prefix += nums[i];
        //     int mod = (i + 1) % k;

        //     if(minPrefix[mod] != Long.MAX_VALUE){
        //         ans = Math.max(ans, prefix - minPrefix[mod]);
        //     }
        //     minPrefix[mod] = Math.min(minPrefix[mod], prefix);
        // }
        // return ans;
    }
    public static void main(String[] args) {
        int[] nums = {1,2};
        int k = 1;
        System.out.println((int)maxSubarraySum(nums, k));
        int[] nums2 = {-1,-2,-3,-4,-5};
        int k2 = 4;
        System.out.println((int)maxSubarraySum(nums2, k2));
        int[] nums3 = {-5,1,2,-3,4};
        int k3 = 2;
        System.out.println((int)maxSubarraySum(nums3, k3));
    }
}
