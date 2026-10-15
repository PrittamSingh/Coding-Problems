import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class oct15_26 {
    public static int sumCounts(List<Integer> nums) {
        int n = nums.size();
        int res = 0;
        for(int i = 0 ; i < n ; i++){
            Set<Integer> set = new HashSet<>();
            for(int j = i ; j < n ; j++){
                set.add(nums.get(j));
                int sq = set.size() * set.size();
                res += sq;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(2);
        nums.add(1);
        System.out.println(sumCounts(nums));
    }
}
