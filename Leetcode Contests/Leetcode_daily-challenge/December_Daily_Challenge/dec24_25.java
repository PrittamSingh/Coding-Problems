import java.util.*;
public class dec24_25 {
    public static int minimumBoxes(int[] apple, int[] capacity) {
        int m = capacity.length;
        Arrays.sort(capacity);
        int total = 0;
        for(int a : apple){
            total += a;
        }
        int minBoxes = 0;
        for(int i = m - 1 ; i >= 0 && total > 0 ; i--){
                minBoxes++;
                total -= capacity[i];
        }
        return minBoxes;
    }
    public static void main(String[] args) {
        int[] apple = {1,3,2}, capacity = {4,3,1,5,2};
        int[] apple2 = {5,5,5}, capacity2 = {2,4,2,7};
        System.out.println(minimumBoxes(apple, capacity) + " " + minimumBoxes(apple2, capacity2));
    }
}
