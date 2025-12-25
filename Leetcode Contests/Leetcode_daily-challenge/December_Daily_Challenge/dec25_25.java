import java.util.Arrays;

public class dec25_25 {
    public static long maximumHappinessSum(int[] happiness, int k) {
        long happinessValue = 0;
        Arrays.sort(happiness);
        int i = happiness.length - 1;
        for(int j = 0 ; j < k ; j++){
            if(happiness[i] > j){
                happinessValue += happiness[i] - j;
            }
            else{
                happinessValue += 0;
            }
            i--;
        }
        return happinessValue;
    }
    public static void main(String[] args) {
        int[] happiness = {1,2,3};
        int k = 2;
        int[] happiness2 = {1,1,1,1};
        int k2 = 2;
        int[] happiness3 = {2,3,4,5};
        int k3 = 1;
        System.out.println(maximumHappinessSum(happiness, k) + " " + maximumHappinessSum(happiness2, k2) + " " + maximumHappinessSum(happiness3, k3));
    }
}
