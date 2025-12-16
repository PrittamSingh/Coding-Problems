import java.util.*;
public class dec16_25 {
    static List<Integer>[] tree;
    static int[] buyPrice, sellPrice;
    static int budgetVal;
    public static int maxProfit(int n, int[] present, int[] future, int[][] hierarchy, int budget) {
        buyPrice = present;
        sellPrice = future;
        budgetVal = budget;
        tree = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }
        for (int[] h : hierarchy) {
            int boss = h[0] - 1;
            int emp  = h[1] - 1;
            tree[boss].add(emp);
        }
        int[][] dp = dfs(0);
        return dp[budgetVal][0];
    }

    static int[][] dfs(int u) {
        int[][] dp = new int[budgetVal + 1][2];
        for (int v : tree[u]) {
            int[][] child = dfs(v);
            int[][] next = new int[budgetVal + 1][2];

            for (int b = 0; b <= budgetVal; b++) {
                for (int cb = 0; cb <= b; cb++) {
                    next[b][0] = Math.max(next[b][0],
                            dp[b - cb][0] + child[cb][0]);
                    next[b][1] = Math.max(next[b][1],
                            dp[b - cb][1] + child[cb][1]);
                }
            }
            dp = next;
        }

        int[][] ans = new int[budgetVal + 1][2];

        for (int b = 0; b <= budgetVal ; b++) {
            ans[b][0] = dp[b][0];
            if (b >= buyPrice[u]) {
                ans[b][0] = Math.max(ans[b][0],
                        sellPrice[u] - buyPrice[u] + dp[b - buyPrice[u]][1]);
            }

            int discounted = buyPrice[u] / 2;
            ans[b][1] = dp[b][0];
            if (b >= discounted) {
                ans[b][1] = Math.max(ans[b][1],
                        sellPrice[u] - discounted + dp[b - discounted][1]);
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int n = 2;
        int[] present = {1,2}, future = {4,3};
        int[][] hierarchy = {{1,2}};
        int budget = 3;
        System.out.println(maxProfit(n, present, future, hierarchy, budget));

        int n2 = 2;
        int[] present2 = {3, 4}, future2 = {5, 8};
        int[][] hierarchy2 = {{1,2}};
        int budget2 = 4;
        System.out.println(maxProfit(n2, present2, future2, hierarchy2, budget2));
    }
}
