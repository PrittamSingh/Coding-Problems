import java.util.Arrays;

public class july06_26 {
    public static int removeCoveredIntervals(int[][] intervals) {
        // Arrays.sort(intervals, (a, b) -> b[0] - a[0]);
        // int count = 0;
        // boolean[] exist = new boolean[intervals.length];
        // Arrays.fill(exist, true);
        // for(int i = 0 ; i < intervals.length ; i++){
        //     int[] intervalA = intervals[i];
        //     for(int j = i + 1 ; j < intervals.length ; j++){
        //         if(!exist[i]){
        //             continue;
        //         }
        //         int[] intervalB = intervals[j];
        //         if(intervalB[0] <= intervalA[0] && intervalA[1] <= intervalB[1]){
        //             exist[i] = false;
        //             count++;
        //             break;
        //         }
        //     }
        // }
        // return intervals.length - count;



        Arrays.sort(intervals, (a, b) -> {
            if(a[0] == b[0]){
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });
        int remaining = 0;
        int maxEnd = -1;
        for(int[] interval : intervals){
            if(interval[1] > maxEnd){
                remaining++;
                maxEnd = interval[1];
            }
        }
        return remaining;
    }
    public static void main(String[] args) {
        int[][] intervals = {{1,4},{3,6},{2,8}};
        System.out.println(removeCoveredIntervals(intervals));
    }
}
