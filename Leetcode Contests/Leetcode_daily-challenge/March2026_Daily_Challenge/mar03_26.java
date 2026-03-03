public class mar03_26 {
    public static char findKthBit(int n, int k){
        // T.C - O(n)
        if(n == 1) return '0';
        int len = (1 << n) - 1;
        int mid = (len + 1) / 2;
        if(mid == k) return '1';
        else if(k < mid) return findKthBit(n - 1, k);
        else{
            char bit = findKthBit(n - 1, len + 1 - k);
            if(bit == '0') return '1';
            else return '0';
        }
    }

    // T.C - O(n^2)
    // public char findKthBit(int n, int k) {
    //     String prev = "0";
    //     String curr = "0";
    //     int i = 1;
    //     while(i < n){
    //         i++;
    //         curr = prev + "1";
    //         for(int j = prev.length() - 1 ; j >= 0 ; j--){
    //             char ch = prev.charAt(j);
    //             if(ch == '0') curr += "1";
    //             else curr += "0";
    //         }
    //         prev = curr;
    //         if(k <= curr.length()){
    //             return curr.charAt(k - 1);
    //         }
    //     }
    //     return curr.charAt(k - 1);
    // }



    // public char findKthBit(int n, int k) {
    //     String s = findString(n);
    //     System.out.println(s);
    //     return s.charAt(k - 1);
    // }
    // public String findString(int n){
    //     if(n == 1){
    //         return "0";
    //     }
    //     StringBuilder sb = new StringBuilder();
    //     sb.append(findString(n - 1));

    //     StringBuilder temp = new StringBuilder(sb);
    //     sb.append("1");
    //     for(int i = 0 ; i < temp.length() ; i++){
    //         if(temp.charAt(i) == '0'){
    //             temp.setCharAt(i, '1');
    //         }
    //         else{
    //             temp.setCharAt(i, '0');
    //         }
    //     }
    //     for(int i = temp.length() - 1 ; i >= 0 ; i--){
    //         sb.append(temp.charAt(i));
    //     }
    //     return sb.toString();
    // }
    public static void main(String[] args) {
        int n = 3, k = 1;
        int n1 = 4, k1 = 11;
        System.out.println(findKthBit(n, k) + " " + findKthBit(n1, k1));
    }
}
