public class oct04_26 {
    public static boolean checkValidString(String s) {
        int minOpen = 0;
        int maxOpen = 0;
        for(char ch : s.toCharArray()){
            if(ch == '('){
                minOpen++;
                maxOpen++;
            }
            else if(ch == ')'){
                if(minOpen > 0) minOpen--;
                maxOpen--;
            }
            else{
                if(minOpen > 0) minOpen--;
                maxOpen++;
            }
            if(maxOpen < 0){
                return false;
            }
        }
        return minOpen == 0;
    }
    public static void main(String[] args) {
        String s = "(*))";
        String s2 = "(";
        System.out.println(checkValidString(s) + " " + checkValidString(s2));
    }
}
