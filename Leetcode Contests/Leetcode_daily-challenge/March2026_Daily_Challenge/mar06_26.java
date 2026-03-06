public class mar06_26 {
    public static boolean checkOnesSegment(String s) {
        int n = s.length();
        int firstZero = 0;
        for(int i = 0 ; i < n ; i++){
            if(s.charAt(i) == '0'){
                firstZero = i;
                break;
            }
        }
        if(firstZero == 0) return true;
        for(int i = firstZero + 1 ; i < n ; i++){
            if(s.charAt(i) == '1'){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        String s = "1001";
        String s2 = "110";
        System.out.println(checkOnesSegment(s) + " " + checkOnesSegment(s2));
    }
}
