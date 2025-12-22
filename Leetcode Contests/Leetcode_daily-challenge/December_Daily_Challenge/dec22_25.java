public class dec22_25 {
    static Integer dp[][];
    public static int minDeletionSize(String[] strs) {
        int n = strs.length; int m = strs[0].length();
        dp = new Integer[m+1][m];
        int maxKeep = solve(strs, n, m, -1, 0);
        return m - maxKeep;
    }
    public static int solve(String strs[], int n, int m, int prev, int curr){
        if(curr == m) return 0;
        if(dp[prev+1][curr] != null) return dp[prev+1][curr];
        int include = 0;
        if(prev == -1 || compare(strs, prev, curr, n)){
            include = 1 + solve(strs, n, m, curr, curr+1);
        }
        int exclude = solve(strs, n, m, prev, curr+1);
        return dp[prev+1][curr] = Math.max(include, exclude);
    }
    public static boolean compare(String strs[], int prev, int curr, int n){
        for(int i=0; i<n; i++){
            if(strs[i].charAt(prev) > strs[i].charAt(curr)){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        String[] strs = {"babca","bbazb"};
        System.out.println(minDeletionSize(strs));
    }
}
