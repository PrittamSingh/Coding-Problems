import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class jan21_26 {
    public static int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            int p = nums.get(i);
            if (p == 2) {
                ans[i] = -1;
                continue;
            }
            int lowBit = (p + 1) & (~p);
            ans[i] = p - (lowBit >> 1);
        }

        return ans;
    }
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();
        nums.add(2);
        nums.add(3);
        nums.add(5);
        nums.add(7);
        System.out.println(Arrays.toString(minBitwiseArray(nums)));
    }
}
