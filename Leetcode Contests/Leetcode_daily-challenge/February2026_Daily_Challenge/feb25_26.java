import java.util.*;
public class feb25_26 {
    public static int countOneBits(int num) {
        int count = 0;
        while (num != 0) {
            count += num & 1;
            num >>= 1;
        }
        return count;
    }
    public static int[] sortByBits(int[] arr) {
        Integer[] boxedArr = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            boxedArr[i] = arr[i];
        }
        Arrays.sort(boxedArr, (a, b) -> {
            int countA = countOneBits(a);
            int countB = countOneBits(b);
            if (countA == countB) {
                return a.compareTo(b);
            }
            return Integer.compare(countA, countB);
        });
        for (int i = 0; i < arr.length; i++) {
            arr[i] = boxedArr[i];
        }
        return arr;
    }
    public static void main(String[] args) {
        int[] arr = {0,1,2,3,4,5,6,7,8};
        int[] res = sortByBits(arr);
        for(int i = 0 ; i < res.length ; i++){
            System.err.print(res[i] + " ");
        }
    }
}
