import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class july12_26 {
    public static int[] arrayRankTransform(int[] arr) {
        int[] sorted = arr.clone();
        Arrays.sort(sorted);
        Map<Integer, Integer> map = new HashMap<>();
        int rank = 1;
        for(int num : sorted){
            if(!map.containsKey(num)){
                map.put(num, rank);
                rank++;
            }
        }
        int[] res = new int[arr.length];
        for(int i = 0 ; i < arr.length ; i++){
            res[i] = map.get(arr[i]);
        }
        return res;
    }
    public static void main(String[] args) {
        int[] arr = {40,10,20,30};
        System.out.println(Arrays.toString(arrayRankTransform(arr)));
    }
}
