public class nov22_26 {
    public static boolean checkString(String s) {
        int lastA = -1;
        int firstB = -1;
        int n = s.length();
        for(int i = 0 ; i < n ; i++){
            if(s.charAt(i) == 'a'){
                lastA = i;
            }
            else if(firstB == -1){
                firstB = i;
            }
        }
        if(lastA == -1 || firstB == -1){
            return true;
        }
        return lastA < firstB;
    }
    public static void main(String[] args) {
        String s = "aaabbb";
        System.out.println(checkString(s));
    }
}
