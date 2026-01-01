public class jan01_25 {
    public static int[] plusOne(int[] digits) {
        int n = digits.length;
        for(int i = n - 1 ; i >= 0 ; i--){
            if(digits[i] < 9){
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] result = new int[n + 1];
        result[0] = 1;
        return result;
    }
    public static void main(String[] args) {
        int[] digits = {1,2,3};
        int[] ans = plusOne(digits);
        for(int i = 0 ; i < ans.length ; i++){
            System.out.print(ans[i] + " ");
        }
    }
}
