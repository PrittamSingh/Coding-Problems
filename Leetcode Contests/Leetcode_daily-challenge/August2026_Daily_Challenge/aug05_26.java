import java.util.ArrayList;
import java.util.List;

public class aug05_26 {
    public static List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        // List<List<Integer>> adj = new ArrayList<>();
        // for(int i = 0; i < n; i++){
        //     adj.add(new ArrayList<>());
        // }
        // int[] inDegree = new int[n];
        // boolean[] suspicious = new boolean[n];
        // for(int[] edge : invocations){
        //     int u = edge[0];
        //     int v = edge[1];
        //     adj.get(u).add(v);
        //     inDegree[v]++;
        // }
        // Queue<Integer> que = new LinkedList<>();
        // que.offer(k);
        // suspicious[k] = true;
        // while(!que.isEmpty()){
        //     int curr = que.poll();
        //     for(int ngbr : adj.get(curr)){
        //         inDegree[ngbr]--;
        //         if(!suspicious[ngbr]){
        //             que.offer(ngbr);
        //             suspicious[ngbr] = true;
        //         }
        //     }
        // }
        // List<Integer> result = new ArrayList<>();
        // boolean cannotRemove = false;
        // for(int i = 0 ; i < n ; i++){
        //     if(suspicious[i] && inDegree[i] > 0){
        //         cannotRemove = true;
        //         break;
        //     }
        //     if(!suspicious[i]){
        //         result.add(i);
        //     }
        // }
        // if(cannotRemove){
        //     List<Integer> vec = new ArrayList<>();
        //     for(int i = 0 ; i < n ; i++){
        //         vec.add(i);
        //     }
        //     return vec;
        // }
        // return result;




        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            adj.add(new ArrayList<>());
        }
        int[] inDegree = new int[n];
        boolean[] suspicious = new boolean[n];
        for(int[] edge : invocations) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            inDegree[v]++;
        }
        dfs(k, adj, inDegree, suspicious);
        List<Integer> result = new ArrayList<>();
        boolean cannotRemove = false;
        for(int i = 0 ; i < n ; i++){
            if(suspicious[i] && inDegree[i] > 0){
                cannotRemove = true;
                break;
            }
            if(!suspicious[i]){
                result.add(i);
            }
        }
        if(cannotRemove){
            List<Integer> vec = new ArrayList<>();
            for(int i = 0; i < n; i++) {
                vec.add(i);
            }
            return vec;
        }
        return result;
    }
    public static void dfs(int curr, List<List<Integer>> adj, int[] inDegree, boolean[] suspicious) {
        suspicious[curr] = true;
        for(int ngbr : adj.get(curr)){
            inDegree[ngbr]--;
            if(!suspicious[ngbr]){
                dfs(ngbr, adj, inDegree, suspicious);
            }
        }
    }
    public static void main(String[] args) {
        int n = 4, k = 1;
        int[][] invocations = {{1,2},{0,1},{3,2}};
        System.out.println(remainingMethods(n, k, invocations));
    }
}
