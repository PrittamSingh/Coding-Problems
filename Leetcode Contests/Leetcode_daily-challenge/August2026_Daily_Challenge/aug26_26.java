public class aug26_26 {
    // public String shortestBeautifulSubstring(String s, int k) {
    //     int n = s.length();
    //     String res = "";
    //     int len = Integer.MAX_VALUE;
    //     for(int i = 0 ; i < n ; i++){
    //         StringBuilder sb = new StringBuilder();
    //         int count = 0;
    //         for(int j = i ; j < n ; j++){
    //             sb.append(s.charAt(j));
    //             if(s.charAt(j) == '1'){
    //                 count++;
    //             }
    //             if(count == k){
    //                 if(sb.length() < len){
    //                     len = sb.length();
    //                     res = sb.toString();
    //                 }
    //                 else if(sb.length() == len){
    //                     res = largerString(sb.toString(), res);
    //                 }
    //             }
    //         }
    //     }
    //     return res;
    // }
    // public String largerString(String s, String t){
    //     int n = s.length();
    //     for(int i = 0 ; i < n ; i++){
    //         if(s.charAt(i) == t.charAt(i)){
    //             continue;
    //         }
    //         int a = s.charAt(i) - '0';
    //         int b = t.charAt(i) - '0';
    //         if(a > b){
    //             return t;
    //         }
    //         else{
    //             return s;
    //         }
    //     }
    //     return s;
    // }




    //SLIDING WINDOW APPROACH
    public static String shortestBeautifulSubstring(String s, int k) {
        int n = s.length();
        int i = 0;
        int ones = 0;
        String result = "";
        for(int j = 0 ; j < n ; j++){
            if(s.charAt(j) == '1'){
                ones++;
            }
            while(ones > k || (i <= j && s.charAt(i) == '0')){
                if(s.charAt(i) == '1'){
                    ones--;
                }
                i++;
            }
            if(ones == k){
                String temp = s.substring(i, j + 1);
                if(result.isEmpty() || j - i + 1 < result.length() || (j - i + 1 == result.length() && temp.compareTo(result) < 0)){
                    result = temp;

                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        String s = "100011001";
        int k = 3;
        System.out.println(shortestBeautifulSubstring(s, k));
    }
}
