public class june22_26 {
    public static int maxNumberOfBalloons(String text) {
        int[] freq = new int[26];
        for(char ch : text.toCharArray()){
            freq[ch - 'a']++;
        }
        int ans = freq[0];
        ans = Math.min(ans, freq[1]);
        ans = Math.min(ans, freq[11] / 2);
        ans = Math.min(ans, freq[13]);
        ans = Math.min(ans, freq[14] / 2);
        return ans;
    }
    public static void main(String[] args) {
        String text = "nlaebolko";
        String text2 = "loonbalxballpoon";
        System.out.println(maxNumberOfBalloons(text) + " " + maxNumberOfBalloons(text2));
    }
}
