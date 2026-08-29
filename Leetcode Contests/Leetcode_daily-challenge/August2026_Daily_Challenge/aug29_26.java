import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class aug29_26 {
    public static int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;
        int[][] arr = new int[n][2];
        for(int i = 0 ; i < n ; i++){
            arr[i][0] = nums[i];
            arr[i][1] = i;
        }
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);
        int start = 0;
        while(start < n){
            int end = start;
            while(end + 1 < n && arr[end + 1][0] - arr[end][0] <= limit){
                end++;
            }
            ArrayList<Integer> indices = new ArrayList<>();
            for(int i = start ; i <= end ; i++){
                indices.add(arr[i][1]);
            }
            Collections.sort(indices);
            for(int i = 0 ; i < indices.size() ; i++){
                nums[indices.get(i)] = arr[start + i][0];
            }
            start = end + 1;
        }
        return nums;
    }
    public static void main(String[] args) {
        int[] nums = {1,5,3,9,8};
        int limit = 2;
        System.out.println(Arrays.toString(lexicographicallySmallestArray(nums, limit)));
    }
}
