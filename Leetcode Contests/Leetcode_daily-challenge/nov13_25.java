public class nov13_25 {
    public static int maxOperations(String s) {
        int n = s.length();
        int ones = 0 , operations = 0;
        for(int i = 0 ; i < n - 1 ; i++){
            if(s.charAt(i) == '1'){
                ones++;
            }
            if(s.charAt(i) == '1' && s.charAt(i + 1) == '0'){
                operations += ones;
            }
        }
        return operations;
    }
    public static void main(String[] args) {
        String s = "1001101";
        System.out.println(maxOperations(s));
        String s2 = "00111";
        System.out.println(maxOperations(s2));
    }
}
