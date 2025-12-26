public class dec26_25 {
    public static int bestClosingTime(String customers) {
        //Approach-1 BRUTE - FORCE APPROACH
        // int n = customers.length();
        // int minPenalty = Integer.MAX_VALUE;
        // int bestHour = 0;
        // for(int j = 0 ; j <= n ; j++){
        //     int penalty = 0;
        //     for(int i = 0 ; i < j ; i++){
        //         if(customers.charAt(i) == 'N'){
        //             penalty++;
        //         }
        //     }
        //     for(int i = j ; i < n ; i++){
        //         if(customers.charAt(i) == 'Y'){
        //             penalty++;
        //         }
        //     }
        //     if(penalty < minPenalty){
        //         minPenalty = penalty;
        //         bestHour = j;
        //     }
        // }
        // return bestHour;

        // Approach-2 PrefixN and SuffixY
        // int n = customers.length();
        // int[] prefixN = new int[n + 1]; //N before the ith index
        // int[] suffixY = new int[n + 1]; //Y from and after the ith index
        // for(int i = 0 ; i < n ; i++){
        //     prefixN[i + 1] = prefixN[i] + (customers.charAt(i) == 'N' ? 1 : 0);
        // }
        // for(int i = n - 1 ; i >= 0 ; i--){
        //     suffixY[i] = suffixY[i + 1] + (customers.charAt(i) == 'Y' ? 1 : 0);
        // }
        // int minPenalty = Integer.MAX_VALUE;
        // int bestHour = 0;

        // for(int j = 0 ; j <= n ; j++){
        //     int penalty = prefixN[j] + suffixY[j];
        //     if(penalty < minPenalty){
        //         minPenalty = penalty;
        //         bestHour = j;
        //     }
        // }
        // return bestHour;


        // Approach-3 Greedy - Approach
        int n = customers.length();
        int currPenalty = 0;
        for(int i = 0 ; i < n ; i++){
            if(customers.charAt(i) == 'Y'){
                currPenalty++;
            }
        }
        int minPenalty = currPenalty;
        int bestHour = 0;
        for(int i = 0 ; i < n ; i++){
            if(customers.charAt(i) == 'Y'){
                currPenalty--;
            } else{
                currPenalty++;
            }
            if(currPenalty < minPenalty){
                minPenalty = currPenalty;
                bestHour = i + 1;
            }
        }
        return bestHour;

    }
    public static void main(String[] args) {
        String customers1 = "YYNY";
        String customers2 = "NNNNN";
        String customers3 = "YYYY";
        System.out.println(bestClosingTime(customers1) + " " + bestClosingTime(customers2) + " " + bestClosingTime(customers3));
    }
}
