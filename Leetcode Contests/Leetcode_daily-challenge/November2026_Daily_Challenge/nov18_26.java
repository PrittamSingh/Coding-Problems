public class nov18_26 {
    public static int minChanges(String s) {
        int n = s.length();
        int count = 0;
        for(int i = 0; i < n ; i += 2){
            if(s.charAt(i) != s.charAt(i + 1)){
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        String s = "1001";
        System.out.println(minChanges(s));
    }
}
