public class may07_26 {
    public static int[] maxValue(int[] nums) {
        int n = nums.length;
        int[] leftMax = new int[n];
        leftMax[0] = nums[0];
        for(int i = 1 ; i < n ; i++){
            leftMax[i] = Math.max(leftMax[i - 1], nums[i]);
        }
        int[] rightMin = new int[n];
        rightMin[n - 1] = nums[n - 1];
        for(int i = n - 2 ; i >= 0 ; i--){
            rightMin[i] = Math.min(rightMin[i + 1], nums[i]);
        }
        int[] res = new int[n];
        res[n - 1] = leftMax[n - 1];
        for(int i = n - 2 ; i >= 0 ; i--){
            if(leftMax[i] <= rightMin[i + 1]){
                res[i] = leftMax[i];
            }
            else{
                res[i] = res[i + 1];
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int[] nums = {2,3,1};
        int[] ans = maxValue(nums);
        for(int i = 0 ; i < ans.length ; i++){
            System.out.print(ans[i] + " ");
        }
    }
}
