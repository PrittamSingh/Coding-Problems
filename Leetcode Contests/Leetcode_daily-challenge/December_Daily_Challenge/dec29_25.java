import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class dec29_25 {
    public static boolean pyramidTransition(String bottom, List<String> allowed) {
        Map<String, List<Character>> map = new HashMap<>();
        for(String s : allowed){
            String key = s.substring(0, 2);
            char val = s.charAt(2);
            if(!map.containsKey(key)){
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(val);
        }
        StringBuilder sb = new StringBuilder();
        return backtrack(bottom, map, sb, 0);
    }
    public static boolean backtrack(String bottom, Map<String, List<Character>> map, StringBuilder sb, int idx){
        if(bottom.length() == 1) return true;
        if(sb.length() == bottom.length() - 1){
            return backtrack(sb.toString(), map, new StringBuilder(), 0);
        }
        String key = bottom.substring(idx, idx + 2);
        if(!map.containsKey(key)){
            return false;
        }
        for(char ch : map.get(key)){
            sb.append(ch);
            if(backtrack(bottom, map, sb, idx + 1)){
                return true;
            }
            sb.deleteCharAt(idx); //Main backtracking step
        }
        return false;
    }
    public static void main(String[] args) {
        String bottom = "BCD";
        List<String> allowed = Arrays.asList("BCC","CDE","CEA","FFF");
        String bottom2 = "AAAA";
        List<String> allowed2 = Arrays.asList("AAB","AAC","BCD","BBE","DEF");
        System.out.println(pyramidTransition(bottom, allowed) + " " + pyramidTransition(bottom2, allowed2));
    }
}
