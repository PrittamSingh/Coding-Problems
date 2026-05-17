import java.util.LinkedList;
import java.util.Queue;

public class may17_26 {
    // BFS
    public static boolean canReach(int[] arr, int start) {
        int n = arr.length;
        return bfs(arr, start, n);
    }
    private static boolean bfs(int[] arr, int start, int n){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        while(!queue.isEmpty()) {
            int curr = queue.poll();
            if(arr[curr] == 0){
                return true;
            }
            if(arr[curr] < 0){
                continue;
            }
            int left  = curr + arr[curr];
            int right = curr - arr[curr];
            if(left >= 0 && left < n){
                queue.add(left);
            }
            if(right >= 0 && right < n){
                queue.add(right);
            }
            arr[curr] = -arr[curr];
        }
        return false;
    }




    // DFS
    // int n;
    // public boolean canReach(int[] arr, int start) {
    //     n = arr.length;
    //     return dfs(arr, start);
    // }
    // private boolean dfs(int[] arr, int i){
    //     if(i < 0 || i >= n || arr[i] < 0){
    //         return false;
    //     }
    //     if(arr[i] == 0){
    //         return true;
    //     }
    //     arr[i] *= -1;
    //     boolean left  = dfs(arr, i - arr[i]);
    //     boolean right = dfs(arr, i + arr[i]);
    //     return left || right;
    // }
    public static void main(String[] args) {
        int[] arr = {4,2,3,0,3,1,2};
        int start = 5;
        System.out.println(canReach(arr, start));
    }
}
