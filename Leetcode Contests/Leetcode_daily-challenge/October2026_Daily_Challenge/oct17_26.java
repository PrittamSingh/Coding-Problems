import java.util.*;
public class oct17_26 {
    public static int minSwaps(int[] nums) {
        int n = nums.length;
        int[][] arr = new int[n][2];
        for(int i = 0 ; i < n ; i++){
            arr[i][0] = nums[i];
            int num = nums[i];
            int sum = 0;
            while(num > 0){
                int d = num % 10;
                sum += d;
                num /= 10;
            }
            arr[i][1] = sum;
        }
        Arrays.sort(arr, (a, b) -> {
            if(a[1] != b[1]){
                return Integer.compare(a[1], b[1]);
            }
            else{
                return Integer.compare(a[0], b[0]);
            }
        });
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0 ; i < n ; i++){
            // System.out.println(arr[i][0]);
            map.put(nums[i], i);
        }
        int swaps = 0;
        for(int i = 0 ; i < n ; i++){
            int expectedVal = arr[i][0];
            int currVal = nums[i];
            if(expectedVal == currVal){
                continue;
            }
            int expectedIdx = map.get(expectedVal);
            nums[i] = expectedVal;
            nums[expectedIdx] = currVal;
            map.put(expectedVal, i);
            map.put(currVal, expectedIdx);
            swaps++;
        }
        return swaps;
    }
    public static void main(String[] args) {
        // int[] nums = {18,43,34,16};
        int[] nums = {22,14,33,7};
        System.out.println(minSwaps(nums));
    }
}
