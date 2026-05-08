import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class may08_26 {
    static boolean[] isPrime;
    static void buildSieve(int maxEle){
        isPrime = new boolean[maxEle + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        for(int num = 2 ; num * num <= maxEle ; num++){
            if(isPrime[num]){
                for(int multiple = num * num ; multiple <= maxEle ; multiple += num){
                    isPrime[multiple] = false;
                }
            }
        }
    }
    public static int minJumps(int[] nums) {
        int n = nums.length;
        Map<Integer, List<Integer>> map = new HashMap<>();
        int maxEle = 0;
        for(int i = 0 ; i < n ; i++){
            map.putIfAbsent(nums[i], new ArrayList<>());
            map.get(nums[i]).add(i);
            maxEle = Math.max(maxEle, nums[i]);
        }
        buildSieve(maxEle);
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        Arrays.fill(visited, false);
        queue.offer(0);
        visited[0] = true;
        Set<Integer> seen = new HashSet<>();
        int steps = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-- > 0){
                int i = queue.poll();
                if(i == n - 1){
                    return steps;
                }
                if(i - 1 >= 0 && !visited[i - 1]){
                    queue.offer(i - 1);
                    visited[i - 1] = true;
                }
                if(i + 1 < n && !visited[i + 1]){
                    queue.offer(i + 1);
                    visited[i + 1] = true;
                }
                if(!isPrime[nums[i]] || seen.contains(nums[i])){
                    continue;
                }
                for(int multiple = nums[i] ; multiple <= maxEle ; multiple += nums[i]){
                    if(!map.containsKey(multiple)){
                        continue;
                    }
                    for(int j : map.get(multiple)){
                        if(!visited[j]){
                            queue.offer(j);
                            visited[j] = true;
                        }
                    }
                }
                seen.add(nums[i]);
            }
            steps++;
        }
        return steps;
    }public static void main(String[] args) {
        int[] nums = {1,2,4,6};
        int[] nums2 = {4,6,5,8};
        System.out.println(minJumps(nums) + " " + minJumps(nums2));
    }
}
