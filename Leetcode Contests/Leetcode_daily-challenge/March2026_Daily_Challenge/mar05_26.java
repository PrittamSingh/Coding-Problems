public class mar05_26 {
    public static int minOperations(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append('0');
        StringBuilder sb1 = new StringBuilder();
        sb1.append('1');
        for(int i = 1 ; i < s.length() ; i++){
            if(sb.charAt(i - 1) == '0'){
                sb.append('1');
            }
            else if(sb.charAt(i - 1) == '1'){
                sb.append('0');
            }
            if(sb1.charAt(i - 1) == '0'){
                sb1.append('1');
            }
            else if(sb1.charAt(i - 1) == '1'){
                sb1.append('0');
            }
        }
        int operation1 = 0;
        int operation2 = 0;
        for(int i = 0 ; i < s.length() ; i++){
            if(s.charAt(i) != sb.charAt(i)){
                operation1++;
            }
            if(s.charAt(i) != sb1.charAt(i)){
                operation2++;
            }
        }
        return Math.min(operation1, operation2);
    }
    public static void main(String[] args) {
        String s = "0100";
        String s2 = "10";
        String s3 = "1111";
        System.out.println(minOperations(s) + " " + minOperations(s2) + " " + minOperations(s3));
    }
}
