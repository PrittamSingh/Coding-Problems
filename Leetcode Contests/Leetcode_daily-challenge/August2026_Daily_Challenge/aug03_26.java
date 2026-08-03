public class aug03_26 {
    public static String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        int[] dp = new int[n + 1];
        dp[n] = 0;
        for(int i = n - 1 ; i >= 0 ; i--){
            int sum = 0;
            dp[i] = Integer.MIN_VALUE;
            for(int j = i ; j < Math.min(n, i + 3) ; j++){
                sum += stoneValue[j];
                dp[i] = Math.max(dp[i], sum - dp[j + 1]);
            }
        }
        if(dp[0] > 0){
            return "Alice";
        }
        else if(dp[0] < 0){
            return "Bob";
        }
        else{
            return "Tie";
        }
    }
    public static void main(String[] args) {
        int[] stoneValue = {1, 2, 3, 7};
        System.out.println(stoneGameIII(stoneValue));
    }
}
