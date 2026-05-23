public class may23_26 {
    public static boolean check(int[] nums) {
        // int n = nums.length;
        // if(n == 1){
        //     return true;
        // }
        // for(int i = 0 ; i < n ; i++){
        //     int idx = i;
        //     for(int j = 0 ; j < n - 1 ; j++){
        //         if(nums[idx] > nums[(idx + 1) % n]){
        //             break;
        //         }
        //         idx = (idx + 1) % n;
        //         if(idx == ((i + n) - 1) % n){
        //             return true;
        //         }
        //     }
        // }
        // return false;


        // O(n)
        int n = nums.length;
        int count = 0;
        for(int i = 0 ; i < n ; i++){
            if(nums[i] > nums[(i + 1) % n]){
                count++;
            }
            if(count > 1) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        int[] nums = {3,4,5,1,2};
        int[] nums2 = {2,1,3,4};
        System.out.println(check(nums) + " " + check(nums2));
    }
}
