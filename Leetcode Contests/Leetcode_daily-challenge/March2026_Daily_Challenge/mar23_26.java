public class mar23_26 {
    static int m, n;
    static final int MOD = 1000000007;
    static Pair<Long, Long>[][] t;
    static class Pair<K, V> {
        K key;
        V value;
        Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }
        public K getKey() {
            return key;
        }
        public V getValue() {
            return value;
        }
    }

    public static Pair<Long, Long> solve(int i, int j, int[][] grid) {
        if (i == m - 1 && j == n - 1) {
            return new Pair<>((long) grid[i][j], (long) grid[i][j]);
        }
        if (t[i][j] != null) {
            return t[i][j];
        }

        long maxVal = Long.MIN_VALUE;
        long minVal = Long.MAX_VALUE;

        if (i + 1 < m) {
            Pair<Long, Long> down = solve(i + 1, j, grid);

            long a = (long) grid[i][j] * down.getKey();
            long b = (long) grid[i][j] * down.getValue();

            maxVal = Math.max(maxVal, Math.max(a, b));
            minVal = Math.min(minVal, Math.min(a, b));
        }
        if (j + 1 < n) {
            Pair<Long, Long> right = solve(i, j + 1, grid);

            long a = (long) grid[i][j] * right.getKey();
            long b = (long) grid[i][j] * right.getValue();

            maxVal = Math.max(maxVal, Math.max(a, b));
            minVal = Math.min(minVal, Math.min(a, b));
        }

        t[i][j] = new Pair<>(maxVal, minVal);
        return t[i][j];
    }

    public static int maxProductPath(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        t = new Pair[m][n];

        Pair<Long, Long> result = solve(0, 0, grid);

        if (result.getKey() < 0) return -1;

        return (int) (result.getKey() % MOD);
    }
    public static void main(String[] args) {
        int[][] grid = {
            {-1, -2, -3},
            {-2, -3, -3},
            {-3, -3, -2}
        };

        System.out.println(maxProductPath(grid));
    }
}