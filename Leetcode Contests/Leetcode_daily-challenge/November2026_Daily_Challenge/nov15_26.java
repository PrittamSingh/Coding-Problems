public class nov15_26 {
    public static int numOfSubarrays(int[] arr) {
        // int MOD = 1000000007;
        // int n = arr.length;
        // int count = 0;
        // for(int i = 0 ; i < n ; i++){
        //     int sum = 0;
        //     for(int j = i; j < n ; j++){
        //         sum += arr[j];
        //         if(sum % 2 == 1){
        //             count %= MOD;
        //             count++;
        //         }
        //     }
        // }
        // return count;

        // int MOD = 1000000007;
        // int n = arr.length;
        // int[] prefix = new int[n];
        // prefix[0] = arr[0];
        // for(int i = 1 ; i < n ; i++){
        //     prefix[i] = prefix[i - 1] + arr[i];
        // }
        // int count = 0;
        // int oddCount = 0;
        // int evenCount = 1;
        // for(int i = 0 ; i < n ; i++){
        //     if(prefix[i] % 2 == 0){ // even + odd => odd
        //         count = (count + oddCount) % MOD;
        //         evenCount++;
        //     }
        //     else{ // odd + even => odd
        //         count = (count + evenCount) % MOD;
        //         oddCount++;
        //     }
        // }
        // return count;


        int MOD = 1000000007;
        int n = arr.length;
        int count = 0;
        int oddCount = 0;
        int evenCount = 1;
        int sum = 0;
        for(int i = 0 ; i < n ; i++){
            sum += arr[i];
            if(sum % 2 == 0){ // even + odd => odd
                count = (count + oddCount) % MOD;
                evenCount++;
            }
            else{ // odd + even => odd
                count = (count + evenCount) % MOD;
                oddCount++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int[] arr = {1,3,5};
        System.out.println(numOfSubarrays(arr));
    }
}
