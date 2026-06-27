import java.util.HashMap;
import java.util.Map;

public class june27_26 {
    public static int maximumLength(int[] nums) {
        Map<Long, Integer> cnt = new HashMap<>();
        for (int num : nums) {
            cnt.merge((long) num, 1, Integer::sum);
        }
        int result = 0;
        int ones = cnt.getOrDefault(1L, 0);
        result = (ones % 2 == 1) ? ones : ones - 1;
        for(long num : cnt.keySet()){
            if(num == 1) continue;
            long curr = num;
            int len = 0;
            while(cnt.getOrDefault(curr, 0) > 1){
                len += 2;
                curr = curr * curr;
            }
            len += cnt.containsKey(curr) ? 1 : -1;
            result = Math.max(result, len);
        }
        return result;
    }
    public static void main(String[] args) {
        int[] nums = {5,4,1,2,2};
        System.out.println(maximumLength(nums));
    }
}
