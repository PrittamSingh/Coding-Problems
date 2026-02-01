public class feb01_26 {
    public static int minimumCost(int[] nums) {
        int cost = nums[0];
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        for(int i=1; i<nums.length; i++){
            int curr = nums[i];
            if(curr < min1){
                min2 = min1;
                min1 = curr;
            } else if(curr < min2){
                min2 = curr;
            }
        }
        cost += min1;
        cost += min2;
        return cost;
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3,12};
        int[] nums1 = {5,4,3};
        System.out.println(minimumCost(nums) + " " + minimumCost(nums1));
    }
}
