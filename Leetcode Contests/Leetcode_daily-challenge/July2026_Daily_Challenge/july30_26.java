public class july30_26 {
    public static int minimumPushes(String word) {
        int n = word.length();
        int k = 1;
        int ans = 0;
        while(n > 0){
            if(n > 8){
                n -= 8;
                ans += (k * 8);
                k++;
            }
            else{
                ans += (k * n);
                n = 0;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        String word = "xycdefghij";
        System.out.println(minimumPushes(word));
    }
}
