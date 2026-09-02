public class sept02_26 {
    public static boolean uniformArray(int[] nums1) {
        return true;
    }
    public static void main(String[] args) {
        int[] nums1 = {2,3};
        int[] nums2 = {2, 4, 6, 8}; //{2, 4, 6, 8}
        int[] nums3 = {3, 5, 7, 9}; //{3, 5, 7, 9}
        int[] nums4 = {2, 4, 6, 8, 1}; //{1, 3, 5, 7, 1}
        int[] nums5 = {2, 4, 11, 5, 8, 6}; //{-3, -1, 11, 5, 3, 1}
        System.out.println(uniformArray(nums1) + " " + uniformArray(nums2) + " " + uniformArray(nums3) + " " + uniformArray(nums4) + " " + uniformArray(nums5)); 
    }
}
