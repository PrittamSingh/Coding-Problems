import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class july04_26 {
    public static int minScore(int n, int[][] roads) {
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for(int[] road : roads){
            int u = road[0];
            int v = road[1];
            int dist = road[2];
            adj.computeIfAbsent(u, x -> new ArrayList<>()).add(new int[]{v, dist});
            adj.computeIfAbsent(v, x -> new ArrayList<>()).add(new int[]{u, dist});
        }
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];
        queue.add(1);
        visited[1] = true;
        int ans = Integer.MAX_VALUE;
        while(!queue.isEmpty()){
            int node = queue.poll();
            for(int[] neighbour : adj.getOrDefault(node, Collections.emptyList())){
                int adjNode = neighbour[0];
                int adjDist = neighbour[1];
                ans = Math.min(ans, adjDist);
                if(!visited[adjNode]){
                    visited[adjNode] = true;
                    queue.offer(adjNode);
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int n = 4;
        int[][] roads = {{1,2,9},{2,3,6},{2,4,5},{1,4,7}};
        System.out.println(minScore(n, roads));
    }
}
