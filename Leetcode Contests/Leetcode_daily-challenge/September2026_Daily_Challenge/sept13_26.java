public class sept13_26 {
    public static int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;
        int maxOverlap = 0;
        for(int row_off = -n + 1 ; row_off < n ; row_off++){
            for(int col_off = -n + 1 ; col_off < n ; col_off++){
                int count = countOverlaps(img1, img2, row_off, col_off);
                maxOverlap = Math.max(maxOverlap, count);
            }
        }
        return maxOverlap;
    }
    public static int countOverlaps(int[][] img1, int[][] img2, int row_off, int col_off){
        int n = img1.length;
        int count = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                int img2_i = i + row_off;
                int img2_j = j + col_off;
                if(img2_i < 0 || img2_i >= n || img2_j < 0 || img2_j >= n){
                    continue;
                }
                if(img1[i][j] == 1 && img2[img2_i][img2_j] == 1){
                    count++;
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int[][] img1 = {{1,1,0},{0,1,0},{0,1,0}}, img2 = {{0,0,0},{0,1,1},{0,0,1}};
        System.out.println(largestOverlap(img1, img2));
    }
}
