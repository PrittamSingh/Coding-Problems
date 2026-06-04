public class june04_26 {
    public static int totalWaviness(int num1, int num2) {
        int total = 0;
        for(int num = num1 ; num <= num2 ; num++){
            total += waviness(num);
        }
        return total;
    }
    private static int waviness(int num){
        String s = String.valueOf(num);
        if(s.length() < 3) return 0;
        int count = 0;
        for(int i = 1 ; i < s.length() - 1 ; i++){
            int left = s.charAt(i - 1) - '0';
            int mid = s.charAt(i) - '0';
            int right = s.charAt(i + 1) - '0';

            if(mid < left && mid < right) count++;
            if(mid > left && mid > right) count++;
        }
        return count;
    }
    public static void main(String[] args) {
        int num1 = 120;
        int num2 = 130;
        System.out.println(totalWaviness(num1, num2));
    }
}
