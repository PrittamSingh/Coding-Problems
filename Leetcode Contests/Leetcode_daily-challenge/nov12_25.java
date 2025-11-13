public class nov12_25 {
    public static int minOperations(int[] nums) {
        int n = nums.length;
        int countOnes = 0;
        for (int num : nums){
            if(num == 1) countOnes++;
        }
        if(countOnes > 0){
            return n - countOnes;
        }
        int overallGCD = nums[0];
        for(int i = 1 ; i < n ; i++){
            overallGCD = gcd(overallGCD, nums[i]);
        }
        if(overallGCD != 1) return -1;
        int minLength = Integer.MAX_VALUE;
        for(int i = 0 ; i < n ; i++){
            int currentGCD = nums[i];
            for(int j = i + 1 ; j < n ; j++){
                currentGCD = gcd(currentGCD , nums[j]);
                if(currentGCD == 1){
                    minLength = Math.min(minLength, j - i + 1);
                    break;
                }
            }
        }
        return (minLength - 1) + (n - 1);
    }
    private static int gcd(int a , int b){
        return b == 0 ? a : gcd(b, a % b);
    }
    public static void main(String[] args) {
        int[] nums = {2,6,3,4};
        System.out.println(minOperations(nums));
        int[] nums2 = {2,10,6,14};
        System.out.println(minOperations(nums2));

    }
}
