import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class may18_26 {
    public static int minJumps(int[] arr) {
        int n = arr.length;
        if(n == 1) return 0;
        boolean[] vis = new boolean[n];
        Arrays.fill(vis, false);
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0 ; i < n ; i++){
            map.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        vis[0] = true;
        int steps = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-- > 0){
                int curr = queue.poll();
                if(curr == n - 1) return steps;
                int left = curr - 1;
                int right = curr + 1;
                if(left >= 0 && !vis[left]){
                    queue.add(left);
                    vis[left] = true;
                }
                if(right < n && !vis[right]){
                    queue.add(right);
                    vis[right] = true;
                }
                List<Integer> sameValues = map.get(arr[curr]);
                if(sameValues != null){
                    for(int idx : sameValues){
                        if(!vis[idx]){
                            queue.add(idx);
                            vis[idx] = true;
                        }
                    }
                }
                map.remove(arr[curr]);
            }
            steps++;
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] arr = {100,-23,-23,404,100,23,23,23,3,404};
        System.out.println(minJumps(arr));
    }
}
