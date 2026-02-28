public class feb28_26 {
    static final int MOD = 1_000_000_007;
    static long fast(long a, long b) {
        long ans = 1;
        while (b > 0) {
            if ((b & 1) == 1) {
                ans = (ans * a) % MOD;
            }
            a = (a * a) % MOD;
            b >>= 1;
        }
        return ans;
    }
    static int solve(int n) {
        for (int i = 31; i >= 0; i--) {
            if (((1 << i) & n) != 0) {
                return i + 1;
            }
        }
        return -1;
    }
    public static int concatenatedBinary(int n) {
        long ans = n;
        int bits = solve(n);
        for (int i = n - 1; i >= 1; i--) {
            long val = fast(2L, bits);
            ans = (ans + (i * val) % MOD) % MOD;
            bits += solve(i);
        }
        return (int) ans;
    }
    public static void main(String[] args) {
        int n = 1;
        int n1 = 3;
        System.out.println(concatenatedBinary(n) + " " + concatenatedBinary(n1));
    }
}
