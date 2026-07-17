import java.util.Arrays;

public class july17_26 {
    public static int[] gcdValues(int[] nums, long[] queries) {
        int max = 0;
        for(int num : nums){
            max = Math.max(max, num);
        }
        int[] freq = new int[max + 1];
        for(int num : nums){
            freq[num]++;
        }
        long[] divisibleCount = new long[max + 1]; // divisible[i] = number of numbers divsible by i
        for(int i = 1 ; i <= max ; i++){
            for(int multiple = i ; multiple <= max ; multiple += i){
                divisibleCount[i] += freq[multiple];
            }
        }
        long[] exactPairs = new long[max + 1]; // exactPairs[i] = pairs having gcd exactly i
        for(int i = max ; i >= 1 ; i--){
            long count = divisibleCount[i];
            exactPairs[i] = count * (count - 1) / 2;
            for(int multiple = i * 2 ; multiple <= max ; multiple += i){
                exactPairs[i] -= exactPairs[multiple];
            }
        }
        long[] prefix = new long[max + 1]; // prefix[i] = total pairs having gcd <= i
        for(int i = 1 ; i <= max ; i++){
            prefix[i] = prefix[i - 1] + exactPairs[i];
        }
        int[] ans = new int[queries.length];
        for(int i = 0 ; i < queries.length ; i++){
            // smallest gcd chahiye jiska prefix se bada ya equal ho
            long target = queries[i] + 1;
            int low = 1, high = max;
            while(low < high){
                int mid = low + (high - low) / 2;
                if(prefix[mid] >= target){
                    high = mid;
                }
                else{
                    low = mid + 1;
                }
            }
            ans[i] = low;
        }
        return ans;
    }





    // public int[] gcdValues(int[] nums, long[] queries) {
    //     int n = nums.length;
    //     List<Integer> list = new ArrayList<>();
    //     for(int i = 0 ; i < n ; i++){
    //         for(int j = i + 1 ; j < n ; j++){
    //             int gcd = findGCD(nums[i], nums[j]);
    //             list.add(gcd);
    //         }
    //     }
    //     Collections.sort(list);
    //     int[] ans = new int[queries.length];
    //     for(int i = 0 ; i < queries.length ; i++){
    //         ans[i] = list.get((int)queries[i]);
    //     }
    //     return ans;
    // }
    // public int findGCD(int a, int b){
    //     if(b > a){
    //         int temp = b;
    //         b = a;
    //         a = temp;
    //     }
    //     while(b != 0){
    //         int temp = b;
    //         b = a % b;
    //         a = temp;
    //     }
    //     return a;
    // }
    public static void main(String[] args) {
        int[] nums = {2,3,4};
        long[] queries = {0,2,2};
        System.out.println(Arrays.toString(gcdValues(nums, queries)));
    }
}
