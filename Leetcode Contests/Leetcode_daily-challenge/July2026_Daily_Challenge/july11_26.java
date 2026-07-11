import java.util.ArrayList;
import java.util.List;

public class july11_26 {
    static int v, e;
    public static int countCompleteComponents(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int result = 0;
        boolean[] vis = new boolean[n];
        for(int i = 0 ; i < n ; i++){
            if(vis[i]){
                continue;
            }
            v = 0;
            e = 0;
            dfs(i, adj, vis);
            if((v * (v - 1)) == e){
                result++;
            }
        }
        return result;
    }
    public static void dfs(int node, List<List<Integer>> adj, boolean[] vis){
        vis[node] = true;
        e += adj.get(node).size();
        v += 1;
        for(int neighbour : adj.get(node)){
            if(!vis[neighbour]){
                dfs(neighbour, adj, vis);
            }
        }
    }
    public static void main(String[] args) {
        int n = 6;
        int[][] edges = {{0,1},{0,2},{1,2},{3,4}};
        System.out.println(countCompleteComponents(n, edges));
    }
}
