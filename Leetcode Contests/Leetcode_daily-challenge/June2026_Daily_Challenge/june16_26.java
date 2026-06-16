public class june16_26 {
    public static String processStr(String s) {
        StringBuilder res = new StringBuilder();
        for(char ch : s.toCharArray()){
            if(ch >= 'a' && ch <= 'z'){
                res.append(ch);
            }
            else if(ch == '*'){
                if(res.length() > 0){
                    res.deleteCharAt(res.length() - 1);
                }
            }
            else if(ch == '#'){
                String str = res.toString();
                res.append(str);
            }
            else{
                int i = 0;
                int j = res.length() - 1;
                while(i <= j){
                    char temp = res.charAt(i);
                    res.setCharAt(i, res.charAt(j));
                    res.setCharAt(j, temp);
                    i++;
                    j--;
                }
            }
        }
        return res.toString();
    }
    public static void main(String[] args) {
        String s = "a#b%*";
        System.out.println(processStr(s));
    }
}
