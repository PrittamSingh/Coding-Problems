import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class aug20_26 {
    public static int[] resultArray(int[] nums) {
        List<Integer> arr1 = new ArrayList<>();
        List<Integer> arr2 = new ArrayList<>();
        arr1.add(nums[0]);
        arr2.add(nums[1]);
        for(int i = 2 ; i < nums.length ; i++){
            if(arr1.get(arr1.size() - 1) > arr2.get(arr2.size() - 1)){
                arr1.add(nums[i]);
            }
            else{
                arr2.add(nums[i]);
            }
        }
        int[] res = new int[nums.length];
        int k = 0;
        for(int i = 0 ; i < arr1.size() ; i++){
            res[k++] = arr1.get(i);
        }
        for(int i = 0 ; i < arr2.size() ; i++){
            res[k++] = arr2.get(i);
        }
        return res;
    }
    public static void main(String[] args) {
        int[] nums = {5,4,3,8};
        System.out.println(Arrays.toString(resultArray(nums)));
    }
}
