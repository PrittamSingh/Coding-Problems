public class april08_26 {
    public static int xorAfterQueries(int[] nums, int[][] queries) {
        int MOD = 1000000007;
        for(int[] query : queries){
            int l = query[0];
            int r = query[1];
            int k = query[2];
            int v = query[3];
            while(l <= r){
                nums[l] = (int)(1L * nums[l] * v % MOD);
                l += k;
            }
        }
        long xor = (long)nums[0];
        for(int i = 1 ; i < nums.length ; i++){
            xor ^= nums[i];
        }
        return (int)xor;
    }
    public static void main(String[] args) {
        int[] nums = {1,1,1};
        int[][] queries = {{0,2,1,4}};
        System.out.println(xorAfterQueries(nums, queries));
    }
}
