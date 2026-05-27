import java.util.Arrays;

public class may27_26 {
    public static int numberOfSpecialChars(String word) {
        int n = word.length();
        int[] pos = new int[26];
        Arrays.fill(pos, -1);
        for(int i = 0 ; i < n ; i++){
            char ch = word.charAt(i);
            if(ch >= 'a' && ch <= 'z'){
                pos[ch - 'a'] = i;
            }
        }
        int count = 0;
        int[] posCapital = new int[26];
        Arrays.fill(posCapital, -1);
        boolean[] seen = new boolean[26];
        for(int i = 0 ; i < n ; i++){
            char ch = word.charAt(i);
            if(ch >= 'A' && ch <= 'Z'){
                if(posCapital[ch - 'A'] == -1){
                    posCapital[ch - 'A'] = i;
                }
                if(posCapital[ch - 'A'] > pos[ch - 'A'] && !seen[ch - 'A'] && pos[ch - 'A'] != -1){
                    count++;
                    seen[ch - 'A'] = true;
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {
        String word = "aaAbcBC";
        String word1 = "AbBCab";

        System.out.println(numberOfSpecialChars(word));
        System.out.println(numberOfSpecialChars(word1));
    }
}
