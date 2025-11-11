import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class second {
    public static int minimumDistance(int[] nums){
        int n = nums.length;
        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int i = 0 ; i < n ; i++){
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }
        int minDistance = Integer.MAX_VALUE;
        for(List<Integer> indices : map.values()){
            if(indices.size() < 3) continue;

            for(int i = 0 ; i < indices.size() - 2 ; i++){
                int first = indices.get(i);
                int third = indices.get(i + 2);
                int distance = 2 * (third - first);
                minDistance = Math.min(minDistance, distance);
            }
        }
        return (minDistance == Integer.MAX_VALUE) ? -1 : minDistance;
    }
    public static void main(String args[]){
        int[] nums = {1,2,1,1,3};
        System.out.println(minimumDistance(nums));

        int[] nums2 = {1,1,2,3,2,1,2};
        System.out.println(minimumDistance(nums2));

        int[] nums3 = {1};
        System.out.println(minimumDistance(nums3));
    }
}
