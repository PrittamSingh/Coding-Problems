public class may16_26 {
    public static int findMin(int[] nums) {
        // BINARY SEARCH APPROACH
        int n = nums.length;
        int l = 0;
        int r = n - 1;
        while(l < r){
            int mid = l + (r - l) / 2;
            if(nums[mid] > nums[r]){
                l = mid + 1;
            }
            else if(nums[mid] < nums[r]){
                r = mid;
            }
            else{
                r--;
            }
        }
        return nums[l];




        // BRUTE FORCE APPROACH
        // int min = Integer.MAX_VALUE;
        // for(int num : nums){
        //     min = Math.min(min, num);
        // }
        // return min;
    }
    public static void main(String[] args) {
        int[] nums = {2,2,2,0,1};
        int[] nums2 = {1,3,5};
        System.out.println(findMin(nums) + " " + findMin(nums2));
    }
}
