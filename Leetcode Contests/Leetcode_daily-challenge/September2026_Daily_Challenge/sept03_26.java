public class sept03_26 {
    public static boolean uniformArray(int[] nums1) {
        int mini = Integer.MAX_VALUE;
        boolean odd = false;
        boolean even = false;
        for(int num : nums1){
            if(num % 2 == 0){
                even = true;
            }
            else{
                odd = true;
            }
            mini = Math.min(mini, num);
        }
        if(!odd || !even){
            return true;
        }
        if(mini % 2 == 0){
            return false;
        }
        return true;
    }
    public static void main(String[] args) {
        int[] nums1 = {1,4,7};
        System.out.println(uniformArray(nums1));
    }
}
