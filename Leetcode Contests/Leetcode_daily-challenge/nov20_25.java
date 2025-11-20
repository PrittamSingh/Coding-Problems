import java.util.*;
public class nov20_25 {
    public static int intersectionSizeTwo(int[][] intervals) {
        int count = 2;
        Arrays.sort(intervals, (a, b) -> {
            if(a[1] == b[1]) return b[0] - a[0];
            return a[1] - b[1];
        });
        int[] maxi = new int[2];
        maxi[0] = intervals[0][1] - 1;
        maxi[1] = intervals[0][1];
        int n = intervals.length;

        for(int i = 1 ; i < n ; i++){
            if(maxi[1] < intervals[i][0]){
                count += 2;
                maxi[0] = intervals[i][1] - 1;
                maxi[1] = intervals[i][1];
            }
            else if(maxi[0] < intervals[i][0]){
                count += 1;
                maxi[0] = maxi[1];
                maxi[1] = intervals[i][1];
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int[][] intervals = {{1,3},{3,7},{8,9}};
        int[][] intervals2 = {{1,3},{1,4},{2,5},{3,5}};
        int[][] intervals3 = {{1,2},{2,3},{2,4},{4,5}};
        System.out.println(intersectionSizeTwo(intervals) + " " + intersectionSizeTwo(intervals2) + " " + intersectionSizeTwo(intervals3));
    }
}
