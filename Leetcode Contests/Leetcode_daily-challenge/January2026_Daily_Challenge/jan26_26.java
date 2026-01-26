import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class jan26_26 {
    public static List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        for(int i = 0 ; i < arr.length - 1 ; i++){
            int currMin = arr[i + 1] - arr[i];
            min = Math.min(min, currMin);
        }
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0 ; i < arr.length - 1 ; i++){
            if(arr[i + 1] - arr[i] == min){
                result.add(Arrays.asList(arr[i], arr[i + 1]));
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[] arr = {4,2,1,3};
        int[] arr2 = {1,3,6,10,15};
        int[] arr3 = {3,8,-10,23,19,-4,-14,27};
        System.out.println(minimumAbsDifference(arr));
        System.out.println(minimumAbsDifference(arr2));
        System.out.println(minimumAbsDifference(arr3));
    }
}
