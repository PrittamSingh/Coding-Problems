public class july26_26 {
    public static int maximumProduct(int[] nums) {
        // int n = nums.length;
        // if(n == 3){
        //     return nums[0] * nums[1] * nums[2];
        // }
        // Arrays.sort(nums);
        // int prod1 = nums[0] * nums[1];
        // int prod2 = nums[n - 1] * nums[n - 2];
        // int prod3 = prod1 * nums[n - 1];
        // int prod4 = prod2 * nums[n - 3];
        // return Math.max(prod3, prod4);




        int n = nums.length;
        int negMax = Integer.MAX_VALUE;
        int negSndMax = Integer.MAX_VALUE;
        int largest = Integer.MIN_VALUE;
        int sndLargest = Integer.MIN_VALUE;
        int thirdLargest = Integer.MIN_VALUE;
        for(int i = 0 ; i < n ; i++){
            if(nums[i] > largest){
                thirdLargest = sndLargest;
                sndLargest = largest;
                largest = nums[i];
            }
            else if(nums[i] > sndLargest){
                thirdLargest = sndLargest;
                sndLargest = nums[i];
            }
            else if(nums[i] > thirdLargest){
                thirdLargest = nums[i];
            }
            if(nums[i] < 0 && nums[i] < negMax){
                negSndMax = negMax;
                negMax = nums[i];
            }
            else if(nums[i] < 0 && nums[i] < negSndMax){
                negSndMax = nums[i];
            }
        }
        int prod1 = largest * sndLargest * thirdLargest;
        if(negMax < 0 && negSndMax < 0){
            int prod2 = negMax * negSndMax * largest;
            return Math.max(prod1, prod2);
        }
        return prod1;
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        int[] nums2 = {1,2,3,4};
        int[] nums3 = {-1,-2,-3};
        System.out.println(maximumProduct(nums) + " " + maximumProduct(nums2) + " " + maximumProduct(nums3));
    }
}
