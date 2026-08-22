public class aug22_26 {
    public static boolean checkDivisibility(int n) {
        int temp = n;
        int sum = 0;
        int product = 1;
        while(n > 0){
            int d = n % 10;
            sum += d;
            product *= d;
            n /= 10;
        }
        int div = sum + product;
        // System.out.println(div);
        return (temp % div == 0);
    }
    public static void main(String[] args) {
        int n = 99;
        int n2 = 23;
        System.out.println(checkDivisibility(n) + " " + checkDivisibility(n2));
    }
}
