public class aug02_26 {
    public static boolean stoneGame(int[] piles) {
        int n = piles.length;
        int i = 0;
        int j = n - 1;
        int sumAlice = 0;
        int sumBob = 0;
        boolean alice = true;
        while(i != j){
            if(alice){
                if(piles[i] > piles[j]){
                    sumAlice += piles[i];
                    i++;
                }
                else{
                    sumAlice += piles[j];
                    j--;
                }
            }
            else{
                if(piles[i] > piles[j]){
                    sumBob += piles[i];
                    i++;
                }
                else{
                    sumBob += piles[j];
                    j--;
                }
            }
        }
        return sumAlice > sumBob;
    }
    public static void main(String[] args) {
        int[] piles = {5,3,4,5};
        System.out.println(stoneGame(piles));
    }
}
