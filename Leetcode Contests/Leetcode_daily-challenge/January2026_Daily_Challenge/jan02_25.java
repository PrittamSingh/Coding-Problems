import java.util.HashSet;
import java.util.Set;

public class jan02_25 {
    public static int repeatedNTimes(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            // if(set.contains(num)){
            //     return num;
            // }
            // set.add(num);

            if(!set.add(num)){
                return num;
            }
        }
        return -1;


        // int[] freq = new int[10001];
        // for(int num : nums){
        //     freq[num]++;
        //     if(freq[num] == 2){
        //         return num;
        //     }
        // }
        // return -1;
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3,3};
        int[] nums2 = {2,1,2,5,3,2};
        System.out.println(repeatedNTimes(nums) + " " + repeatedNTimes(nums2));
    }
}
