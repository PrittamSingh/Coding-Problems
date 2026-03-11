public class mar11_26 {
    public static int bitwiseComplement(int n) {
        if(n == 0) return 1;
        int bits = (int)(Math.log(n) / Math.log(2)) + 1;
        int mask = (1 << bits) - 1;
        return mask ^ n;




        // int mask = 1;
        // while(mask < n){
        //     mask = (mask << 1) | 1;
        // }
        // return mask ^ n;


        // if(n == 0) return 1;
        // int counter = 0;
        // long result = 0;
        // while(n != 0 ){
        //     int r = n % 2;
        //     int flippedR = (r == 0) ? 1 : 0;
        //     result += Math.pow(2, counter) * flippedR;
        //     n /= 2;
        //     counter++;
        // }
        // return (int)result;
    }
    public static void main(String[] args) {
        int n = 5;
        int n2 = 7;
        int n3 = 10;
        System.out.println(bitwiseComplement(n) + " " + bitwiseComplement(n2) + " " + bitwiseComplement(n3));
    }
}
