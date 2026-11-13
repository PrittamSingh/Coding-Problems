import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class nov13_26 {
    public static long[] cumSum;
    public static long countNonDecreasingSubarrays(int[] nums, int k) {
        int n = nums.length;
        cumSum = new long[n];
        cumSum[0] = nums[0];
        for(int i = 1 ; i < n ; i++){
            cumSum[i] = cumSum[i - 1] + nums[i];
        }
        int[] nextGreaterEle = new int[n];
        Arrays.fill(nextGreaterEle, n);
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i = 0 ; i < n ; i++){
            while(!stack.isEmpty() && nums[stack.peek()] < nums[i]){
                nextGreaterEle[stack.pop()] = i;;
            }
            stack.push(i);
        }
        long[] Operations = new long[n + 1];
        for(int i = n - 1 ; i >= 0 ; i--){
            int m = nextGreaterEle[i];
            long segmentOprns = (1L * nums[i] * (m - i)) - rangeSum(i, m - 1);
            Operations[i] = segmentOprns + Operations[m];
        }
        Deque<Integer> deq = new ArrayDeque<>();
        long result = 0;
        int i = 0;
        int j = 0;
        while(j < n){
            while(!deq.isEmpty() && nums[deq.peekLast()] < nums[j]){
                deq.pollLast();
            }
            deq.addLast(j);
            while(i <= j){
                int m = deq.peekFirst();
                long oprnsCount = (Operations[i] - Operations[m]) + (1L * nums[m] * (j - m + 1)) - rangeSum(m, j);
                if(oprnsCount <= k)
                    break;
                i++;
                if(deq.peekFirst() < i){
                    deq.pollFirst();
                }
            }
            result += (j - i + 1);
            j++;
        }
        return result;
    }
    public static long rangeSum(int i, int j){
        if(i > j) return 0;
        return cumSum[j] - ((i > 0) ? cumSum[i - 1] : 0);
    }
    public static void main(String[] args) {
        int[] nums = {6,3,1,2,4,4};
        int k = 7;
        System.out.println(countNonDecreasingSubarrays(nums, k));
    }
}
