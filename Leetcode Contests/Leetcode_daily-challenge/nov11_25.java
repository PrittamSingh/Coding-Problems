public class nov11_25 {
    public static int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for(String s : strs){
            int zeros = 0;
            int ones = 0;
            for(char c : s.toCharArray()){
                if(c == '0') zeros++;
                else ones++;
            }
            for(int i = m ; i >= zeros ; i--){
                for(int j = n ; j >= ones ; j--){
                    dp[i][j] = Math.max(dp[i][j] , dp[i - zeros][j - ones] + 1);
                }
            }
        }
        return dp[m][n];
    }
    public static void main(String[] args) {
        String[] strs = {"10","0001","111001","1","0"};
        int m = 5;
        int n = 3;
        System.out.println(findMaxForm(strs , m , n));
        String[] strs1 = {"10","0","1"};
        int m1 = 1;
        int n1= 1;
        System.out.println(findMaxForm(strs1, m1, n1));
    }
}
