import java.util.Arrays;

public class june28_26 {
    public static int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        arr[0] = 1;
        for(int i = 1 ; i < n ; i++){
            if(arr[i] - arr[i - 1] <= 1){
                continue;
            }
            else{
                arr[i] = arr[i - 1] + 1;
            }
        }
        return arr[n - 1];
    }
    public static void main(String[] args) {
        int[] arr = {2,2,1,2,1};
        System.out.println(maximumElementAfterDecrementingAndRearranging(arr));
    }
}
