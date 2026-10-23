public class oct23_10 {
    public static int sortPermutation(int[] nums) {
        int n = nums.length;
        int k = -1;
        for(int i = 0 ; i < n ; i++){
            if(nums[i] != i){
                k &= nums[i];
            }
        }
        return k == -1 ? 0 : k;
    }
    public static void main(String[] args){
        int[] nums = {0,3,2,1};
        System.out.println(sortPermutation(nums));
    }
}
