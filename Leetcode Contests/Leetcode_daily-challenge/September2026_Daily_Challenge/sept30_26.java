import java.util.Arrays;

public class sept30_26 {
    public static int[] maxDepthAfterSplit(String seq) {
        int n = seq.length();
        int[] res = new int[n];
        int depthA = 0;
        int depthB = 0;
        for(int i = 0 ; i < n ; i++){
            char ch = seq.charAt(i);
            if(ch == '('){
                if(depthA > depthB){
                    res[i] = 1;
                    depthB++;
                }
                else{
                    res[i] = 0;
                    depthA++;
                }
            }
            else{
                if(depthA > depthB){
                    res[i] = 0;
                    depthA--;
                }
                else{
                    res[i] = 1;
                    depthB--;
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
        String seq = "(()())";
        System.out.println(Arrays.toString(maxDepthAfterSplit(seq)));
    }
}
