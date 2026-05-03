public class may03_26 {
    public static boolean rotateString(String s, String goal) {
        int n = s.length();
        int m = goal.length();
        if(n != m) return false;
        int j = 0;
        for(int i = 0 ; i < n ; i++){
            if(s.charAt(j) == goal.charAt(i)){
                if((goal.substring(i, n) + goal.substring(0, i)).equals(s)){
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        String s = "abcde", goal = "cdeab";
        String s1 = "abcde", goal1 = "abced";
        System.out.println(rotateString(s, goal) + " " + rotateString(s1, goal1));
    }
}
