import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class april10_26 {
    public static int minimumDistance(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0 ; i < nums.length ; i++){
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }
        int minDist = Integer.MAX_VALUE;
        for(List<Integer> indices : map.values()){
            if(indices.size() < 3) continue;
            for(int i = 0 ; i <= indices.size() - 3 ; i++){
                int a = indices.get(i);
                int c = indices.get(i + 2);
                int dist = 2 * (c - a);
                minDist = Math.min(minDist, dist);
            }
        }
        return minDist == Integer.MAX_VALUE ? -1 : minDist;




        // int n = nums.length;
        // int ans = Integer.MAX_VALUE;
        // for(int i = 0 ; i < n ; i++){
        //     for(int j = i + 1 ; j < n ; j++){
        //         if(nums[i] != nums[j]){
        //             continue;
        //         }
        //         for(int k = j + 1 ; k < n ; k++){
        //             if(nums[j] == nums[k]){
        //                 ans = Math.min(ans, Math.abs(i - j) + Math.abs(j - k) + Math.abs(k - i));
        //             }
        //         }
        //     }
        // }
        // return ans == Integer.MAX_VALUE ? -1 : ans;
    }
    public static void main(String[] args) {
        int[] nums = {1,2,1,1,3};
        int[] nums2 = {1,1,2,3,2,1,2};
        System.out.println(minimumDistance(nums) + " " + minimumDistance(nums2));
    }
}
