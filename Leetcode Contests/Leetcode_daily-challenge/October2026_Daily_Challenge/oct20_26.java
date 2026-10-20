import java.util.Arrays;

public class oct20_26 {
    public static int sortableIntegers(int[] nums) {
        int n = nums.length;
        int[] sorted = nums.clone();
        Arrays.sort(sorted);
        int sum = 0;
        for(int k = 1 ; k <= n ; k++){
            if(n % k != 0) continue;
            if(isValid(nums, sorted, k)){
                sum += k;
            }
        }
        return sum;
    }
    public static boolean isValid(int[] nums, int[] sorted, int k){
        int n = nums.length;
        for(int i = 0 ; i < n ; i += k){
            if(!isRotation(nums, sorted, i, k)){
                return false;
            }
        }
        return true;
    }
    public static boolean isRotation(int[] nums, int[] sorted, int left, int k){
        StringBuilder a = new StringBuilder();
        StringBuilder b = new StringBuilder();
        for(int i = 0 ; i < k ; i++){
            a.append(nums[left + i]).append(",");
            b.append(sorted[left + i]).append(",");
        }
        String A = a.toString();
        String B = b.toString();
        return (B + B).contains(A);
    }
    public static void main(String[] args) {
        int[] nums = {3,1,2};
        System.out.println(sortableIntegers(nums));
    }
}
