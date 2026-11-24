public class nov24_26 {
    public static int maxLength(int[] nums) {
        int n = nums.length;
        int maxLen = 0;
        for(int i = 0 ; i < n ; i++){
            int prod = 1;
            int gcd = 0;
            int lcm = 1;
            for(int j = i ; j < n ; j++){
                prod *= nums[j];
                gcd = findGCD(gcd, nums[j]);
                lcm = (lcm * nums[j]) / findGCD(lcm, nums[j]);
                if(prod == gcd * lcm){
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }
        return maxLen;
    }
    public static int findGCD(int a, int b){
        while(b != 0){
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    public static void main(String[] args) {
        int[] nums = {1,2,1,2,1,1,1};
        System.out.println(maxLength(nums));
    }
}
