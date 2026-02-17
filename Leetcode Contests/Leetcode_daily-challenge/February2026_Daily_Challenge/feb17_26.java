import java.util.ArrayList;
import java.util.List;

public class feb17_26 {
    public static List<String> readBinaryWatch(int turnedOn) {
        List<String> ans = new ArrayList<>();
        
        for(int h = 0; h < 12; h++) {
            for(int m = 0; m < 60; m++) {
                if(Integer.bitCount(h) + Integer.bitCount(m) == turnedOn) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(h);
                    sb.append(":");
                    if(m < 10) {
                        sb.append("0" + m);
                    }
                    else {
                        sb.append(m);
                    }
                    ans.add(sb.toString());
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int turnedOn = 1;
        int turnedOn1 = 9;
        System.out.println(readBinaryWatch(turnedOn) + " " + readBinaryWatch(turnedOn1));
    }
}
