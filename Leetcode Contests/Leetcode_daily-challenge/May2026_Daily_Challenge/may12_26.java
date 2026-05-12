import java.util.Arrays;

public class may12_26 {
    public static int minimumEffort(int[][] tasks) {
        Arrays.sort(tasks, (a, b) -> {
            int diff1 = a[1] - a[0];
            int diff2 = b[1] - b[0];
            return diff2 - diff1;
        });
        int left = 0;
        int right = 1000000000;
        int result = Integer.MAX_VALUE;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(isPossible(tasks, mid)){
                result = mid;
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }
        return result;
    }
    public static boolean isPossible(int[][] tasks, int mid){
        for(int[] task : tasks){
            if(mid < task[1]){
                return false;
            }
            mid = mid - task[0];
        }
        return true;
    }
    public static void main(String[] args) {
        int[][] tasks = {{1,2},{2,4},{4,8}};
        int[][] tasks1 = {{1,3},{2,4},{10,11},{10,12},{8,9}};
        System.out.println(minimumEffort(tasks) + " " + minimumEffort(tasks1));
    }
}
