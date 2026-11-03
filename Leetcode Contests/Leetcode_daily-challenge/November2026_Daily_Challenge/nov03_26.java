public class nov03_26 {
    public static int minMoves(int[] nums) {
        int max = Integer.MIN_VALUE;
        int moves = 0;
        for(int num : nums){
            if(num > max){
                max = num;
            }
        }
        for(int num : nums){
            moves += max - num;
        }
        return moves;
    }
    public static void main(String[] args) {
        int[] nums = {2,1,3};
        System.out.println(minMoves(nums));
    }
}
