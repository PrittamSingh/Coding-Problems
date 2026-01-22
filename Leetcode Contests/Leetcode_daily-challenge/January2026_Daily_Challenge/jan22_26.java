import java.util.ArrayList;
import java.util.List;

public class jan22_26 {
    public static int minimumPairRemoval(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for(int num: nums){
            list.add(num);
        }
        if(check(list)) return 0;
        int cnt = 0;
        while(!check(list)){
            int sum = Integer.MAX_VALUE;
            int idx = -1;
            for(int i=0; i<list.size()-1; i++){
                int currSum = list.get(i) + list.get(i+1);
                if(currSum < sum){
                    sum = currSum;
                    idx = i;
                }
            }
            int ele = list.get(idx) + list.get(idx + 1);
            list.remove(idx+1);
            list.set(idx, ele);
            cnt++;
        }
        return cnt;
    }
    public static boolean check(List<Integer> list){
        for(int i=0; i<list.size()-1; i++){
            if(list.get(i) > list.get(i+1)){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int[] nums = {5,2,3,1};
        int[] nums2 = {1,2,2};
        System.out.println(minimumPairRemoval(nums) + " " + minimumPairRemoval(nums2));
    }
}
