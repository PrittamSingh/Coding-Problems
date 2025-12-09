import java.util.HashMap;
import java.util.Map;

public class dec09_25 {
    public static int specialTriplets(int[] nums) {
        final int MOD = 1000000007;
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        Map<Integer, Integer> prefixMap = new HashMap<>();
        long ans = 0;
        for(int num : nums){
            int total = map.getOrDefault(2*num, 0);
            int f1 = prefixMap.getOrDefault(2*num, 0);
            int f2 = total - f1;
            if(num == 0){
                f2--;
            }

            prefixMap.put(num, prefixMap.getOrDefault(num, 0) + 1);
            ans = (ans + (long)f1 * f2) % MOD;
        }
        return (int)ans;
    }
    public static void main(String[] args) {
        int[] nums1 = {6,3,6};
        int[] nums2 = {0,1,0,0};
        int[] nums3 = {8,4,2,8,4};
        System.out.println(specialTriplets(nums1) + " " + specialTriplets(nums2) + " " + specialTriplets(nums3));
    }
}
