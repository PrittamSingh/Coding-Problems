public class july25_26 {
    public static int maxProduct(int n) {
        int largest = 0;
        int sndLargest = 0;
        while(n > 0){
            int d = n % 10;
            if(d > largest){
                sndLargest = largest;
                largest = d;
            }
            else if(d > sndLargest){
                sndLargest = d;
            }
            n /= 10;
        }
        return largest * sndLargest;
    }
    public static void main(String[] args) {
        int n = 31;
        System.out.println(maxProduct(n));
    }
}
