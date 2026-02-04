public class feb04_26 {
    public static long maxSumTrionic(int[] nums) {

        long NEG_INF = (long) -1e18;

        long ans = NEG_INF;

        long prev = nums[0];
        int n = nums.length;

        long a = NEG_INF;
        long b = NEG_INF;
        long c = NEG_INF;

        for (int i = 1; i < n; i++) {
            long newA = NEG_INF;
            long newB = NEG_INF;
            long newC = NEG_INF;

            long curr = nums[i];

            if (curr > prev) {
                newA = Math.max(a, prev) + curr;
                newC = Math.max(b, c) + curr;
            } else if (curr < prev) {
                newB = Math.max(b, a) + curr;
            }

            a = newA;
            b = newB;
            c = newC;

            ans = Math.max(ans, c);
            prev = curr;
        }

        return ans;
    }
    public static void main(String[] args) {
        int[] nums = {0,-2,-1,-3,0,2,-1};
        System.out.println(maxSumTrionic(nums));
    }
}
