import java.util.Arrays;

public class aug08_26 {
    public static int[] validSequence(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[] rightHandSideMatchLength = new int[n + 1];
        Arrays.fill(rightHandSideMatchLength, 0);
        int rightMatched = 0;
        int i = n - 1;
        int j = m - 1;
        while(i >= 0){
            if(j >= 0 && word1.charAt(i) == word2.charAt(j)){
                rightMatched++;
                j--;
            }
            rightHandSideMatchLength[i] = rightMatched;
            i--;
        }
        int[] seq = new int[m];
        boolean changePower = true;
        i = 0;
        j = 0;
        int k = 0;
        while(i < n && j < m){
            if(word1.charAt(i) == word2.charAt(j)){
                seq[k] = i;
                j++;
                k++;
            }
            else if(changePower && rightHandSideMatchLength[i + 1] >= m - j - 1){
                seq[k] = i;
                j++;
                k++;
                changePower = false;
            }
            i++;
        }
        int[] ans = new int[0];
        return j == m ? seq : ans;
    }
    public static void main(String[] args) {
        String word1 = "vbcca";
        String word2 = "abc";
        int[] ans = validSequence(word1, word2);
        System.out.println(Arrays.toString(ans));
    }
}
