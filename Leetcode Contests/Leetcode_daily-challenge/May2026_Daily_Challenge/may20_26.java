import java.util.Arrays;
public class may20_26 {
    public static int[] findThePrefixCommonArray(int[] A, int[] B) {
        // int n = A.length;
        // int[] ans = new int[n];
        // Set<Integer> set = new HashSet<>();
        // for(int i = 0 ; i < n ; i++){
        //     set.add(A[i]);
        //     int common = 0;
        //     for(int j = 0 ; j <= i ; j++){
        //         if(set.contains(B[j])){
        //             common++;
        //         }
        //     }
        //     ans[i] = common;
        // }
        // return ans;




        int n = A.length;
        int[] ans = new int[n];
        int[] freq = new int[n + 1];
        int common = 0;
        for(int i = 0 ; i < n ; i++){
            freq[A[i]]++;
            if(freq[A[i]] == 2){
                common++;
            }
            freq[B[i]]++;
            if(freq[B[i]] == 2){
                common++;
            }
            ans[i] = common;
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] A = {1, 3, 2, 4};
        int[] B = {3, 1, 2, 4};
        int[] result = findThePrefixCommonArray(A, B);
        System.out.println(Arrays.toString(result));
    }
}
