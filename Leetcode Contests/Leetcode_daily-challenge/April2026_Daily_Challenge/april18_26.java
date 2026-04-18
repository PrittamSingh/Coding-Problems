public class april18_26 {
    public static int mirrorDistance(int n) {
        int rev = reverse(n);
        return Math.abs(n - rev);
    }
    public static int reverse(int num){
        int rev = 0;
        while(num > 0){
            rev = rev * 10 + (num % 10);
            num /= 10;
        }
        return rev;
    }
    public static void main(String[] args) {
        int n = 25;
        int n2 = 10;
        System.out.println(mirrorDistance(n) + " " + mirrorDistance(n2));
    }
}
