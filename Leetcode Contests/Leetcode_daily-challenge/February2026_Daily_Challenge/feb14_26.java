public class feb14_26 {
    public static double champagneTower(int poured, int rows, int glass) {
        double dp[][] = new double[101][101];

        dp[0][0] = poured;

        for(int i=0; i<=rows; i++) {
            for(int j=0; j<=i; j++ ) {
                double extra = (dp[i][j]-1)/2.0;
                if(extra > 0) {
                    dp[i+1][j] += extra;
                    dp[i+1][j+1] += extra;
                }
            }
        }
        return Math.min(1, dp[rows][glass]);
        
    }
    public static void main(String[] args) {
        int poured = 1, query_row = 1, query_glass = 1;
        int poured2 = 2, query_row2 = 1, query_glass2 = 1;
        System.out.println(champagneTower(poured, query_row, query_glass) + " " + champagneTower(poured2, query_row2, query_glass2));
    }
}
