public class nov16_25{
    public static int numSub(String s) {
        // Approach-1 Brute Force Approach
        // int mod = 1000000007;
        // int n = s.length();
        // int count = 0;
        // for(int i = 0 ; i < n ; i++){
        //     for(int j = i ; j < n ; j++){
        //         boolean valid = true;
        //         for(int k = i ; k <= j ; k++){
        //             if(s.charAt(k) == '0'){
        //                 valid = false;
        //                 break;
        //             }
        //         }
        //         if(valid) count++;
        //     }
        // }
        // return (int)(count % mod);

        // Approach-2 Better Brute Force Approach
        // int mod = 1000000007;
        // int n = s.length();
        // int count = 0;

        // for(int i = 0 ; i < n ; i++){
        //     if(s.charAt(i) == '1'){
        //         for(int j = i ; j < n && s.charAt(j) == '1' ; j++){
        //             count++;
        //         }
        //     }
        // }
        // return (int)(count % mod);

        // Approach-3 Most Optimal Solution
        // int mod = 1000000007;
        // int current = 0;
        // int ans = 0;

        // for(char ch : s.toCharArray()){
        //     if(ch == '1'){
        //         current++;
        //         ans = (ans + current) % mod;
        //     }else{
        //         current = 0;
        //     }
        // }
        // return (int)ans;

        // Approach-4 same as approach-3
        int mod = 1000000007;
        long current = 0;
        long ans = 0;

        for(char ch : s.toCharArray()){
            if(ch == '1'){
                current++;
            }
            else{
                ans = (ans + current * (current + 1) / 2) % mod;
                current = 0;
            }
        }
        ans = (ans + current * (current + 1) / 2) % mod;
        return (int)ans;
    }
    public static void main(String[] args) {
        String s = "0110111" , s2 = "101" , s3 = "111111";
        int ans = numSub(s) , ans2 = numSub(s2) , ans3 = numSub(s3);
        System.out.println(ans + " " + ans2 + " " + ans3);
    }
}