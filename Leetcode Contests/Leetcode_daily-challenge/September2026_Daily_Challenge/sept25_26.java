import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class sept25_26 {
    static String s;
    static int n;
    static int idx = 0;
    public static List<String> braceExpansionII(String expression) {
        n = expression.length();
        s = expression;
        idx = 0;
        Set<String> st = performUnion();
        return new ArrayList<>(st);
    }
    private static Set<String> getUnit(){
        Set<String> result;
        if(s.charAt(idx) == '{'){
            idx++;
            result = performUnion();
        }
        else{
            result = new TreeSet<>();
            result.add(String.valueOf(s.charAt(idx)));
        }
        idx++;
        return result;
    }
    private static Set<String> performConcat(){
        Set<String> result = new TreeSet<>();
        result.add("");
        while(idx < n && (s.charAt(idx) == '{' || Character.isLetter(s.charAt(idx)))){
            Set<String> temp = getUnit();
            Set<String> concatResult = new TreeSet<>();
            for(String left : result){
                for(String right : temp){
                    concatResult.add(left + right);
                }
            }
            result = concatResult;
        }
        return result;
    }
    private static Set<String> performUnion() {
        Set<String> result = new TreeSet<>();
        while(true){
            Set<String> temp = performConcat();
            result.addAll(temp);
            if(idx < n && s.charAt(idx) == ','){
                idx++;
            }
            else{
                break;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        String expression = "{a,b}{c,{d,e}}";
        System.out.println(braceExpansionII(expression));
    }
}
