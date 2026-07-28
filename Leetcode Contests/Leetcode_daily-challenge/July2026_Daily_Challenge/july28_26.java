public class july28_26 {
    public static String smallestPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        int[] freq = new int[26];
        for(char ch : s.toCharArray()){
            freq[ch - 'a']++;
        }
        for(int i = 0 ; i < 26 ; i++){
            for(int j = 0 ; j < freq[i] / 2 ; j++){
                sb.append((char)('a' + i));
            }
        }
        StringBuilder newSb = new StringBuilder(sb);
        String newStr = newSb.reverse().toString();
        for(int i = 0 ; i < 26 ; i++){
            if(freq[i] % 2 != 0){
                sb.append((char)('a' + i));
            }
        }
        sb.append(newStr);
        return sb.toString();
    }
    public static void main(String[] args) {
        String s = "babab";
        System.out.println(smallestPalindrome(s));
    }
}
