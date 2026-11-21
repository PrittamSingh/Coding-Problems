import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class nov21_26 {
    public static Map<Integer, List<Integer>> adj = new HashMap<>();
    public static int[] resultSize;
    public static int[] last;
    public static int[] findSubtreeSizes(int[] parent, String s) {
        int n = parent.length;
        for(int i = 1 ; i < n ; i++){
            int u = parent[i];
            int v = i;
            adj.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
        }
        resultSize = new int[n];
        Arrays.fill(resultSize, 1);
        last = new int[26];
        Arrays.fill(last, -1);
        dfs(0, s, parent);
        return resultSize;
    }
    public static void dfs(int currNode, String s, int[] parent) {
        int c = s.charAt(currNode) - 'a';
        int nearestAncestor = last[c];
        last[c] = currNode;
        for(int child : adj.getOrDefault(currNode, Collections.emptyList())){
            dfs(child, s, parent);
        }
        last[c] = nearestAncestor;
        if(currNode != 0){
            int newParent = parent[currNode];
            if(nearestAncestor != -1)
                newParent = nearestAncestor;
            parent[currNode] = newParent;
            resultSize[newParent] += resultSize[currNode];
        }
    }
    public static void main(String[] args) {
        int[] parent = {-1,0,0,1,1,1};
        String s = "abaabc";
        System.out.println(Arrays.toString(findSubtreeSizes(parent, s)));
    }
}
