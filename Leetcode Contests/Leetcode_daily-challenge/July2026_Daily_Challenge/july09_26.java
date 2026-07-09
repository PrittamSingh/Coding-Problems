import java.util.Arrays;
public class july09_26 {
    public static boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        int[] component = new int[n];
        int compId = 0;
        component[0] = compId;
        for(int i = 1 ; i < n ; i++){
            if(nums[i] - nums[i - 1] > maxDiff){
                compId++;
            }
            component[i] = compId;
        }
        boolean[] result = new boolean[queries.length];
        for(int j = 0 ; j < queries.length ; j++){
            result[j] = (component[queries[j][0]] == component[queries[j][1]]);
        }
        return result;
    }
    public static void main(String[] args) {
        int n = 2;
        int[] nums = {1,3};
        int maxDiff = 1;
        int[][] queries = {{0,0},{0,1}};
        System.out.println(Arrays.toString(pathExistenceQueries(n, nums, maxDiff, queries)));
    }
}
