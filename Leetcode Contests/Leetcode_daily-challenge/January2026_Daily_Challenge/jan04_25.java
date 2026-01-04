import java.util.Arrays;

public class jan04_25 {
    // public int sumFourDivisors(int[] nums) {
    //     int total = 0;
    //     for(int num : nums){
    //         int cnt = 0, sum = 0;
    //         for(int i = 1 ; i * i <= num ; i++){
    //             if(num % i == 0){
    //                 int other = num / i;
    //                 sum += i; cnt++;
    //                 if(other != i){
    //                     sum += other;
    //                     cnt++;
    //                 }
    //                 if(cnt > 4){
    //                     break;
    //                 }
    //             }
    //         }
    //         if(cnt == 4){
    //             total += sum; 
    //         }
    //     }
    //     return total;
    // }


    static int[] count;
    static int[] sum;
    static boolean built = false;
    final static int MAX_VALUE = 100000;

    static void solve(){
        if(built) return;
        built = true;
        count = new int[MAX_VALUE + 1];
        sum = new int[MAX_VALUE + 1];
        Arrays.fill(count, 1);
        Arrays.fill(sum, 1);
        for(int i = 2 ; i <= MAX_VALUE ; i++){
            for(int j = i ; j <= MAX_VALUE ; j+= i){
                count[j]++;
                sum[j] += i;
            }
        }
    }

    public static int sumFourDivisors(int[] nums){
        solve();
        int ans = 0;
        for(int num : nums){
            if(count[num] == 4){
                ans += sum[num];
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] nums = {21,4,7};
        int[] nums2 = {21,21};
        System.out.println(sumFourDivisors(nums) + " " + sumFourDivisors(nums2));
    }
}
