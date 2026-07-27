public class july27_26 {
    public static int maxProduct(int[] nums) {
        // Arrays.sort(nums);
        // int n = nums.length;
        // return (nums[n - 1] - 1) * (nums[n - 2] - 1);

        int largest = 0;
        int sndLargest = 0;
        for(int num : nums){
            if(num > largest){
                sndLargest = largest;
                largest = num;
            }
            else if(num > sndLargest){
                sndLargest = num;
            }
        }
        return (largest - 1) * (sndLargest - 1);
    }
    public static void main(String[] args) {
        int[] nums = {3,4,5,2};
        System.out.println(maxProduct(nums));
    }
}
