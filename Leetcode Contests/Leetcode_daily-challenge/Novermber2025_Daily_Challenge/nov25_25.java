public class nov25_25 {
    public static int smallestRepunitDivByK(int k) {
        if(k % 2 == 0 || k % 5 == 0){
            return -1;
        }
        int len = 1;
        int rem = 1 % k;
        while(rem != 0 && len <= k){
            rem = (rem * 10 + 1) % k;
            len++;
        }
        return rem == 0 ? len : -1;
    }
    public static void main(String[] args) {
        int k = 1 , k2 = 2 , k3 = 3;
        System.out.println(smallestRepunitDivByK(k) + " " + smallestRepunitDivByK(k2) + " " + smallestRepunitDivByK(k3));
    }
}
