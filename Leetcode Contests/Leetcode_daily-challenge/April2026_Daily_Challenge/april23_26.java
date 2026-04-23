import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class april23_26 {
    public static long[] distance(int[] nums) {
        int n = nums.length;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0 ; i < n ; i++){
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }
        long[] arr = new long[n];
        Arrays.fill(arr, 0);
        for(List<Integer> list : map.values()){
            int size = list.size();
            long[] prefix = new long[size];
            prefix[0] = list.get(0);
            for(int i = 1; i < size; i++){
                prefix[i] = prefix[i - 1] + list.get(i);
            }
            for(int i = 0; i < size; i++){
                int idx = list.get(i);
                long left = (long) i * idx - (i > 0 ? prefix[i - 1] : 0);
                long right = (prefix[size - 1] - prefix[i]) - (long)(size - i - 1) * idx;
                arr[idx] = left + right;
            }
        }
        // for(int i = 0 ; i < n ; i++){
        //     long tot = 0;
        //     for(int idx : map.get(nums[i])){
        //         if(idx == i) continue;
        //         tot += Math.abs(i - idx);
        //     }
            // for(int j = 0 ; j < n ; j++){
            //     if(i == j) continue;
            //     if(nums[i] == nums[j]){
            //         tot += Math.abs(i - j);
            //     }
            // }
        //     arr[i] = tot;
        // }
        return arr;
    }
    public static void main(String[] args) {
        int[] nums = {1,3,1,1,2};
        long[] ans = distance(nums);
        for(int i = 0 ; i < nums.length ; i++){
            System.out.print(ans[i] + " ");
        }
    }
}
