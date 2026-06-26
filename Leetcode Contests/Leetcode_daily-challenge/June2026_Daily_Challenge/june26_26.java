import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class june26_26 {
    static class Fenwick {
        int[] bit;
        Fenwick(int n){
            bit = new int[n + 1];
        }
        void add(int idx, int val){
            while (idx < bit.length) {
                bit[idx] += val;
                idx += idx & -idx;
            }
        }
        long sum(int idx){
            long res = 0;
            while (idx > 0) {
                res += bit[idx];
                idx -= idx & -idx;
            }
            return res;
        }
    }
    public static long countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;
        int[] pref = new int[n + 1];
        for(int i = 0 ; i < n ; i++){
            pref[i + 1] = pref[i] + (nums[i] == target ? 1 : -1);
        }
        int[] all = pref.clone();
        Arrays.sort(all);
        Map<Integer, Integer> rank = new HashMap<>();
        int idx = 1;
        for(int x : all){
            if(!rank.containsKey(x)){
                rank.put(x, idx++);
            }
        }
        Fenwick bit = new Fenwick(idx);
        long ans = 0;
        for(int x : pref){
            int r = rank.get(x);
            ans += bit.sum(r - 1);
            bit.add(r, 1);
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] nums = {1,2,2,3};
        int target = 2;
        System.out.println(countMajoritySubarrays(nums, target));
    }
}
