import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class july03_26 {
    public static int findMaxPathScore(int[][] edges, boolean[] online, long k) {
        int n = online.length;
        Map<Integer, List<int[]>> adj = new HashMap<>();
        int l = Integer.MAX_VALUE;
        int r = 0;
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int cost = edge[2];
            if(!online[u] || !online[v]){
                continue;
            }
            adj.computeIfAbsent(u, x -> new ArrayList<>()).add(new int[]{v, cost});
            l = Math.min(l, cost);
            r = Math.max(r, cost);
        }
        int ans = -1;
        while(l <= r){
            int mid = l + (r - l) / 2;
            if(check(mid, n, k, adj)){
                ans = mid;
                l = mid + 1;
            }
            else{
                r = mid - 1;
            }
        }
        return ans;
    }
    // DIJKSTRA
    public static boolean check(int mid, int n, long k, Map<Integer, List<int[]>> adj){
        // result[i] = min cost path from source to ith node
        long[] result = new long[n];
        Arrays.fill(result, Long.MAX_VALUE);

        // min-heap for dijkstra's algo
        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));
        result[0] = 0;
        pq.offer(new long[]{0, 0}); 
        while(!pq.isEmpty()){
            long[] top = pq.poll();
            long d = top[0];
            int node = (int)top[1];
            if(d > k){
                return false;
            }
            if(node == n - 1){
                return true;
            }
            // total cost reaching from source to node = d
            if(result[node] < d){
                continue;
            }
            for(int[] vec : adj.getOrDefault(node, Collections.emptyList())){
                int adjNode = vec[0];
                int edgeCost = vec[1];
                if(edgeCost < mid){
                    continue;
                }
                if(d + edgeCost < result[adjNode]){
                    result[adjNode] = d + edgeCost;
                    pq.offer(new long[]{d + edgeCost, adjNode});
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[][] edges = {{0, 1, 5}, {1, 3, 10}, {0, 2, 3}, {2, 3, 4}};
        boolean[] online = {true, true, true, true};
        long k = 10;
        System.out.println(findMaxPathScore(edges, online, k));
    }
}
