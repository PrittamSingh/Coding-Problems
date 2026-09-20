public class sept20_26 {
    public static int reverseDegree(String s) {
        // int sum = 0;
        // for(int i = 0 ; i < s.length() ; i++){
        //     char ch = s.charAt(i);
        //     int reverseIdx = 26 - (ch - 'a');
        //     int idx = i + 1;
        //     int mul = reverseIdx * idx;
        //     sum += mul;
        // }
        // return sum;

        int sum = 0;
        for(int i = 0 ; i < s.length() ; i++){
            sum += (26 - (s.charAt(i) - 'a')) * (i + 1);
        }
        return sum;
    }
    public static void main(String[] args) {
        String s = "abc";
        System.out.println(reverseDegree(s));
    }
}
