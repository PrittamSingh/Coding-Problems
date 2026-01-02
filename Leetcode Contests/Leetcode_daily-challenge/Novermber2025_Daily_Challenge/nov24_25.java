import java.util.ArrayList;
import java.util.List;

public class nov24_25 {
    public static List<Boolean> prefixesDivBy5(int[] nums) {
        // Approach-1 Binary shift operator
        // int val = 0;
        // List<Boolean> array = new ArrayList<>();
        // for(int num : nums){
        //     val = ((val << 1) + num) % 5;
        //     array.add(val == 0 ? true : false);
        // }
        // return array;

        // Approach-2
        int val = 0;
        List<Boolean> array = new ArrayList<>();
        for(int num : nums){
            val = val * 2;
            val = (val + num) % 5;
            array.add(val % 5 == 0 ? true : false);
        }
        return array;
    }
    public static void main(String[] args) {
        int[] nums = {0,1,1}, nums2 = {1,1,1};
        List<Boolean> result = prefixesDivBy5(nums);
        List<Boolean> result2 = prefixesDivBy5(nums2);
        System.out.println(result + " " + result2);
    }
}
