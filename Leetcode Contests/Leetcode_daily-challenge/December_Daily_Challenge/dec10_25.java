public class dec10_25 {
    public static int countPermutations(int[] complexity) {
        int n = complexity.length;
        long ans = 1;
        int MOD = 1000000007;
        for(int i = 1 ; i < n ; i++){
            if(complexity[i] <= complexity[0]){
                return 0;
            }
            ans = (ans * i) % MOD;
        }
        return (int)ans;
    }
    public static void main(String[] args) {
        int[] complexity = {1,2,3};
        int[] complexity2 = {3,3,3,4,4,4};
        System.out.println(countPermutations(complexity) + " " + countPermutations(complexity2));
    }
}
