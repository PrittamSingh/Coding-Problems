public class dec07_25 {
    public static int countOdds(int low, int high) {
        if(low % 2 == 0 && high % 2 == 0){
            return (high - low) / 2;
        }
        // else if(low % 2 == 1 && high % 2 == 1){
        //     return ((high - low) / 2) + 1;
        // }
        else{
            return ((high - low) / 2) + 1;
        }
    }
    public static void main(String[] args) {
        int low = 3, high = 7;
        int low2 = 8, high2 = 10;
        System.out.println(countOdds(low, high) + " " + countOdds(low2, high2));
    }
}
