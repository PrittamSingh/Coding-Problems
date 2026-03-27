public class mar27_26 {
    public static boolean areSimilar(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        k = k % n;
        if (k == 0) return true;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int currIdx = j;
                int finalIdx;
                if (i % 2 == 0) {
                    finalIdx = (j + k) % n;
                } else {
                    finalIdx = (j - k + n) % n;
                }
                if (mat[i][currIdx] != mat[i][finalIdx]) {
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int[][] mat = {{1,2,3},{4,5,6},{7,8,9}};
        int k = 4;
        int[][] mat2 = {{1,2,1,2},{5,5,5,5},{6,3,6,3}};
        int k2 = 2;
        System.out.println(areSimilar(mat, k) + " " + areSimilar(mat2, k2));
    }
}
