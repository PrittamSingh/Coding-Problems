public class sept08_26 {
    public static  int countCommas(int n) {
        if(n < 1000){
            return 0;
        }
        return n - 999;
    }
    public static void main(String[] args) {
        int n = 1002;
        System.out.println(countCommas(n));
    }
}
