public class aug30_26 {
    public static int minimumDeletions(int[] nums) {
        int n = nums.length;
        int maxIdx = 0;
        int minIdx = 0;
        for(int i = 1 ; i < n ; i++){
            if(nums[i] > nums[maxIdx]){
                maxIdx = i;
            }
            if(nums[i] < nums[minIdx]){
                minIdx = i;
            }
        }
        if(minIdx == maxIdx){
            return 1;
        }
        else if(minIdx > maxIdx){
            return Math.min(minIdx + 1, Math.min(n - maxIdx, maxIdx + 1 + n - minIdx));
        }
        return Math.min(maxIdx + 1, Math.min(n - minIdx, minIdx + 1 + n - maxIdx));
    }
    public static void main(String[] args) {
        int[] nums = {2,10,7,5,4,1,8,6};
        System.out.println(minimumDeletions(nums));
    }
}
