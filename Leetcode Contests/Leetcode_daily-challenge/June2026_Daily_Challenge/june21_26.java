public class june21_26 {
    public static int maxIceCream(int[] costs, int coins) {
        // NAIVE APPROACH
        // int n = costs.length;
        // Arrays.sort(costs);
        // int maxIcecream = 0;
        // for(int i = 0 ; i < n ; i++){
        //     if(costs[i] <= coins){
        //         maxIcecream++;
        //         coins -= costs[i];
        //     }
        //     else{
        //         break;
        //     }
        // }
        // return maxIcecream;



        // COUNTING SORTING
        int n = costs.length;
        int max = Integer.MIN_VALUE;
        for(int i = 0 ; i < n ; i++){
            max = Math.max(max, costs[i]);
        }
        int[] countArray = new int[max + 1];
        for(int i = 0 ; i < n ; i++){
            countArray[costs[i]]++;
        }
        int j = 0;
        for(int i = 0 ; i <= max ; i++){
            while(countArray[i] > 0){
                costs[j] = i;
                countArray[i]--;
                j++;
            }
        }
        int maxIcecream = 0;
        for(int i = 0 ; i < n ; i++){
            if(costs[i] <= coins){
                maxIcecream++;
                coins -= costs[i];
            }
            else{
                break;
            }
        }
        return maxIcecream;
    }
    public static void main(String[] args) {
        int[] costs = {1,3,2,4,1};
        int coins = 7;
        System.out.println(maxIceCream(costs, coins));
    }
}
