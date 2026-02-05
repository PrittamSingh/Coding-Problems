public class feb05_26 {
    public static int[] constructTransformedArray(int[] nums) {
        int[] result = new int[nums.length];
        for(int i = 0 ;  i < nums.length ; i++){
            if(nums[i] > 0){
                int num = nums[i];
                result[i] = nums[(i + num) % nums.length];
            }
            else if(nums[i] < 0){
                int num = Math.abs(nums[i]);
                num = num % nums.length;
                result[i] = nums[(i - num + nums.length) % nums.length];
            }
            else{
                result[i] = nums[i];
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[] nums1 = {3,-2,1,1};
        int[] nums2 = {-1,4,-1};
        int[] result1 = constructTransformedArray(nums1);
        for(int i = 0 ; i < nums1.length ; i++){
            System.out.print(result1[i]+" ");
        }
        System.out.println();
        int[] result2 = constructTransformedArray(nums2);
        for(int i = 0 ; i < nums2.length ; i++){
            System.out.print(result2[i]+" ");
        }
        System.out.println();
    }
}
