public class june30_26 {
    public static int numberOfSubstrings(String s){
        // int n = s.length();
        // int[] count = new int[3];
        // int left = 0;
        // int ans = 0;
        // for(int right = 0 ; right < n ; right++){
        //     count[s.charAt(right) - 'a']++;
        //     while(count[0] > 0 && count[1] > 0 && count[2] > 0){
        //         ans += n - right;
        //         count[s.charAt(left) - 'a']--;
        //         left++;
        //     }
        // }
        // return ans;



        int[] last = {-1, -1, -1};
        int ans = 0;
        for(int i = 0 ; i < s.length() ; i++){
            last[s.charAt(i) - 'a'] = i;
            ans += Math.min(last[0], Math.min(last[1], last[2])) + 1;
        }
        return ans;
    }
    public static void main(String[] args) {
        String s = "abcabc";
        System.out.println(numberOfSubstrings(s));
    }
}
