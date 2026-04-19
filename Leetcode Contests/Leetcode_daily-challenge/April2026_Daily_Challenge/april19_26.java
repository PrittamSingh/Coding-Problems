public class april19_26 {
    public static int maxDistance(int[] nums1, int[] nums2) {
        //BRUTE - FORCE
        // int m = nums1.length;
        // int n = nums2.length;
        // Map<int[], Integer> map = new HashMap<>();
        // for(int i = 0 ; i < m ; i++){
        //     if(i >= n){
        //         continue;
        //     }
        //     for(int j = i ; j < n ; j++){
        //         if(nums2[j] >= nums1[i]){
        //             int[] curr = new int[]{i, j};
        //             map.put(curr, map.getOrDefault(curr, 0) + 1);
        //         }
        //         else{
        //             break;
        //         }
        //     }
        // }
        // int minDist = 0;
        // for(int[] num : map.keySet()){
        //     minDist = Math.max(minDist, num[1] - num[0]);
        // }
        // return minDist;


        //TWO-POINTER APPROACH
        int i = 0;
        int j = 0;
        int n = nums1.length;
        int m = nums2.length;
        int maxDist = 0;
        while(i < n && j < m){
            if(nums1[i] <= nums2[j]){
                maxDist = Math.max(maxDist, j - i);
                j++;
            }
            else{
                i++;
                j++;
            }
        }
        return maxDist;
    }
    public static void main(String[] args) {
        int[] nums1 = {55,30,5,4,2}, nums2 = {100,20,10,10,5};
        System.out.println(maxDistance(nums1, nums2));
    }
}
