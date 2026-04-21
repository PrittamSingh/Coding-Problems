import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class april21_26 {
    static class DSU{
        int[] parent, rank;
        DSU(int n){
            parent = new int[n];
            rank = new int[n];
            for(int i = 0; i < n; i++){
                parent[i] = i;
            }
        }
        int find(int x){
            if(parent[x] != x){
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
        void union(int x, int y) {
            int px = find(x);
            int py = find(y);
            if(px == py) return;
            if(rank[px] < rank[py]){
                parent[px] = py;
            }
            else if(rank[px] > rank[py]){
                parent[py] = px;
            }
            else{
                parent[py] = px;
                rank[px]++;
            }
        }
    }
    public static int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int n = source.length;
        DSU dsu = new DSU(n);
        for(int[] swap : allowedSwaps){
            dsu.union(swap[0], swap[1]);
        }
        Map<Integer, List<Integer>> groups = new HashMap<>();
        for(int i = 0; i < n; i++){
            int parent = dsu.find(i);
            groups.computeIfAbsent(parent, k -> new ArrayList<>()).add(i);
        }
        int result = 0;

        for(List<Integer> group : groups.values()){
            Map<Integer, Integer> freq = new HashMap<>();
            for(int idx : group){
                freq.put(source[idx], freq.getOrDefault(source[idx], 0) + 1);
            }
            for(int idx : group){
                if(freq.getOrDefault(target[idx], 0) > 0){
                    freq.put(target[idx], freq.get(target[idx]) - 1);
                }
                else {
                    result++;
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[] source = {1,2,3,4}, target = {2,1,4,5};
        int[][] allowedSwaps = {{0,1},{2,3}};
        System.out.println(minimumHammingDistance(source, target, allowedSwaps));
    }
}
