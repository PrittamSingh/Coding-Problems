public class dec14_25 {
    public static int numberOfWays(String corridor) {
        final int MOD = 1000000007;
        int count = 0;
        int prefix = 0;
        int ans = 1;
        for(char c : corridor.toCharArray()){
            if(c == 'S'){
                prefix++;
            }
            if(prefix == 2){
                count++;
            }
            if(prefix == 3){
                ans = (int)(((long)ans * count) % MOD);
                count = 0;
                prefix = 1;
            }
        }
        if(prefix != 2){
            return 0;
        }
        return ans;
    }
    public static void main(String[] args) {
        String corridor1 = "SSPPSPS";
        String corridor2 = "PPSPSP";
        String corridor3 = "S";
        System.out.println(numberOfWays(corridor1) + " " + numberOfWays(corridor2) + " " + numberOfWays(corridor3));
    }
}
