public class nov19_25 {
    public static int findFinalValue(int[] nums, int original) {
        //Approach-1 Using Hashing T.C.-O(N) S.C.-O(N)
        // Set<Integer> seen = new HashSet<>();
        // for(int num : nums){
        //     seen.add(num);
        // }
        // while(seen.contains(original)){
        //     original *= 2;
        // }
        // return original;

        // Approach-2 Using Sorting
        // Arrays.sort(nums);
        // for(int num : nums){
        //     if(num == original){
        //         original *= 2;
        //     }
        // }
        // return original;

        // Approach-3 As question said repeated process
        boolean found = true;
        while(found){
            found = false;
            for(int num : nums){
                if(num == original){
                    original *= 2;
                    found = true;
                    break;
                }
            }
        }
        return original;
    }
    public static void main(String[] args) {
        int[] nums1 = {5,3,6,1,12};
        int original1 = 3;
        System.out.println(findFinalValue(nums1, original1));
        int[] nums2 = {2,7,9};
        int original2 = 4;
        System.out.println(findFinalValue(nums2, original2));
    }
}
