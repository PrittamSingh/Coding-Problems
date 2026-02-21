import java.util.*;
public class feb21_26 {
    public static int countPrimeSetBits(int left, int right) {
        int result = 0;
        HashSet<Integer> primes = new HashSet<Integer>(Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19));
        for(int num = left; num <= right; num++) {
            int setBits = Integer.bitCount(num);
            if(primes.contains(setBits)) {
                result++;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int left = 6, right = 10;
        int left1 = 10, right1 = 15;
        System.out.println(countPrimeSetBits(left, right) + " " + countPrimeSetBits(left1, right1));
    }
}
