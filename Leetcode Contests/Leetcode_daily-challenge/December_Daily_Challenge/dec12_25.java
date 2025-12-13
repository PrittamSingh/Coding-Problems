import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class dec12_25 {
    public static int[] countMentions(int numberOfUsers, List<List<String>> events) {
        events.sort((a, b) -> {
            int t1 = Integer.parseInt(a.get(1));
            int t2 = Integer.parseInt(b.get(1));
            if(t1 != t2){
                return Integer.compare(t1, t2);
            }
            if(a.get(0).equals("OFFLINE") && b.get(0).equals("MESSAGE")){
                return -1;
            }
            if(a.get(0).equals("MESSAGE") && b.get(0).equals("OFFLINE")){
                return 1;
            }
            return 0;
        });

        int n = numberOfUsers;
        int[] ans = new int[n];
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0 ; i < events.size() ; i++){
            List<String> list = events.get(i);
            //MESSAGE EVENT
            if(list.get(0).equals("MESSAGE")){
                String s = list.get(2);
                //id1, id2 , etc - for specific users
                if(s.contains("id")){
                    String[] parts = s.split(" ");
                    for(String part : parts){
                        int x = Integer.parseInt(part.substring(2));
                        ans[x]++;
                    }
                }
                //All - for all users
                else if(s.equals("ALL")){
                    for(int j = 0 ; j < n ; j++){
                        ans[j]++;
                    }
                }
                //Here - for all online users
                else{
                    for(int k = 0 ; k < n ; k++){
                        if(!map.containsKey(k)){
                            ans[k]++;
                            continue;
                        }
                        int time = map.get(k);
                        int currTime = Integer.valueOf(list.get(1));
                        if(currTime - time >= 60){
                            ans[k]++;
                        }
                    }
                }
            }
            //OFFLINE EVENT
            else{
                int time = Integer.valueOf(list.get(1));
                int id = Integer.valueOf(list.get(2));
                map.put(id, time);
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int numberOfUsers = 2;
        List<List<String>> events = new ArrayList<>();
        events.add(new ArrayList<>(List.of("MESSAGE", "10", "id1 id0")));
        events.add(new ArrayList<>(List.of("OFFLINE", "11", "0")));
        events.add(new ArrayList<>(List.of("MESSAGE", "71", "HERE")));
        int[] mentions = countMentions(numberOfUsers,events);
        for(int x : mentions){
            System.out.print(x + " ");
        }
    }
}
    