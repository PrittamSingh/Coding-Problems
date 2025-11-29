public class nov29_25 {
    public static int minOperations(int[] nums, int k) {
        // long sum = 0;
        // for(int num : nums){
        //     sum += num;
        // }
        // int operation = (int)(sum % k);
        // return operation;

        int sum = 0;
        for(int i = 0 ; i < nums.length ; i++){
            sum += nums[i];
        }
        return sum % k;
    }
    public static void main(String[] args) {
        int[] nums = {3,9,7} , nums2 = {4,1,3} , nums3 = {3,2};
        int k = 5 , k2 = 4 , k3 = 6;
        System.out.println(minOperations(nums, k) + " " + minOperations(nums2, k2) + " " + minOperations(nums3, k3));

    }
}
