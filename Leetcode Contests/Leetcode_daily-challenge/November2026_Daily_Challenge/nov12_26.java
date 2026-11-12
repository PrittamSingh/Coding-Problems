public class nov12_26 {
    public static int longestMonotonicSubarray(int[] nums) {
        int n = nums.length;
        if(n == 1){
            return 1;
        }
        int ans = 0;
        int strInc = 1;
        for(int i = 1 ; i < n ; i++){
            if(nums[i] > nums[i - 1]){
                strInc++;
            }
            else{
                strInc = 1;
            }
            ans = Math.max(ans, strInc);
        }
        int strDec = 1;
        for(int i = 1 ; i < n ; i++){
            if(nums[i] < nums[i - 1]){
                strDec++;
            }
            else{
                strDec = 1;
            }
            ans = Math.max(ans, strDec);
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] nums = {1,4,3,3,2};
        int[] nums2 = {3,2,1};
        System.out.println(longestMonotonicSubarray(nums) + " " + longestMonotonicSubarray(nums2));
    }
}
