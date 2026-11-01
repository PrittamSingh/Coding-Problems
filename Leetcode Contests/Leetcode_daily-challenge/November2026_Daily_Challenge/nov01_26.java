public class nov01_26 {
    // public int minMoves(int[] nums) {
    //     int n = nums.length;
    //     int moves = 0;
    //     while(!allElementEqual(nums)){
    //         int maxIdx = 0;
    //         for(int i = 1 ; i < n ; i++){
    //             if(nums[i] > nums[maxIdx]){
    //                 maxIdx = i;
    //             }
    //         }
    //         for(int i = 0 ; i < n ; i++){
    //             if(i != maxIdx){
    //                 nums[i]++;
    //             }
    //         }
    //         moves++;
    //     }
    //     return moves;
    // }
    // public boolean allElementEqual(int[] nums){
    //     for(int i = 1 ; i < nums.length ; i++){
    //         if(nums[i] != nums[i - 1]){
    //             return false;
    //         }
    //     }
    //     return true;
    // }




    public static int minMoves(int[] nums) {
        int n = nums.length;
        long sum = 0;
        int minEle = Integer.MAX_VALUE;
        for(int i = 0 ; i < n ; i++){
            sum += nums[i];
            minEle = Math.min(minEle, nums[i]);
        }
        return (int)(sum - (n * minEle));
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(minMoves(nums));
    }
}
