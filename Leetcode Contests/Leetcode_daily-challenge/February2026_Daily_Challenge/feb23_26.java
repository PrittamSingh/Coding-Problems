import java.util.HashSet;

public class feb23_26 {
    public static boolean hasAllCodes(String s, int k) {
        if(s.length() < k) return false;
        int uniqueSub = 1 << k;
        HashSet<String> st = new HashSet<>();

        for(int i = k; i <= s.length(); i++) {
            String sub = s.substring(i-k, i);

            if(!st.contains(sub)) {
                st.add(sub);
                uniqueSub--;
            }

            if(uniqueSub == 0)
                return true;
        }

        return false;
    }
    public static void main(String[] args) {
        String s = "00110110";
        int k = 2;
        String s1 = "0110";
        int k1 = 2;
        System.out.println(hasAllCodes(s, k) + " " + hasAllCodes(s1, k1));
    }
}
