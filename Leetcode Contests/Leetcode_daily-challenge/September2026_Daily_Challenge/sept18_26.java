import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class sept18_26 {
    public static List<String> maxNumOfSubstrings(String s) {
        int n = s.length();
        int[] start = new int[26];
        Arrays.fill(start, -1);
        int[] end = new int[26];
        for(int i = 0 ; i < n ; i++){
            if(start[s.charAt(i) - 'a'] == -1){
                start[s.charAt(i) - 'a'] = i;
            }
            end[s.charAt(i) - 'a'] = i;
        }
        boolean[] isValid = new boolean[26];
        Arrays.fill(isValid, true);
        List<String> result = new ArrayList<>();
        for(int c = 0 ; c < 26 ; c++){
            if(start[c] == -1) continue;
            for(int i = start[c] ; i <= end[c] ; i++){
                int ch = s.charAt(i) - 'a';
                if(start[ch] < start[c]){
                    isValid[c] = false;
                    break;
                }
                end[c] = Math.max(end[c], end[ch]);
            }
        }
        int lastTakenStart = Integer.MAX_VALUE;
        for(int i = n - 1 ; i >= 0 ; i--){
            int c = s.charAt(i) - 'a';
            if(!isValid[c]) continue;
            if(i == start[c] && end[c] < lastTakenStart){
                result.add(s.substring(i, end[c] + 1));
                lastTakenStart = i;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        String s = "adefaddaccc";
        System.out.println(maxNumOfSubstrings(s));
    }
}
