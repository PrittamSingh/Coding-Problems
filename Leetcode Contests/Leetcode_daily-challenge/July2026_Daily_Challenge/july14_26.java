public class july14_26 {
    // int[][][] t;
    // int MOD = 1000000007;
    // public int subsequencePairCount(int[] nums) {
    //     t = new int[201][201][201];
    //     for(int[][] a : t){
    //         for(int[] b : a){
    //             Arrays.fill(b, -1);
    //         }
    //     }
    //     return solve(nums, 0, 0, 0);
    // }
    // public int solve(int[] nums, int i, int first, int second){
    //     if(i == nums.length){
    //         boolean bothNonEmpty = (first != 0 && second != 0) ? true : false;
    //         boolean gcdsMatch = (first == second) ? true : false;
    //         if(bothNonEmpty && gcdsMatch){
    //             return 1;
    //         }
    //         return 0;
    //     }
    //     if(t[i][first][second] != -1){
    //         return t[i][first][second];
    //     }
    //     int skip = solve(nums, i + 1, first, second);
    //     int take1 = solve(nums, i + 1, gcd(first, nums[i]), second);
    //     int take2 = solve(nums, i + 1, first, gcd(second, nums[i]));
    //     return t[i][first][second] = (int)((0L + skip + take1 + take2) % MOD);
    // }
    // private int gcd(int a, int b) {
    //     return b == 0 ? a : gcd(b, a % b);
    // }
    // public int gcd(int a, int b){
    //     while(b != 0){
    //         int temp = b;
    //         b = a % b;
    //         a = temp;
    //     }
    //     return a;
    // }


    // BOTTOM UP
//     int MOD = 1000000007;
//     public int subsequencePairCount(int[] nums) {
//         int n = nums.length;
//         int maxEle = -1;
//         for(int x : nums){
//             maxEle = Math.max(maxEle, x);
//         }
//         int[][][] dp = new int[n + 1][maxEle + 1][maxEle + 1];
//         for(int first = 0 ; first <= maxEle ; first++){
//             for(int second = 0 ; second <= maxEle ; second++){
//                 boolean bothNonEmpty = (first != 0 && second != 0);
//                 boolean gcdsMatch    = (first == second);
//                 dp[n][first][second] = (bothNonEmpty && gcdsMatch) ? 1 : 0;
//             }
//         }
//         for(int i = n - 1 ; i >= 0 ; i--){
//             for(int first = maxEle ; first >= 0 ; first--){
//                 for(int second = maxEle ; second >= 0 ; second--){
//                     int skip  = dp[i + 1][first][second];
//                     int take1 = dp[i + 1][gcd(first, nums[i])][second];
//                     int take2 = dp[i + 1][first][gcd(second, nums[i])];
//                     dp[i][first][second] = (int)((0L + skip + take1 + take2) % MOD);
//                 }
//             }
//         }
//         return dp[0][0][0];
//     }
//     private int gcd(int a, int b) {
//         return b == 0 ? a : gcd(b, a % b);
//     }



    // IMPROVED BOTTOM UP
    static int MOD = 1000000007;
    public static int subsequencePairCount(int[] nums) {
        int n = nums.length;
        int maxEle = -1;
        for(int x : nums){
            maxEle = Math.max(maxEle, x);
        }
        int[][] prev = new int[maxEle + 1][maxEle + 1];
        for(int first = 0 ; first <= maxEle ; first++){
            for(int second = 0 ; second <= maxEle ; second++){
                boolean bothNonEmpty = (first != 0 && second != 0);
                boolean gcdsMatch    = (first == second);
                prev[first][second] = (bothNonEmpty && gcdsMatch) ? 1 : 0;
            }
        }
        for(int i = n - 1 ; i >= 0 ; i--){
            int[][] curr = new int[maxEle + 1][maxEle + 1];
            for(int first = maxEle ; first >= 0 ; first--){
                for(int second = maxEle ; second >= 0 ; second--){
                    int skip  = prev[first][second];
                    int take1 = prev[gcd(first, nums[i])][second];
                    int take2 = prev[first][gcd(second, nums[i])];
                    curr[first][second] = (int)((0L + skip + take1 + take2) % MOD);
                }
            }
            prev = curr;
        }
        return prev[0][0];
    }
    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
    public static void main(String[] args) {
        int[]  nums = {1,2,3,4};
        System.out.println(subsequencePairCount(nums));
    }
}
