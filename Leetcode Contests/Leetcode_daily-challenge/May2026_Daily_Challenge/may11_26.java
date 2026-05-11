import java.util.ArrayList;
import java.util.List;

public class may11_26 {
    public static int[] separateDigits(int[] nums) {
        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        for(int i = n - 1 ; i >= 0 ; i--){
            int num = nums[i];
            while(num > 0){
                int d = num % 10;
                list.add(d);
                num /= 10;
            }
        }
        int len = list.size();
        int[] ans = new int[len];
        for(int i = 0 ; i < len ; i++){
            ans[i] = list.get(len - 1 - i);
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] nums = {13,25,83,77};
        int[] ans = separateDigits(nums);
        for(int i : ans){
            System.out.print(i + " ");
        }
    }
}
