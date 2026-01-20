import java.util.Arrays;
import java.util.List;

public class jan20_26 {
    public static int[] minBitwiseArray(List<Integer> nums) {
        int ans[] = new int[nums.size()]; int i=0;
        for(int n: nums){
            if(n == 2){
                ans[i] = -1;
            } else {
                int mask = ~(((n+1) & ~n) >> 1);
                ans[i] = n & mask;
            }
            i++;
        }
        return ans;
    }
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(2,3,5,7);
        System.out.println(Arrays.toString(minBitwiseArray(nums)));    }
}
