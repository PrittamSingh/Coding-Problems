public class june09_26 {
     public static long maxTotalValue(int[] nums, int k) {
        // int n = nums.length;
        // List<Integer> list = new ArrayList<>();
        // for(int i = 0 ; i < n ; i++){
        //     int maxEle = nums[i];
        //     int minEle = nums[i];
        //     for(int j = 0 ; j < n ; j++){
        //         maxEle = Math.max(maxEle, nums[j]);
        //         minEle = Math.min(minEle, nums[j]);
        //         list.add(maxEle - minEle);
        //     }
        // }
        // Collections.sort(list, Collections.reverseOrder());
        // return (long)k * list.get(0);



        int n = nums.length;
        int maxEle = nums[0];
        int minEle = nums[0];
        for(int i = 1 ; i < n ; i++){
            maxEle = Math.max(maxEle, nums[i]);
            minEle = Math.min(minEle, nums[i]);
        }
        return (long)k * (maxEle - minEle);
    }
    public static void main(String[] args) {
        int[] nums = {4, 2, 5, 1};
        int k = 3;
        System.out.println(maxTotalValue(nums, k));
    }
}
