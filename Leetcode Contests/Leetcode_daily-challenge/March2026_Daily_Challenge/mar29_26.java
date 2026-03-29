import java.util.Arrays;

public class mar29_26 {
    public static boolean canBeEqual(String s1, String s2) {
        char[] s1Even = new char[]{s1.charAt(0), s1.charAt(2)};
        char[] s1Odd = new char[]{s1.charAt(1), s1.charAt(3)};

        char[] s2Even = new char[]{s2.charAt(0), s2.charAt(2)};
        char[] s2Odd = new char[]{s2.charAt(1), s2.charAt(3)};
        Arrays.sort(s1Even);
        Arrays.sort(s1Odd);
        Arrays.sort(s2Even);
        Arrays.sort(s2Odd);
        return Arrays.equals(s1Even, s2Even) && Arrays.equals(s1Odd, s2Odd);
    }
    public static void main(String[] args) {
        String s1 = "abcd", s2 = "cdab";
        String s11 = "abcd", s21 = "dacb";
        System.out.println(canBeEqual(s1, s2) + " " + canBeEqual(s11, s21));
    }
}
