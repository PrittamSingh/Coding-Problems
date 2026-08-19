import java.util.HashMap;
import java.util.Map;

public class aug19_26 {
    public static int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int[] reservedSeat : reservedSeats){
            int row = reservedSeat[0];
            int seat = reservedSeat[1];
            map.merge(row, (1 << seat), (a, b) -> a | b);
        }
        int res = (n - map.size()) * 2;
        int maskA = (1 << 2) | (1 << 3) | (1 << 4) | (1 << 5);
        int maskB = (1 << 4) | (1 << 5) | (1 << 6) | (1 << 7);
        int maskC = (1 << 6) | (1 << 7) | (1 << 8) | (1 << 9);
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            int bookedSeat = entry.getValue();
            boolean groupA = (bookedSeat & maskA) == 0;
            boolean groupB = (bookedSeat & maskB) == 0;
            boolean groupC = (bookedSeat & maskC) == 0;
            if(groupA && groupC){
                res += 2;
            }
            else if(groupA || groupB || groupC){
                res += 1;
            }
        }
        return res;




        // Map<Integer, Set<Integer>> map = new HashMap<>();
        // for(int[] reservedSeat : reservedSeats){
        //     int row = reservedSeat[0];
        //     int seat = reservedSeat[1];
        //     map.computeIfAbsent(row, k -> new HashSet<>()).add(seat);
        // }
        // int res = (n - map.size()) * 2;
        // for(Set<Integer> seats : map.values()){
        //     boolean groupA = !seats.contains(2) && !seats.contains(3) && !seats.contains(4) && !seats.contains(5);
        //     boolean groupB = !seats.contains(4) && !seats.contains(5) && !seats.contains(6) && !seats.contains(7);
        //     boolean groupC = !seats.contains(6) && !seats.contains(7) && !seats.contains(8) && !seats.contains(9);
        //     if(groupA && groupC){
        //         res += 2;
        //     }
        //     else if(groupA || groupB || groupC){
        //         res += 1;
        //     }
        // }
        // return res;




        // boolean[][] reserved = new boolean[n][10];
        // for(int[] seat : reservedSeats){
        //     int a = seat[0];
        //     int b = seat[1];
        //     reserved[a - 1][b - 1] = true;
        // }
        // int ans = 0;
        // for(int i = 0 ; i < n ; i++){
        //     if(!reserved[i][1] && !reserved[i][2] && !reserved[i][3] && !reserved[i][4]){
        //         ans++;
        //         reserved[i][1] = true;
        //         reserved[i][2] = true;
        //         reserved[i][3] = true;
        //         reserved[i][4] = true;
        //     }
        //     if(!reserved[i][3] && !reserved[i][4] && !reserved[i][5] && !reserved[i][6]){
        //         ans++;
        //         reserved[i][3] = true;
        //         reserved[i][4] = true;
        //         reserved[i][5] = true;
        //         reserved[i][6] = true;
        //     }
        //     if(!reserved[i][5] && !reserved[i][6] && !reserved[i][7] && !reserved[i][8]){
        //         ans++;
        //         reserved[i][5] = true;
        //         reserved[i][6] = true;
        //         reserved[i][7] = true;
        //         reserved[i][8] = true;
        //     }
        // }
        // return ans;
    }
    public static void main(String[] args) {
        int n = 3;
        int[][] reservedSeats = {{1,2},{1,3},{1,8},{2,6},{3,1},{3,10}};
        System.out.println(maxNumberOfFamilies(n, reservedSeats));
    }
}
