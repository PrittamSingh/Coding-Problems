public class dec05_25 {
    public static int countPartitions(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];
        prefix[0] = nums[0];
        for(int i = 1 ; i < n ; i++){
            prefix[i] = prefix[i - 1] + nums[i];
        }
        int count = 0;
        for(int i = 0 ; i < n - 1 ; i++){
            int leftSum = prefix[i];
            int rightSum = prefix[n - 1] - prefix[i];
            if((rightSum - leftSum) % 2 == 0){
                count++;
            }
            // if((leftSum % 2 == 0) && (rightSum % 2 == 0)){
            //     count++;
            // }
            // else if(leftSum % 2 == 1 && rightSum % 2 == 1){
            //     count++;
            // }
        }
        return count;
    }
    public static void main(String[] args) {
        int[] nums = {10,10,3,7,6};
        int[] nums2 = {1,2,2};
        int[] nums3 = {2,4,6,8};
        System.out.println(countPartitions(nums) + " " + countPartitions(nums2) + " " + countPartitions(nums3));
    }
}
