import java.util.ArrayList;
import java.util.List;

public class june08_26 {
    public static int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        List<Integer> smaller = new ArrayList<>();
        List<Integer> greater = new ArrayList<>();
        int[] ans = new int[n];
        int j = 0;
        int pivotCount = 0;
        for(int i = 0 ; i < n ; i++){
            if(nums[i] < pivot){
                smaller.add(nums[i]);
                ans[j] = nums[i];
                j++;
            }
            else if(nums[i] > pivot){
                greater.add(nums[i]);
            }
            else{
                pivotCount++;
            }
        }
        for(int i = 0 ; i < pivotCount ; i++){
            ans[j] = pivot;
            j++;
        }
        for(int i = 0 ; i < greater.size() ; i++){
            ans[j] = greater.get(i);
            j++;
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] nums = {9,12,5,10,14,3,10};
        int pivot = 10;
        int[] ans = pivotArray(nums, pivot);
        for(int num : ans){
            System.out.print(num + " ");
        }
    }
}
