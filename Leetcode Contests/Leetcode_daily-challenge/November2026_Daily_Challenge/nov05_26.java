import java.util.Arrays;

public class nov05_26 {
    // public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
    //     int ans = 0;
    //     for(int i = 0 ; i < arr1.length ; i++){
    //         int num1 = arr1[i];
    //         boolean ok = true;
    //         for(int j = 0 ; j < arr2.length ; j++){
    //             int num2 = arr2[j];
    //             if(Math.abs(num1 - num2) <= d){
    //                 ok = false;
    //                 break;
    //             }
    //         }
    //         if(ok){
    //             ans++;
    //         }
    //     }
    //     return ans;
    // }



    public static int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);
        int n = arr2.length;
        int ans = 0;
        for(int i = 0 ; i < arr1.length ; i++){
            int j = lower_bound(arr2, arr1[i]);
            if(j == 0){
                if(arr2[0] - arr1[i] > d) ans++;
            }
            else if(j >= n){
                if(arr1[i] - arr2[n - 1] > d) ans++;
            }
            else{
                if(arr2[j] - arr1[i] > d && arr1[i] - arr2[j - 1] > d) ans++;
            }
        }
        return ans;
    }
    public static int lower_bound(int[] arr, int target){
        int low = 0;
        int high = arr.length;
        while(low < high){
            int mid = low + (high - low) / 2;
            if(arr[mid] < target){
                low = mid + 1;
            }
            else{
                high = mid;
            }
        }
        return low;
    }
    public static void main(String[] args) {
        int[] arr1 = {4,5,8};
        int[] arr2 = {10,9,1,8};
        int d = 2;
        System.out.println(findTheDistanceValue(arr1, arr2, d));
    }
}
