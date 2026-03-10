public class mar10_26 {
    //BOTTOM-UP APPROACH
    static int M = 1000000007;
    public static int numberOfStableArrays(int zero, int one, int limit) {
        int[][][] t = new int[zero + 1][one + 1][2];
        for (int i = 1; i <= Math.min(zero, limit); i++)
            t[i][0][0] = 1;

        for (int j = 1; j <= Math.min(one, limit); j++)
            t[0][j][1] = 1;

        for (int i = 0; i <= zero; i++) {
            for (int j = 0; j <= one; j++) {

                if(i == 0 || j == 0)
                    continue;
                int val0 = (t[i-1][j][0] + t[i-1][j][1]) % M;
                if (i-1 >= limit)
                    val0 = (val0 - t[i-1-limit][j][1] + M) % M;
                t[i][j][0] = val0;
                int val1 = (t[i][j-1][0] + t[i][j-1][1]) % M;

                if (j-1 >= limit)
                    val1 = (val1 - t[i][j-1-limit][0] + M) % M;

                t[i][j][1] = val1;
            }
        }

        return (t[zero][one][0] + t[zero][one][1]) % M;
    }




    //RECURSION + MEMOIZATION
    // int M = (int)1e9 + 7;
    // int[][][] t;
    // public static int numberOfStableArrays(int zero, int one, int limit) {
    //     t = new int[zero + 1][one + 1][2];
    //     for (int i = 0; i <= zero; i++) {
    //         for (int j = 0; j <= one; j++) {
    //             Arrays.fill(t[i][j], -1);
    //         }
    //     }
    //     return (solve(zero, one, 0, limit) + solve(zero, one, 1, limit)) % M;
    // }
    // static int solve(int i, int j, int last, int limit) {
    //     if (i == 0 && j == 0)
    //         return 0;
    //     if (j == 0) {
    //         if (last == 1) return 0;
    //         return (i <= limit) ? 1 : 0;
    //     }
    //     if (i == 0) {
    //         if (last == 0) return 0;
    //         return (j <= limit) ? 1 : 0;
    //     }
    //     if (t[i][j][last] != -1)
    //         return t[i][j][last];
    //     int result = 0;
    //     if (last == 0) {
    //         result = (solve(i-1, j, 0, limit) + solve(i-1, j, 1, limit)) % M;
    //         if (i-1 >= limit)
    //             result = (result - solve(i-1-limit, j, 1, limit) + M) % M;
    //     } else {
    //         result = (solve(i, j-1, 0, limit) + solve(i, j-1, 1, limit)) % M;

    //         if (j-1 >= limit)
    //             result = (result - solve(i, j-1-limit, 0, limit) + M) % M;
    //     }
    //     return t[i][j][last] = result;
    // }
    public static void main(String[] args) {
        int zero = 1, one = 1, limit = 2;
        System.out.println(numberOfStableArrays(zero, one, limit));
    }
}
