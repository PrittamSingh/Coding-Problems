import java.util.HashMap;
import java.util.Map;

public class june25_26 {
    public static int countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;
        int[] arr = new int[n];
        for(int i = 0 ; i < n ; i++){
            arr[i] = (nums[i] == target) ? 1 : -1;
        }
        Map<Integer, Integer> prefixCount = new HashMap<>();
        prefixCount.put(0, 1);

        int prefixSum = 0;
        int count = 0;

        for(int x : arr){
            prefixSum += x;
            for(Map.Entry<Integer, Integer> e : prefixCount.entrySet()){
                if(e.getKey() < prefixSum){
                    count += e.getValue();
                }
            }
            prefixCount.put(prefixSum, prefixCount.getOrDefault(prefixSum, 0) + 1);
        }
        return count;
    }
    public static void main(String[] args) {
        int[] nums = {1,2,2,3};
        int target = 2;
        System.out.println(countMajoritySubarrays(nums, target));
    }
}
