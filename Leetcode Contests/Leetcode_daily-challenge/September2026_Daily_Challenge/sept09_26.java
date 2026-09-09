public class sept09_26 {
    public static long countCommas(long n) {
        // if(n <= 999) return 0;
        // if(n <= 999999) return n - 999;
        // if(n <= 999999999) return (999999 - 999) + 2 * (n - 999999);
        // if(n <= 999999999999L) return (999999 - 999) + 2 * (999999999 - 999999) + 3 * (n - 999999999);
        // if(n <= 999999999999999L) return (999999 - 999) + 2 * (999999999 - 999999) + 3 * (999999999999L - 999999999) + 4 * (n - 999999999999L);
        // if(n <= 999999999999999999L) return (999999 - 999) + 2 * (999999999 - 999999) + 3 * (999999999999L - 999999999) + 4 * (999999999999999L - 999999999999L) + 5 * (n - 999999999999999L);
        // return 1;



        long ans = 0;
        for(int i = 3 ; i < 16 ; i += 3){
            long base = (long)Math.pow(10, i);
            if(n < base) break;
            ans += n - base + 1;
        }
        return ans;
    }
    public static void main(String[] args) {
        int  n = 1002;
        System.out.println(countCommas(n));
    }
}
