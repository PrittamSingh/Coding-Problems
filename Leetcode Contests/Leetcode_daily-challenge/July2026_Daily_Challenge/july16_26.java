import java.util.Arrays;

public class july16_26 {
    public static long gcdSum(int[] nums) {
        int n = nums.length;
        int[] prefixMax = new int[n];
        prefixMax[0] = nums[0];
        for(int i = 1 ; i < n ; i++){
            prefixMax[i] = Math.max(prefixMax[i - 1], nums[i]);
        }
        int[] prefixGcd = new int[n];
        for(int i = 0 ; i < n ; i++){
            prefixGcd[i] = gcd(nums[i], prefixMax[i]);
        }
        Arrays.sort(prefixGcd);
        int times = n / 2;
        long sum = 0;
        for(int i = 0 ; i < times ; i++){
            int a = prefixGcd[i];
            int b = prefixGcd[n - i - 1];
            int ans = gcd(a, b);
            sum += 1L * ans;
        }
        return sum;
    }
    public static int gcd(int a, int b){
        while(b != 0){
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    public static void main(String[] args) {
        int[] nums = {2,6,4};
        int[] nums2 = {3,6,2,8};
        System.out.println(gcdSum(nums) + " " + gcdSum(nums2));
    }
}
