public class april13_26 {
    public static int getMinDistance(int[] nums, int target, int start) {
        int n = nums.length;
        int minDist = Integer.MAX_VALUE;
        for(int i = 0 ; i < n ; i++){
            if(nums[i] == target){
                minDist = Math.min(minDist, Math.abs(i - start));
            }
        }
        return minDist;
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        int target = 5, start = 3;
        System.out.println(getMinDistance(nums, target, start));
    }
}
