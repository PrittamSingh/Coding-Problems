public class nov27_26 {
    public static int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;
        int[] received = new int[n];
        for(int i = 0 ; i < n ; i++){
            int count = 0;
            for(int j = 0 ; j < n ; j++){
                if(i != j && items[j][0] % items[i][0] == 0){
                    count++;
                }
            }
            received[i] = count;
        }
        int[] dp = new int[budget + 1];
        for(int i = 0 ; i < n ; i++){
            int p = items[i][1];
            int g = received[i];
            int[] old = dp.clone();
            int[] ndp = old.clone();
            for(int r = 0 ; r < p ; r++){
                int best = Integer.MIN_VALUE / 4;
                for(int b = r , m = 0 ; b <= budget ; b += p, m++){
                    if(m > 0){
                        int qPos = b - p;
                        best = Math.max(best, old[qPos] - (m - 1));
                        ndp[b] = Math.max(ndp[b], g + m + best);
                    }
                }
            }
            dp = ndp;
        }
        int ans = 0;
        for(int v : dp){
            ans = Math.max(ans, v);
        }
        return ans;
    }
    public static void main(String[] args) {
        int[][] items = {{6,2},{2,6},{3,4}};
        int budget = 9;
        System.out.println(maximumSaleItems(items, budget));
    }
}
