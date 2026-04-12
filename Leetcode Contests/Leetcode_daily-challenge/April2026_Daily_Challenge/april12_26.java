public class april12_26 {
    public static int minimumDistance(String word) {
        int n = word.length();
        int[][][] dp = new int[n + 1][27][27];
        for(int i = n - 1; i >= 0; i--){
            int curr = word.charAt(i) - 'A';
            for(int f1 = 0; f1 < 27; f1++){
                for(int f2 = 0; f2 < 27; f2++){
                    if(f1 == 26 && f2 == 26){
                        dp[i][f1][f2] = dp[i+1][curr][f2];
                        continue;
                    }
                    if(f2 == 26){
                        int moveF2 = dp[i+1][f1][curr];
                        int moveF1 = getDistance(f1, curr) + dp[i+1][curr][f2];
                        dp[i][f1][f2] = Math.min(moveF1, moveF2);
                        continue;
                    }
                    int moveF1 = getDistance(f1, curr) + dp[i+1][curr][f2];
                    int moveF2 = getDistance(f2, curr) + dp[i+1][f1][curr];
                    dp[i][f1][f2] = Math.min(moveF1, moveF2);
                }
            }
        }
        return dp[0][26][26];
    }
    public static int[] getCoord(int pos) {
        return new int[]{pos/6, pos%6};
    }
    public static int getDistance(int pos1, int pos2) {
        if (pos1 == 26 || pos2 == 26) return 0;
        int[] c1 = getCoord(pos1);
        int[] c2 = getCoord(pos2);
        int x1 = c1[0], y1 = c1[1];
        int x2 = c2[0], y2 = c2[1];
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
    public static void main(String[] args) {
        String word = "CAKE";
        String word2 = "HAPPY";
        System.out.println(minimumDistance(word) + " " + minimumDistance(word2));
    }





    // int[][][] dp = new int[301][27][27];
    // public int minimumDistance(String word) {
    //     for (int i = 0; i < 301; i++){
    //         for (int j = 0; j < 27; j++){
    //             Arrays.fill(dp[i][j], -1);
    //         }
    //     }
    //     return solve(word, 0, 26, 26);
    // }
    // public int solve(String word, int i, int f1, int f2) {
    //     if (i >= word.length()){
    //         return 0;
    //     }
    //     int curr = word.charAt(i) - 'A';
    //     if(dp[i][f1][f2] != -1){
    //         return dp[i][f1][f2];
    //     }
    //     if(f1 == 26 && f2 == 26){
    //         return dp[i][f1][f2] = solve(word, i + 1, curr, f2);
    //     }
    //     if(f2 == 26){
    //         int moveF2 = solve(word, i + 1, f1, curr);
    //         int moveF1 = getDistance(f1, curr) + solve(word, i + 1, curr, f2);
    //         return dp[i][f1][f2] = Math.min(moveF1, moveF2);
    //     }
    //     int moveF1 = getDistance(f1, curr) + solve(word, i + 1, curr, f2);
    //     int moveF2 = getDistance(f2, curr) + solve(word, i + 1, f1, curr);
    //     return dp[i][f1][f2] = Math.min(moveF1, moveF2);
    // }
    // public int[] getCoord(int pos) {
    //     return new int[]{pos / 6, pos % 6};
    // }
    // public int getDistance(int pos1, int pos2) {
    //     int[] c1 = getCoord(pos1);
    //     int[] c2 = getCoord(pos2);
    //     return Math.abs(c1[0] - c2[0]) + Math.abs(c1[1] - c2[1]);
    // }





    // int[][][][][] dp = new int[301][7][7][7][7];
    // public int minimumDistance(String word) {
    //     for (int i = 0; i < 301; i++){
    //         for (int a = 0; a < 7; a++){
    //             for (int b = 0; b < 7; b++){
    //                 for (int c = 0; c < 7; c++){
    //                     Arrays.fill(dp[i][a][b][c], -1);
    //                 }
    //             }
    //         }
    //     }
    //     return solve(word, 0, -1, -1, -1, -1);
    // }
    // public int solve(String word, int i, int x1, int y1, int x2, int y2) {
    //     if (i == word.length()){
    //         return 0;
    //     }
    //     if (dp[i][x1 + 1][y1 + 1][x2 + 1][y2 + 1] != -1){
    //         return dp[i][x1 + 1][y1 + 1][x2 + 1][y2 + 1];
    //     }
    //     int[] coord = getCoordinate(word.charAt(i));
    //     int x = coord[0], y = coord[1];

    //     if (x1 == -1 && y1 == -1 && x2 == -1 && y2 == -1){
    //         return dp[i][x1 + 1][y1 + 1][x2 + 1][y2 + 1] = solve(word, i + 1, x, y, x2, y2);
    //     }
    //     if (x2 == -1 && y2 == -1){
    //         int moveF2 = solve(word, i + 1, x1, y1, x, y);
    //         int moveF1 = solve(word, i + 1, x, y, x2, y2) + getDistance(x1, y1, x, y);
    //         return dp[i][x1 + 1][y1 + 1][x2 + 1][y2 + 1] = Math.min(moveF1, moveF2);
    //     }
    //     int moveF1 = solve(word, i + 1, x, y, x2, y2) + getDistance(x1, y1, x, y);
    //     int moveF2 = solve(word, i + 1, x1, y1, x, y) + getDistance(x2, y2, x, y);

    //     return dp[i][x1 + 1][y1 + 1][x2 + 1][y2 + 1] = Math.min(moveF1, moveF2);
    // }
    // public int[] getCoordinate(char ch) {
    //     int pos = ch - 'A';
    //     return new int[]{pos / 6, pos % 6};
    // }
    // public int getDistance(int x1, int y1, int x2, int y2) {
    //     return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    // }
}
