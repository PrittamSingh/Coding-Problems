public class aug10_26 {
    // int[] t;
    // private boolean solve(int n) {
    //     if(n == 0){
    //         return false;
    //     }
    //     if(t[n] != -1){
    //         return t[n] == 1 ? true : false;
    //     }
    //     for(int k = 1 ; k * k <= n ; k++){
    //         if(solve(n - (k * k)) == false){
    //             t[n] = 1;
    //             return true;
    //         }
    //     }
    //     t[n] = 0;
    //     return false;
    // }
    // public boolean winnerSquareGame(int n) {
    //     t = new int[n+1];
    //     Arrays.fill(t, -1);
    //     return solve(n);
    // }



    public static boolean winnerSquareGame(int n) {
        boolean[] t = new boolean[n+1];
        t[0] = false;
        for(int i = 1 ; i < n + 1 ; i++){
            for(int k = 1 ; k * k <= i ; k++){
                if(t[i - (k * k)] == false){
                    t[i] = true;
                    break;
                }
            }
        }
        return t[n];
    }
    public static void main(String[] args) {
        int n = 1;
        System.out.println(winnerSquareGame(n));
    }
}
