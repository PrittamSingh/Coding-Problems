public class aug06_26 {
    public static int smallestNumber(int n, int t) {
        for(int i = n ; ; i++){
            int prod = 1;
            int temp = i;
            while(temp > 0){
                int d = temp % 10;
                prod *= d;
                temp /= 10;
            }
            if(prod % t == 0){
                return i;
            }
        }
    }
    public static void main(String[] args) {
        int n = 10;
        int t = 2;
        System.out.println(smallestNumber(n, t));
    }
}
