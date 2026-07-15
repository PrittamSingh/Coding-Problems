public class july15_26 {
    public static int gcdOfOddEvenSums(int n) {
        // int sumOdd = 0;
        // int sumEven = 0;
        // int odd = 1;
        // int even = 2;
        // for(int i = 0 ; i < n ; i++){
        //     sumOdd += odd;
        //     odd += 2;
        //     sumEven += even;
        //     even += 2;
        // }
        // int a = sumOdd;
        // int b = sumEven;
        // if(b > a){
        //     int temp = a;
        //     a = b;
        //     b = temp;
        // }
        // while(b != 0){
        //     int temp = b;
        //     b = a % b;
        //     a = temp;
        // }
        // return a;



        return n;
    }
    public static void main(String[] args) {
        int n1 = 4;
        int n2 = 5;
        System.out.println(gcdOfOddEvenSums(n1) + " " + gcdOfOddEvenSums(n2));
    }
}
