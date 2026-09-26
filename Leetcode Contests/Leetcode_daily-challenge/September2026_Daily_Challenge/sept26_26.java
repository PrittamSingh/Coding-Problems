import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class sept26_26 {
    public static String evaluate(String s, List<List<String>> knowledge) {
        int n = s.length();
        Map<String, String> map = new HashMap<>();
        for(int i = 0 ; i < knowledge.size() ; i++){
            map.put(knowledge.get(i).get(0), knowledge.get(i).get(1));
        }
        int i = 0;
        StringBuilder res = new StringBuilder();
        while(i < n){
            char ch = s.charAt(i);
            if(Character.isLetter(ch)){
                res.append(ch);
            }
            else if(ch == '('){
                i++;
                StringBuilder temp = new StringBuilder();
                while(i < n && s.charAt(i) != ')'){
                    temp.append(s.charAt(i));
                    i++;
                }
                String val;
                if(map.containsKey(temp.toString())){
                    val = map.get(temp.toString());
                }
                else{
                    val = "?";
                }
                res.append(val);
            }
            i++;
        }
        return res.toString();
    }
    public static void main(String[] args) {
        String s = "(name)is(age)yearsold";
        List<List<String>> knowledge = new ArrayList<>();
        knowledge.add(new ArrayList<>());
        knowledge.add(new ArrayList<>());
        knowledge.get(0).add("name");
        knowledge.get(0).add("bob");
        knowledge.get(1).add("age");
        knowledge.get(1).add("two");
        System.out.println(evaluate(s, knowledge));
    }
}
