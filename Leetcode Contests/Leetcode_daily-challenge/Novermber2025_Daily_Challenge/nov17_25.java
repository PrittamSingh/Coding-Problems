public class nov17_25 {
    public static boolean kLengthApart(int[] nums, int k) {
        // Approach-1 Brute Force Approach
        // int n = nums.length;
        // for(int i = 0 ; i < n ; i++){
        //     if(nums[i] == 1){
        //         for(int j = i + 1 ; j < n ; j++){
        //             if(nums[j] == 1){
        //                 if((j - i - 1) < k) return false;
        //                 break;
        //             }
        //         }
        //     }
        // }
        // return true;

        // Approach-2 Better Approach
        // List<Integer> ones = new ArrayList<>();
        // for(int i = 0 ; i < nums.length ; i++){
        //     if(nums[i] == 1) ones.add(i);
        // }
        // for(int i = 1 ; i < ones.size() ; i++){
        //     if(ones.get(i) - ones.get(i - 1) - 1 < k) return false;
        // }
        // return true;

        // Approach-3 Most Optimal Solution
        int prev = -1;
        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] == 1){
                if(prev != -1 && (i - prev - 1) < k){
                    return false;
                }
                prev = i;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int[] nums1 = {1,0,0,0,1,0,0,1} , nums2 = {1,0,0,1,0,1};
        int k = 2 ;
        System.out.println(kLengthApart(nums1,k) + " " + kLengthApart(nums2,k));
    }
}
