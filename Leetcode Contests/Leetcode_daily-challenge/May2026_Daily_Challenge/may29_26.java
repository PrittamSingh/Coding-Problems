public class may29_26 {
    public static int minElement(int[] nums) {
        // int minEle = Integer.MAX_VALUE;
        // for(int num : nums){
        //     int newNum = 0;
        //     while(num > 0){
        //         int d = num % 10;
        //         newNum += d;
        //         num /= 10;
        //     }
        //     minEle = Math.min(minEle, newNum);
        // }
        // return minEle;



        int minEle = Integer.MAX_VALUE;
        for(int num : nums){
            int newNum = 0;
            String s = Integer.toString(num);
            for(char ch : s.toCharArray()){
                newNum += ch - '0';
            }
            minEle = Math.min(minEle, newNum);
        }
        return minEle;
    }
    public static void main(String[] args) {
        int[] nums = {10, 12, 13, 14};
        int[] nums2 = {999,19,199};
        System.out.println(minElement(nums) + " " + minElement(nums2));
    }
}
