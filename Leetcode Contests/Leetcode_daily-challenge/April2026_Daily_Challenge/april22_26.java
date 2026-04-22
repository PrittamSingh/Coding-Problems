import java.util.ArrayList;
import java.util.List;

public class april22_26 {
    public static List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> result = new ArrayList<>();
        for(String query : queries){
            for(String s : dictionary){
                int diff = 0;
                for(int i = 0; i < query.length(); i++){
                    if(query.charAt(i) != s.charAt(i)){
                        diff++;
                    }

                    if(diff > 2)
                        break;
                }

                if(diff <= 2){
                    result.add(query);
                    break;
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        String[] queries = {"word","note","ants","wood"}, dictionary = {"wood","joke","moat"};
        System.out.println(twoEditWords(queries, dictionary));
    }
}
