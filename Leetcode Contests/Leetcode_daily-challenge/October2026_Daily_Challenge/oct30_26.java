import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class oct30_26 {
    public static int shortestPath(int n, int[][] edges, String labels, int k) {
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for(int[] edge : edges){
            int u  = edge[0];
            int v  = edge[1];
            int wt = edge[2];
            adj.computeIfAbsent(u, x -> new ArrayList<>()).add(new int[]{v, wt});
        }
        int[][] result = new int[n][k + 1];
        for(int[] row : result){
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        result[0][1] = 0;
        pq.offer(new int[]{0, 0, 1});
        while(!pq.isEmpty()){
            int[] top = pq.poll();
            int d = top[0];
            int node  = top[1];
            int count = top[2];
            if (d > result[node][count])
                continue;
            if (node == n - 1)
                return d;
            if(!adj.containsKey(node))
                continue;
            for(int[] vec : adj.get(node)){
                int adjNode = vec[0];
                int wt = vec[1];
                int newCount = (labels.charAt(adjNode) == labels.charAt(node)) ? count + 1 : 1;
                if(newCount > k)
                    continue;
                int newDist = d + wt;
                if(newDist < result[adjNode][newCount]){
                    result[adjNode][newCount] = newDist;
                    pq.offer(new int[]{newDist, adjNode, newCount});
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int n = 3;
        int[][] edges = {{0,1,1},{1,2,1},{0,2,3}};
        String labels = "aab";
        int k = 1;
        System.out.println(shortestPath(n, edges, labels, k));
    }
}
