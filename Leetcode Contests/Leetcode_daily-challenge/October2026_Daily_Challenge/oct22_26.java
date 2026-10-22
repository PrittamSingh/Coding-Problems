public class oct22_26 {
    public static int minOperations(int[] nums) {
        int n = nums.length;
        int count_asc = 0;
        int count_des = 0;
        for(int i = 1 ; i < n ; i++){
            if(nums[i] == (nums[i - 1] + 1) % n){
                count_asc++;
            }
            if(nums[i - 1] == (nums[i] + 1) % n){
                count_des++;
            }
        }
        if(count_asc == n-1 && nums[0] == 0){
            return 0;
        }
        if(count_asc == n - 1){
            int leftRotation = n - nums[0];
            int rightRotation = 1 + (nums[n - 1] + 1) + 1;
            return Math.min(leftRotation, rightRotation);
        }
        if(count_des == n - 1){
            int leftRotation = n - nums[n - 1] + 1;
            int rightRotation = 1 + (nums[0] + 1) % n;
            return Math.min(leftRotation, rightRotation);
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] nums = {0,2,1};
        System.out.println(minOperations(nums));
    }
}
