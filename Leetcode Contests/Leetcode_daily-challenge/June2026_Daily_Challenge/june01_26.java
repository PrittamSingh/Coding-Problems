import java.util.*;
public class june01_26 {
    public static int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int n = cost.length;
        int count = 0;
        int totCost = 0;
        for(int i = n - 1 ; i >= 0 ; i--){
            if(count == 2){
                count = 0;
                continue;
            }
            count++;
            totCost += cost[i];
        }
        return totCost;
    }
    public static void main(String[] args) {
        int[] cost = {1,2,3};
        int[] cost2 = {6,5,7,9,2,2};
        System.out.println(minimumCost(cost) + " " + minimumCost(cost2));
    }
}
