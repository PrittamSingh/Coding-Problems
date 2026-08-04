import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class aug04_26 {
    public static List<Integer> findMissingElements(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int num : nums){
            set.add(num);
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        List<Integer> ans = new ArrayList<>();
        for(int i = min ; i <= max ; i++){
            if(!set.contains(i)){
                ans.add(i);
            }
        }
        return ans;




        // List<Integer> ans = new ArrayList<>();
        // int min = Integer.MAX_VALUE;
        // int max = Integer.MIN_VALUE;
        // for(int num : nums){
        //     min = Math.min(min, num);
        //     max = Math.max(max, num);
        // }
        // for(int j = min ; j <= max ; j++){
        //     boolean present = false;
        //     for(int i = 0 ; i < nums.length ; i++){
        //         if(j == nums[i]){
        //             present = true;
        //         }
        //     }
        //     if(!present){
        //         ans.add(j);
        //     }

        // }
        // return ans;
    }
    public static void main(String[] args) {
        int[] nums = {1,4,2,5};
        System.out.println(findMissingElements(nums));
    }
}
