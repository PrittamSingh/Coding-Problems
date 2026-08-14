public class aug14_26 {
    public static int maximumLengthSubstring(String s) {
        int n = s.length();
        int j = 0;
        int i = 0;
        int[] freq = new int[26];
        int ans = 0;
        while(i < n && j < n){
            char ch = s.charAt(i);
            freq[ch - 'a']++;
            while(j < n && freq[ch - 'a'] > 2){
                char c = s.charAt(j);
                freq[c - 'a']--;
                j++;
            }
            i++;
            // System.out.println(i + " " + j);
            // System.out.println(ans);
            ans = Math.max(ans, i - j);
        }
        return ans;
    }
    public static void main(String[] args) {
        String s = "bcbbbcba";
        System.out.println(maximumLengthSubstring(s));
    }
}
