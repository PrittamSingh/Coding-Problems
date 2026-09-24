public class sept24_26 {
    public static int smallestIndex(int[] nums) {
        for(int i = 0 ; i < nums.length ; i++){
            int num = nums[i];
            int sum = 0;
            while(num > 0){
                int d = num % 10;
                sum += d;
                num /= 10;
            }
            if(sum == i){
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[]  nums = {1,3,2};
        System.out.println(smallestIndex(nums));
    }
}
