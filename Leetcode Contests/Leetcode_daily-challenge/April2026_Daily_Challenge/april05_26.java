public class april05_26 {
    public static boolean judgeCircle(String moves) {
        int i = 0;
        int j = 0;
        for(char ch : moves.toCharArray()){
            if(ch == 'R'){
                j = j + 1;
            }
            else if(ch == 'L'){
                j = j - 1;
            }
            else if(ch == 'U'){
                i = i - 1;
            }
            else{
                i = i + 1;
            }
        }
        if(i == 0 && j == 0){
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        String moves = "UD";
        String moves2 = "LL";
        System.out.println(judgeCircle(moves) + " " + judgeCircle(moves2));
    }
}
