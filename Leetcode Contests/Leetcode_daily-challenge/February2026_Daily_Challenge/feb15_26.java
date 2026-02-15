public class feb15_26 {
    public static String addBinary(String a, String b) {
        StringBuilder res = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        while(i >= 0 || j >= 0 || carry > 0){
            int sum = carry;
            if(i >= 0){
                sum = sum + a.charAt(i) - '0';
                i--;
            }
            if(j >= 0){
                sum = sum + b.charAt(j) - '0';
                j--;
            }
            res.append(sum % 2);
            carry = sum / 2;
        }
        return res.reverse().toString();
    }
    public static void main(String[] args) {
        String a = "11", b = "1";
        String a1 = "1010", b1 = "1011";
        System.out.println(addBinary(a, b) + " " + addBinary(a1, b1));
    }
}
