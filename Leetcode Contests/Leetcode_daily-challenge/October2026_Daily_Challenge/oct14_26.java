public class oct14_26 {
    public static String maxSumOfSquares(int num, int sum) {
        StringBuilder sb = new StringBuilder();
        while(sum > 0 && num > 0){
            int curr = Math.min(9, sum);
            char ch = (char) (curr + '0');
            sb.append(ch);
            sum -= curr;
            num--;
        }
        if(sum > 0){
            return "";
        }
        while(num > 0){
            sb.append('0');
            num--;
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        int num = 2, sum = 3;
        System.out.println(maxSumOfSquares(num, sum));
    }
}
