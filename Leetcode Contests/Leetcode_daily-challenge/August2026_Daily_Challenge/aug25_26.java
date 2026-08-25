import java.util.HashSet;
import java.util.Set;

public class aug25_26 {
    public static int missingMultiple(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        for(int i = k ; i  < 202 ; i += k){
            if(!set.contains(i)){
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] nums = {8,2,3,4,6};
        int k = 2;
        System.out.println(missingMultiple(nums, k));
    }
}
