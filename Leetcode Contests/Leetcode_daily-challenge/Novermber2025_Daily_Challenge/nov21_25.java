import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class nov21_25 {
    public static int countPalindromicSubsequence(String s) {
        // Approach-1 Brute Force Approach
        // Set<String> set = new HashSet<>();
        // for(int i = 0 ; i < s.length() ; i++){
        //     for(int j = i + 1 ; j < s.length() ; j++){
        //         for(int k = j + 1 ; k < s.length() ; k++){
        //             if(s.charAt(i) == s.charAt(k)){
        //                 String str = "" + s.charAt(i) + s.charAt(j) + s.charAt(k);
        //                 set.add(str);
        //             }
        //         }
        //     }
        // }
        // return set.size();

        // Approach-2
        int n = s.length();
        int[] first = new int[26];
        int[] last = new int[26];
        Arrays.fill(first , -1);
        Arrays.fill(last , -1);

        for(int i = 0 ; i < n ; i++){
            int val = s.charAt(i) - 'a';
            if(first[val] == -1){
                first[val] = i;
            }
            last[val] = i;
        }

        int count = 0;

        for(int i = 0 ; i < 26 ; i++){
            if(first[i] != -1 && last[i] != -1){
                Set<Character> distinct = new HashSet<>();
                for(int j = first[i] + 1 ; j < last[i] ; j++){
                    distinct.add(s.charAt(j));
                }
                count += distinct.size();
            }
        }
        return count;
    }
    public static void main(String[] args) {
        String s = "aabca" , s2 = "adc" , s3 = "bbcbaba";
        System.out.println(countPalindromicSubsequence(s) + " " + countPalindromicSubsequence(s2) + " " + countPalindromicSubsequence(s3));
    }
}
