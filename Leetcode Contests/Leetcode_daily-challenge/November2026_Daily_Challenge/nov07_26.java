import java.util.Arrays;
import java.util.PriorityQueue;

public class nov07_26 {
    public static int[] assignTasks(int[] servers, int[] tasks) {
        int n = servers.length;
        int m = tasks.length;
        PriorityQueue<int[]> freeServers = new PriorityQueue<>(
            (a, b) -> a[0] != b[0] ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1])
        );
        PriorityQueue<int[]> busyServers = new PriorityQueue<>(
            (a, b) -> {
                if(a[0] != b[0]) return Integer.compare(a[0], b[0]);
                if(a[1] != b[1]) return Integer.compare(a[1], b[1]);
                return Integer.compare(a[2], b[2]);
            }
        );
        for(int i = 0 ; i < n ; i++){
            freeServers.add(new int[]{servers[i], i});
        }
        int[] res = new int[m];
        for(int i = 0 ; i < m ; i++){
            while(!busyServers.isEmpty() && busyServers.peek()[0] <= i){
                int[] curr = busyServers.poll();
                freeServers.add(new int[]{curr[1], curr[2]});
            }
            if(freeServers.isEmpty()){
                int[] curr = busyServers.poll();
                res[i] = curr[2];
                busyServers.add(new int[]{curr[0] + tasks[i], curr[1], curr[2]});
            }
            else{
                int[] curr = freeServers.poll();
                res[i] = curr[1];
                busyServers.add(new int[]{i + tasks[i], curr[0], curr[1]});
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int[] servers = {3,3,2}, tasks = {1,2,3,2,1,2};
        System.out.println(Arrays.toString(assignTasks(servers, tasks)));
    }
}
