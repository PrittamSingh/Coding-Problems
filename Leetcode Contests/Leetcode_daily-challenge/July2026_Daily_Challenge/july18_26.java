public class july18_26 {
    public static int findGCD(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int num : nums){
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        while(min != 0){
            int temp = min;
            min = max % min;
            max = temp;
        }
        return max;
    }
    public static void main(String[] args) {
        int[] nums = {7,5,6,8,3};
        System.out.println(findGCD(nums));
    }
}
