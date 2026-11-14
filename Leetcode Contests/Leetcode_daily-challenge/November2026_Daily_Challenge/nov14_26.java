import java.util.List;
import java.util.ArrayList;

public class nov14_26 {
    public static int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int ans = Integer.MAX_VALUE;
        int n = nums.size();
        for(int i = 0 ; i < n ; i++){
            int sum = 0;
            for(int j = i ; j < n ; j++){
                if(j - i + 1 < l){
                    sum += nums.get(j);
                    continue;
                }
                else if(j - i + 1 > r){
                    break;
                }
                sum += nums.get(j);
                if(sum > 0){
                    ans = Math.min(ans, sum);
                }
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        int l = 2, r = 3;
        System.out.println(minimumSumSubarray(list, l, r));
    }
}
