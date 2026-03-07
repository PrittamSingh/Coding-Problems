public class mar07_26 {
    public static int minFlips(String s) {
        int n = s.length();
        int i = 0 , j = 0;
        int flip1 = 0;
        int flip2 = 0;
        int result = Integer.MAX_VALUE;
        while(j < 2*n){
            char expectedCharS1 = j % 2 == 0 ? '0' : '1';
            char expectedCharS2 = j % 2 == 0 ? '1' : '0';
            if(s.charAt(j % n) != expectedCharS1) flip1++;
            if(s.charAt(j % n) != expectedCharS2) flip2++;

            if(j - i + 1 > n){
                expectedCharS1 = i % 2 == 0 ? '0' : '1';
                expectedCharS2 = i % 2 == 0 ? '1' : '0';
                if(s.charAt(i % n) != expectedCharS1) flip1--;
                if(s.charAt(i % n) != expectedCharS2) flip2--;
                i++;
            }
            if(j - i + 1 == n){
                result = Math.min(result, Math.min(flip1, flip2));
            }
            j++;
        }
        return result;
    }
    public static void main(String[] args) {
        String s = "111000";
        String s2 = "010";
        String s3 = "1110";
        System.out.println(minFlips(s) + " " + minFlips(s2) + " " + minFlips(s3));
    }



    // public int minFlips(String s) {
    //     int n = s.length();
    //     StringBuilder s1 = new StringBuilder();
    //     StringBuilder s2 = new StringBuilder();
    //     for(int i = 0 ; i < 2*n ; i++){
    //         s1.append(i % 2 == 0 ? '1' : '0'); //101010...
    //         s2.append(i % 2 == 0 ? '0' : '1'); //010101...
    //     }
    //     int i = 0 , j = 0;
    //     int flip1 = 0;
    //     int flip2 = 0;
    //     int result = Integer.MAX_VALUE;
    //     while(j < 2*n){
    //         if(s.charAt(j % n) != s1.charAt(j)) flip1++;
    //         if(s.charAt(j % n) != s2.charAt(j)) flip2++;

    //         if(j - i + 1 > n){
    //             if(s.charAt(i % n) != s1.charAt(i)) flip1--;
    //             if(s.charAt(i % n) != s2.charAt(i)) flip2--;
    //             i++;
    //         }
    //         if(j - i + 1 == n){
    //             result = Math.min(result, Math.min(flip1, flip2));
    //         }
    //         j++;
    //     }
    //     return result;
    // }
}
