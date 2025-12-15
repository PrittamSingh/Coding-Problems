public class dec15_25 {
    public static long getDescentPeriods(int[] prices) {
        long ans = 0;
        long count = 1;
        for(int i = 1 ; i < prices.length ; i++){
            if(prices[i] - prices[i - 1] == -1){
                count++;
            }
            else{
                ans += (count * (count + 1)) / 2;
                count = 1;
            }
        }
        ans += (count * (count + 1)) / 2;
        return ans;
    }
    public static void main(String[] args) {
        int[] prices1 = {3,2,1,4};
        int[] prices2 = {8,6,7,7};
        int[] prices3 = {1};
        System.out.println(getDescentPeriods(prices1) + " " + getDescentPeriods(prices2) + " " + getDescentPeriods(prices3));
    }
}
