public class feb18_26 {
    public static boolean hasAlternatingBits(int n) {
        int currBit = n % 2;
        n /= 2;
        while (n > 0) {
            if (currBit == n % 2) {
                return false;
            }
            currBit = n % 2;
            n /= 2;
        }
        return true;
    }
    public static void main(String[] args) {
        int n1 = 5;
        int n2 = 7;
        int n3 = 11;
        System.out.println(hasAlternatingBits(n1) + " " + hasAlternatingBits(n2) + " " + hasAlternatingBits(n3));
    }
}
