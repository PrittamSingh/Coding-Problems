import java.util.Arrays;

public class may24_26 {
    // BOTTOM UP
    public static int maxJumps(int[] arr, int d) {
        int n = arr.length;
        int[] t = new int[n];
        Arrays.fill(t, 1);
        int[][] vec = new int[n][2];
        for (int i = 0; i < n; i++) {
            vec[i][0] = arr[i];
            vec[i][1] = i;
        }
        Arrays.sort(vec, (a, b) -> a[0] - b[0]);
        for (int[] it : vec) {
            int i = it[1];
            for (int j = i - 1; j >= Math.max(0, i - d); j--) {
                if (arr[j] >= arr[i])
                    break;
                t[i] = Math.max(t[i], 1 + t[j]);
            }
            for (int j = i + 1; j <= Math.min(n - 1, i + d); j++) {
                if (arr[j] >= arr[i])
                    break;
                t[i] = Math.max(t[i], 1 + t[j]);
            }
        }
        return Arrays.stream(t).max().getAsInt();
    }



    // RECURSION + MEMOIZATION
    // int n;
    // int[] t;
    // public int maxJumps(int[] arr, int d) {
    //     n = arr.length;
    //     t = new int[n];
    //     Arrays.fill(t, -1);
    //     int maxJump = 1;
    //     for(int i = 0; i < n; i++){
    //         maxJump = Math.max(maxJump, solve(arr, d, i));
    //     }
    //     return maxJump;
    // }
    // private int solve(int[] arr, int d, int i) {
    //     if(t[i] != -1){
    //         return t[i];
    //     }
    //     int result = 1;
    //     for(int j = i - 1 ; j >= Math.max(0, i - d) ; j--){
    //         if(arr[j] >= arr[i]) break;
    //         result = Math.max(result, 1 + solve(arr, d, j));
    //     }
    //     for(int j = i + 1 ; j <= Math.min(n - 1, i + d) ; j++){
    //         if(arr[j] >= arr[i]) break;
    //         result = Math.max(result, 1 + solve(arr, d, j));
    //     }
    //     return t[i] = result;
    // }
    public static void main(String[] args) {
        int[] arr = {6, 4, 14, 6, 8, 13, 9, 7, 10, 6, 12};
        int d = 2;
        System.out.println(maxJumps(arr, d));
    }
}
