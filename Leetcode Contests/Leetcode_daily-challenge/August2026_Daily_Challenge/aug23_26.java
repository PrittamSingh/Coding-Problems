public class aug23_26 {
    public static boolean sumGame(String num) {
        int n = num.length();
        int leftKnownSum = 0;
        int rightKnownSum = 0;
        int leftQnMarkCount = 0;
        int rightQnMarkCount = 0;
        for(int i = 0 ; i < n ; i++){
            char ch = num.charAt(i);
            if(ch == '?'){
                if(i < n / 2){
                    leftQnMarkCount++;
                }
                else{
                    rightQnMarkCount++;
                }
            }
            else{
                if(i < n / 2){
                    leftKnownSum += ch - '0';
                }
                else{
                    rightKnownSum += ch - '0';
                }
            }
        }
        int totalQuesMark = leftQnMarkCount + rightQnMarkCount;
        if(totalQuesMark % 2 != 0){
            return true;
        }
        int left = (2 * leftKnownSum) + (9 * leftQnMarkCount);
        int right = (2 * rightKnownSum) + (9 * rightQnMarkCount);
        if(left == right){
            return false;
        }
        return true;
    }
    public static void main(String[] args) {
        String num = "?3295???";
        String num1 = "25??";
        System.out.println(sumGame(num) + " " + sumGame(num1));
    }
}
