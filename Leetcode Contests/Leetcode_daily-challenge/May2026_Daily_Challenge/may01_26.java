public class may01_26 {
    public static int maxRotateFunction(int[] nums) {
        // int n = nums.length;
        // int maxVal = Integer.MIN_VALUE;
        // for(int k = 0 ; k < n ; k++){
        //     int value = 0;
        //     for(int i = 0 ; i < n ; i++){
        //         value += i * nums[(i - k + n) % n];
        //     }
        //     maxVal = Math.max(maxVal, value);
        //     System.out.println(value);
        // }
        // return maxVal;



        // int n = nums.length;
        // long maxVal = Long.MIN_VALUE;
        // long sum = 0;
        // for(int i = 0 ; i < n ; i++){
        //     sum += nums[i];
        // }
        // long[] f = new long[n];
        // long f0 = 0;
        // for(int i = 0 ; i < n ; i++){
        //     f0 += i * nums[i];
        // }
        // f[0] = f0;
        // for(int k = 1 ; k < n ; k++){
        //     f[k] = (f[k - 1] + sum) - (n * nums[n - k]);
        // }
        // for(int i = 0 ; i < n ; i++){
        //     maxVal = Math.max(maxVal, f[i]);
        // }
        // return (int)maxVal;



        int n = nums.length;
        int maxVal = Integer.MIN_VALUE;
        int prev = 0;
        int sum = 0;
        for(int i = 0 ; i < n ; i++){
            prev += i * nums[i];
            sum += nums[i];
        }
        maxVal = Math.max(maxVal, prev);
        for(int k = 1 ; k < n ; k++){
            int curr = prev + sum - (n * nums[n - k]);
            maxVal = Math.max(maxVal, curr);
            prev = curr;
        }
        return maxVal;
    }
    public static void main(String[] args) {
        int[] nums = {4,3,2,6};
        System.out.println(maxRotateFunction(nums));
    }
}
