import java.util.*;
public class nov28_25 {
    static int ans = 0;
    public static int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            list.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            list.get(u).add(v);
            list.get(v).add(u);
        }
        boolean[] vis = new boolean[n];
        dfs(list, values, k, vis, 0);
        
        return ans;
    }
    public static long dfs(List<List<Integer>> list, int[] values, int k, boolean[] vis, int curr){
        vis[curr] = true;
        long sum = values[curr];
        for(int neighbour : list.get(curr)){
            if(!vis[neighbour]){
                sum += dfs(list, values, k, vis, neighbour);
            }
        }
        if(sum % k == 0){
                ans++;
            }
        return sum;
    }
    public static void main(String[] args) {
        // int n1 = 5;
        // int[][] edges1 = {{0,2},{1,2},{1,3},{2,4}};
        // int[] values1 = {1,8,1,4,4};
        // int k1 = 6;
        // System.out.println(maxKDivisibleComponents(n1, edges1, values1, k1));
        int n = 7;
        int[][] edges = {{0,1},{0,2},{1,3},{1,4},{2,5},{2,6}};
        int[] values = {3,0,6,1,5,2,1};
        int k = 3;
        System.out.println(maxKDivisibleComponents(n, edges, values, k));
    }
}
