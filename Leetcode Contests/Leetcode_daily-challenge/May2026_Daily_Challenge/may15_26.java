public class may15_26 {
    public static int findMin(int[] nums) {
        // BINARY SEARCH APPROACH - O(log N)
        int n = nums.length;
        int l = 0;
        int r = n - 1;
        while(l < r){
            int mid = l + (r - l) / 2;
            if(nums[mid] > nums[r]){
                l = mid + 1;
            }
            else{
                r = mid;
            }
        }
        return nums[l];



        //BRUTE FORCE APPROACH - O(N)
        // int n = nums.length;
        // int res = Integer.MAX_VALUE;
        // for(int i = 0 ; i < n ; i++){
        //     res = Math.min(res, nums[i]);
        // }
        // return res;
    }
    public static void main(String[] args) {
        int[] nums = {3,4,5,1,2};
        int[] nums2 = {4,5,6,7,0,1,2};
        int[] nums3 = {11,13,15,17};
        System.out.println(findMin(nums) + " " + findMin(nums2) + " " + findMin(nums3));
    }
}
