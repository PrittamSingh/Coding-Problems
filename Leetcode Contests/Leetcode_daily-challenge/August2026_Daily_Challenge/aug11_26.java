import java.util.HashSet;
import java.util.Set;

public class aug11_26 {
    public static int missingInteger(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        int sum = nums[0];
        for(int i = 1 ; i < nums.length ; i++){
            if(nums[i] == nums[i - 1] + 1){
                sum += nums[i];
            }
            else{
                break;
            }
        }
        if(sum > 50){
            return sum;
        }
        for(int j = sum ; j < 52 ; j++){
            if(set.contains(j)){
                continue;
            }
            else{
                return j;
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        int[] nums = {3,4,5,1,12,14,13};
        System.out.println(missingInteger(nums));
    }
}
