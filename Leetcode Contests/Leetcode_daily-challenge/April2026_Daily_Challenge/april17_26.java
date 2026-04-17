import java.util.HashMap;
import java.util.Map;

public class april17_26 {
    public static int minMirrorPairDistance(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int ans = Integer.MAX_VALUE;
        for(int i = 0 ; i < nums.length ; i++){
            if(map.containsKey(nums[i])){
                int j = map.get(nums[i]);
                int currDist = i - j;
                if(currDist < ans){
                    ans = currDist;
                }
            }
            int rev = reverse(nums[i]);
            map.put(rev, i);
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
    public static int reverse(int num){
        int rev = 0;
        while(num > 0){
            rev = (rev * 10) + (num % 10);
            num /= 10;
        }
        return rev;
    }
    public static void main(String[] args) {
        int[] nums = {12,21,45,33,54};
        System.out.println(minMirrorPairDistance(nums));
    }
}
