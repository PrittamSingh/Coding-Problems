public class april24_26 {
    public static int furthestDistanceFromOrigin(String moves) {
        int left = 0;
        int right = 0;
        int underscore = 0;
        for(int i = 0 ; i < moves.length() ; i++){
            char ch = moves.charAt(i);
            if(ch == 'L'){
                left++;
            }
            else if(ch == 'R'){
                right++;
            }
            else{
                underscore++;
            }
        }
        if(left > right){
            return left + underscore - right;
        }
        else{
            return right + underscore - left;
        }
    }
    public static void main(String[] args) {
        String moves = "L_RL__R";
        System.out.println(furthestDistanceFromOrigin(moves));
    }
}
