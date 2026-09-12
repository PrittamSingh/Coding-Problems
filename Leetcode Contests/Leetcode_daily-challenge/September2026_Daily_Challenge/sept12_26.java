import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class sept12_26 {
    // BOTTOM UP
    static int n;
    static int[][] intervals;
    static int[] nextIdx;
    static class Node{
        long score = -1;
        List<Integer> idxs = new ArrayList<>();
    }
    static Node[][] t;
    public static  int[] maximumWeight(List<List<Integer>> intervalsList) {
        n = intervalsList.size();
        intervals = new int[n][4];
        for(int i = 0 ; i < n ; i++){
            intervals[i][0] = intervalsList.get(i).get(0);
            intervals[i][1] = intervalsList.get(i).get(1);
            intervals[i][2] = intervalsList.get(i).get(2);
            intervals[i][3] = i;
        }
        Arrays.sort(intervals, (a, b) -> {
            if(a[0] != b[0]) return a[0] - b[0];
            if(a[1] != b[1]) return a[1] - b[1];
            if(a[2] != b[2]) return a[2] - b[2];
            return a[3] - b[3];
        });
        nextIdx = new int[n];
        for(int i = 0 ; i < n ; i++){
            int end = intervals[i][1];
            nextIdx[i] = findNext(end);
        }
        final int K = 4;
        t = new Node[n + 1][K + 1];
        for(int i = 0 ; i <= n ; i++){
            for(int j = 0 ; j <= K ; j++){
                t[i][j] = new Node();
            }
        }
        for(int i = n - 1 ; i >= 0 ; i--){
            int weight = intervals[i][2];
            int idx = intervals[i][3];
            int j = nextIdx[i];
            for(int k = 1 ; k <= K ; k++){
                Node skip = t[i + 1][k];
                Node temp = t[j][k - 1];

                Node take = new Node();
                take.score = temp.score + weight;
                take.idxs  = new ArrayList<>(temp.idxs);
                take.idxs.add(idx);
                Collections.sort(take.idxs);

                Node result;
                if(skip.score > take.score){
                    result = skip;
                }
                else if(skip.score < take.score){
                    result = take;
                }
                else{
                    result = isLexSmaller(skip.idxs, take.idxs) ? skip : take;
                }
                t[i][k] = result;
            }
        }
        Node res = t[0][K];
        int[] ans = new int[res.idxs.size()];
        for(int i = 0 ; i < ans.length ; i++){
            ans[i] = res.idxs.get(i);
        }
        return ans;
    }
    public static boolean isLexSmaller(List<Integer> a, List<Integer> b) {
        int len = Math.min(a.size(), b.size());
        for(int i = 0 ; i < len ; i++){
            if(!a.get(i).equals(b.get(i))){
                return a.get(i) < b.get(i);
            }
        }
        return a.size() < b.size();
    }
    public static int findNext(int end) {
        int low = 0;
        int high = n - 1;
        int result = n;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(intervals[mid][0] > end){
                result = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        // int[][] intervals = {{1,3,2},{4,5,2},{1,5,5},{6,9,3},{6,7,1},{8,9,1}};
        int[][] intervals = {{5,8,1},{6,7,7},{4,7,3},{9,10,6},{7,8,2},{11,14,3},{3,5,5}};
        List<List<Integer>> intervalsList = new ArrayList<>();
        for(int[] interval : intervals){
            intervalsList.add(
                Arrays.asList(
                    interval[0],
                    interval[1],
                    interval[2]
                )
            );
        }
        System.out.println(Arrays.toString(maximumWeight(intervalsList)));
    }




    // RECURSION + MEMOIZATION
    // int n;
    // int[][] intervals;
    // int[] nextIdx;
    // static class Node{
    //     long score = -1;
    //     List<Integer> idxs = new ArrayList<>();
    // }
    // Node[][] t;
    // public int[] maximumWeight(List<List<Integer>> intervalsList) {
    //     n = intervalsList.size();
    //     intervals = new int[n][4];
    //     for(int i = 0 ; i < n ; i++){
    //         intervals[i][0] = intervalsList.get(i).get(0);
    //         intervals[i][1] = intervalsList.get(i).get(1);
    //         intervals[i][2] = intervalsList.get(i).get(2);
    //         intervals[i][3] = i;
    //     }
    //     Arrays.sort(intervals, (a, b) -> {
    //         if(a[0] != b[0]) return a[0] - b[0];
    //         if(a[1] != b[1]) return a[1] - b[1];
    //         if(a[2] != b[2]) return a[2] - b[2];
    //         return a[3] - b[3];
    //     });
    //     nextIdx = new int[n];
    //     for(int i = 0 ; i < n ; i++){
    //         int end = intervals[i][1];
    //         nextIdx[i] = findNext(end);
    //     }
    //     final int k = 4;
    //     t = new Node[n + 1][k + 1];
    //     for(int i = 0 ; i <= n ; i++){
    //         for(int j = 0 ; j <= k ; j++){
    //             t[i][j] = new Node();
    //         }
    //     }
    //     Node res = solve(0, k);
    //     int[] ans = new int[res.idxs.size()];
    //     for(int i = 0 ; i < ans.length ; i++){
    //         ans[i] = res.idxs.get(i);
    //     }
    //     return ans;
    // }
    // public Node solve(int i, int k){
    //     if(k == 0 || i >= n){
    //         return new Node();
    //     }
    //     if(t[i][k].score != -1){
    //         return t[i][k];
    //     }
    //     int weight = intervals[i][2];
    //     int idx = intervals[i][3];
    //     int j = nextIdx[i];
    //     Node skip = solve(i + 1, k);
    //     Node temp = solve(j, k - 1);
    //     Node take = new Node();
    //     take.score = temp.score + weight;
    //     take.idxs  = new ArrayList<>(temp.idxs);
    //     take.idxs.add(idx);
    //     Collections.sort(take.idxs);

    //     Node result;
    //     if(skip.score > take.score){
    //         result = skip;
    //     }
    //     else if(skip.score < take.score){
    //         result = take;
    //     }
    //     else{
    //         result = isLexSmaller(skip.idxs, take.idxs) ? skip : take;
    //     }
    //     t[i][k] = result;
    //     return result;
    // }
    // public boolean isLexSmaller(List<Integer> a, List<Integer> b) {
    //     int len = Math.min(a.size(), b.size());
    //     for(int i = 0 ; i < len ; i++){
    //         if(!a.get(i).equals(b.get(i))){
    //             return a.get(i) < b.get(i);
    //         }
    //     }
    //     return a.size() < b.size();
    // }
    // public int findNext(int end) {
    //     int low = 0;
    //     int high = n - 1;
    //     int result = n;
    //     while(low <= high){
    //         int mid = low + (high - low) / 2;
    //         if(intervals[mid][0] > end){
    //             result = mid;
    //             high = mid - 1;
    //         }
    //         else{
    //             low = mid + 1;
    //         }
    //     }
    //     return result;
    // }



    // RECURSION
    // int n;
    // int[][] intervals;
    // int[] nextIdx;
    // static class Node{
    //     long score = -1;
    //     List<Integer> idxs = new ArrayList<>();
    // }
    // public int[] maximumWeight(List<List<Integer>> intervalsList) {
    //     n = intervalsList.size();
    //     intervals = new int[n][4];
    //     for(int i = 0 ; i < n ; i++){
    //         intervals[i][0] = intervalsList.get(i).get(0);
    //         intervals[i][1] = intervalsList.get(i).get(1);
    //         intervals[i][2] = intervalsList.get(i).get(2);
    //         intervals[i][3] = i;
    //     }
    //     Arrays.sort(intervals, (a, b) -> {
    //         if(a[0] != b[0]) return a[0] - b[0];
    //         if(a[1] != b[1]) return a[1] - b[1];
    //         if(a[2] != b[2]) return a[2] - b[2];
    //         return a[3] - b[3];
    //     });
    //     nextIdx = new int[n];
    //     for(int i = 0 ; i < n ; i++){
    //         int end = intervals[i][1];
    //         nextIdx[i] = findNext(end);
    //     }
    //     int k = 4;
    //     Node res = solve(0, k);
    //     int[] ans = new int[res.idxs.size()];
    //     for(int i = 0 ; i < ans.length ; i++){
    //         ans[i] = res.idxs.get(i);
    //     }
    //     return ans;
    // }
    // public Node solve(int i, int k){
    //     if(k == 0 || i >= n)
    //         return new Node();

    //     int weight = intervals[i][2];
    //     int idx = intervals[i][3];
    //     int j = nextIdx[i];
    //     Node skip = solve(i + 1, k);
    //     Node temp = solve(j, k - 1);
    //     Node take = new Node();
    //     take.score = temp.score + weight;
    //     take.idxs  = new ArrayList<>(temp.idxs);
    //     take.idxs.add(idx);
    //     Collections.sort(take.idxs);

    //     Node result;
    //     if(skip.score > take.score){
    //         result = skip;
    //     }
    //     else if(skip.score < take.score){
    //         result = take;
    //     }
    //     else{
    //         result = isLexSmaller(skip.idxs, take.idxs) ? skip : take;
    //     }
    //     return result;
    // }
    // public boolean isLexSmaller(List<Integer> a, List<Integer> b) {
    //     int len = Math.min(a.size(), b.size());
    //     for(int i = 0 ; i < len ; i++){
    //         if(!a.get(i).equals(b.get(i))){
    //             return a.get(i) < b.get(i);
    //         }
    //     }
    //     return a.size() < b.size();
    // }
    // public int findNext(int end) {
    //     int low = 0;
    //     int high = n - 1;
    //     int result = n;
    //     while(low <= high){
    //         int mid = low + (high - low) / 2;
    //         if(intervals[mid][0] > end){
    //             result = mid;
    //             high = mid - 1;
    //         }
    //         else{
    //             low = mid + 1;
    //         }
    //     }
    //     return result;
    // }
}
