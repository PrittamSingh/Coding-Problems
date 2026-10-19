import java.util.ArrayList;
import java.util.List;

public class oct19_26 {
    public static List<Integer> targetIndices(int[] nums, int target) {
        // Arrays.sort(nums);
        // List<Integer> ans = new ArrayList<>();
        // for(int i = 0 ; i < nums.length ; i++){
        //     if(nums[i] == target){
        //         ans.add(i);
        //     }
        // }
        // return ans;

        int lessThanTargetCount = 0;
        int targetCount = 0;
        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] < target){
                lessThanTargetCount++;
            }
            else if(nums[i] == target){
                targetCount++;
            }
        }
        List<Integer> ans = new ArrayList<>();
        for(int i = lessThanTargetCount ; i < lessThanTargetCount + targetCount ; i++){
            ans.add(i);
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] nums = {1,2,5,2,3};
        int target = 2;
        System.out.println(targetIndices(nums, target));
    }
}
