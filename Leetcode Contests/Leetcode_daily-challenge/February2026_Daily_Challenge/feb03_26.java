public class feb03_26 {
    public static boolean isTrionic(int[] nums) {
        int n = nums.length;
        int i = 1;
        while(i < n && nums[i] > nums[i - 1]) i++;
        if(i == 1 || i == n) return false;
        int p = i;
        while(i < n && nums[i] < nums[i - 1]) i++;
        if(i == p || i == n) return false;
        int q = i;
        while(i < n && nums[i] > nums[i - 1]) i++;

        return i == n && q < n;
    }
    public static void main(String[] args) {
        int[] nums = {1,3,5,4,2,6};
        int[] nums2 = {2,1,3};
        System.out.println(isTrionic(nums) + " " + isTrionic(nums2));
    }
}
