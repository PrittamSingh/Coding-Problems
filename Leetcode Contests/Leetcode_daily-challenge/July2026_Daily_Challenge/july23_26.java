public class july23_26 {
    public static int uniqueXorTriplets(int[] nums) {
        int n = nums.length;
        if(n == 1 || n == 2){
            return n;
        }
        int ans = 1;
        while(ans <= n){
            ans *= 2;
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] nums = {5, 4, 3, 1, 2};
        System.out.println(uniqueXorTriplets(nums));
    }
}
