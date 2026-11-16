public class nov16_26 {
    public static String digitSum(String s, int k) {
        String temp = s;
        while(temp.length() > k){
            StringBuilder sb = new StringBuilder();
            for(int i = 0 ; i < temp.length() ; i += k){
                String str;
                if(i + k - 1 < temp.length()){
                    str = temp.substring(i, i + k);
                }
                else{
                    str = temp.substring(i, temp.length());
                }
                int sum = 0;
                for(int j = 0 ; j < str.length() ; j++){
                    int d = str.charAt(j) - '0';
                    sum += d;
                }
                sb.append(Integer.toString(sum));
            }
            temp = sb.toString();
        }
        return temp;
    }
    public static void main(String[] args) {
        String s = "11111222223";
        int k = 3;
        System.out.println(digitSum(s, k));
    }
}
