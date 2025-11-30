import java.util.HashMap;
import java.util.Map;

public class nov30_25 {
    public static int minSubarray(int[] nums, int p) {
        // Map<Integer, TreeSet<Integer>> map = new HashMap<>();
        // int n = nums.length;
        // long suffix = 0;
        // int ans = Integer.MAX_VALUE;

        // for(int i = n - 1 ; i >= 0 ; i--){
        //     suffix = (suffix + nums[i]) % p;
        //     map.putIfAbsent((int)suffix, new TreeSet<>());
        //     map.get((int)suffix).add(i);
        //     if(suffix == 0){
        //         ans = Math.min(ans, i);
        //     }
        // }
        // long prefix = 0;
        // for(int i = 0 ; i < n ; i++){
        //     prefix = (prefix + nums[i]) % p;
        //     int val = (int)((p - prefix) % p);
        //     if(prefix == 0){
        //         val = 0;
        //         ans = Math.min(ans, n - 1 - i);
        //     }
        //     if(map.containsKey(val)){
        //         TreeSet<Integer> set = map.get(val);
        //         Integer index = set.higher(i);
        //         if(index != null){
        //             ans = Math.min(ans, index - i - 1);
        //         }
        //     }
        // }
        // return ans == Integer.MAX_VALUE ? -1 : ans;



        // long sum = 0;
        // for(int num : nums) sum = (sum + num) % p;
        // if(sum == 0) return 0;

        // long target = sum;
        // Map<Long, Integer> map = new HashMap<>();
        // map.put(0L, -1);

        // long prefix = 0;
        // int ans = nums.length;
        // for(int i = 0 ; i < nums.length ; i++){
        //     prefix = (prefix + nums[i]) % p;

        //     long need = (prefix - target + p) % p;
        //     if(map.containsKey(need)){
        //         ans = Math.min(ans, i - map.get(need));
        //     }
        //     map.put(prefix, i);
        // }
        // return ans == nums.length ? -1 : ans;

        int rem = 0;
        for(int num : nums){
            rem = (rem + num) % p;
        }
        if(rem == 0) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int curr = 0;
        int min = Integer.MAX_VALUE;
        for(int i = 0 ; i < nums.length ; i++){
            curr = (curr + nums[i]) % p;
            int target = (curr - rem + p) % p;
            if(map.containsKey(target)){
                min = Math.min(min, i - map.get(target));
            }
            map.put(curr, i);
        }
        if(min == Integer.MAX_VALUE || min == nums.length){
            return -1;
        }
        return min;
    }
    public static void main(String[] args) {
        int[] nums = {3,1,4,2};
        int p = 6;
        int[] nums2 = {6,3,5,2};
        int p2 = 9;
        int[] nums3 = {1,2,3};
        int p3 = 3;
        System.out.println(minSubarray(nums, p) + " " + minSubarray(nums2, p2) + " " + minSubarray(nums3, p3));
    }
}
