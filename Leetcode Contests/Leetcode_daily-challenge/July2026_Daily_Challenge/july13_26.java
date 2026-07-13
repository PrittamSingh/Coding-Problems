import java.util.ArrayList;
import java.util.List;

public class july13_26 {
    public static List<Integer> sequentialDigits(int low, int high) {
        List<Integer> ans = new ArrayList<>();
        String s = "123456789";
        String l = String.valueOf(low);
        String h = String.valueOf(high);
        for(int len = l.length() ; len <= h.length() ; len++){
            for(int start = 0 ; start <= 9 - len ; start++){
                int num = Integer.parseInt(s.substring(start, start + len));
                if(num >= low && num <= high){
                    ans.add(num);
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int low = 1000, high = 13000;
        List<Integer> ans = sequentialDigits(low, high);
        for(int i = 0 ; i < ans.size() ; i++){
            System.out.print(ans.get(i) + " ");
        }
    }
}
