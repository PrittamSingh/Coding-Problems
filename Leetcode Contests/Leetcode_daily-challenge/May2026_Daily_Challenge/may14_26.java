public class may14_26 {
    public static boolean isGood(int[] nums) {
        int[] freq = new int[200 + 1];
        int maxEle = Integer.MIN_VALUE;
        for(int num : nums){
            freq[num]++;
            maxEle = Math.max(maxEle, num);
        }
        for(int i = 1 ; i < maxEle ; i++){
            if(freq[i] != 1){
                return false;
            }
        }
        if(freq[maxEle] != 2){
            return false;
        }
        return true;
    }
    public static void main(String[] args) {
        int[] nums = {2, 1, 3};
        int[] nums2 = {1, 3, 3, 2};
        int[] nums3 = {3, 4, 4, 1, 2, 1};
        System.out.println(isGood(nums) + " " + isGood(nums2) + " " + isGood(nums3));
    }
}
