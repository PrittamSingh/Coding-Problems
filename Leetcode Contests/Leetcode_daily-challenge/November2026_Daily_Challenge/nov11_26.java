public class nov11_26 {
    public static long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        long ans = 0;
        int common = Math.min(need1, need2);
        if(costBoth < (long)cost1 + cost2){
            ans += (long)common * costBoth;
        }
        else{
            ans += (long)common * cost1;
            ans += (long)common * cost2;
        }
        need1 -= common;
        need2 -= common;
        if(need1 > 0){
            ans += (long)Math.min(cost1, costBoth) * need1;
        }
        else{
            ans += (long)Math.min(cost2, costBoth) * need2;
        }
        return ans;
    }
    public static void main(String[] args) {
        int cost1 = 3, cost2 = 2, costBoth = 1, need1 = 3, need2 = 2;
        System.out.println(minimumCost(cost1, cost2, costBoth, need1, need2));
    }
}
