import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class dec11_25 {
    public static int countCoveredBuildings(int n, int[][] buildings) {
        // Approach-1 Brute-Force Approach O(n2)
        // int covered = 0;
        // for(int i = 0 ; i < buildings.length ; i++){
        //     int x = buildings[i][0];
        //     int y = buildings[i][1];
        //     boolean above = false, below = false, left = false, right = false;
        //     for(int j = 0 ; j < buildings.length ; j++){
        //         if(i == j) continue;
        //         int nx = buildings[j][0];
        //         int ny = buildings[j][1];
        //         if(ny == y && nx < x) above = true;
        //         if(ny == y && nx > x) below = true;
        //         if(nx == x && ny < y) left = true;
        //         if(nx == x && ny > y) right = true;

        //     }
        //     if(above && below && left && right){
        //         covered++;
        //     }
        // }
        // return covered;

        //Approach-2 Use Row/Column Bucketing and Sorting O(nlogn)
        // Map<Integer, List<Integer>> rows = new HashMap<>();
        // Map<Integer, List<Integer>> cols = new HashMap<>();
        // for(int[] b : buildings){
        //     int x = b[0];
        //     int y = b[1];
        //     rows.computeIfAbsent(x, k -> new ArrayList<>()).add(y);
        //     cols.computeIfAbsent(y, k -> new ArrayList<>()).add(x);
        // }
        // for(List<Integer> list : rows.values()) Collections.sort(list);
        // for(List<Integer> list : cols.values()) Collections.sort(list);

        // int covered = 0;
        // for(int[] b : buildings){
        //     int x = b[0];
        //     int y = b[1];
        //     List<Integer> row = rows.get(x);
        //     List<Integer> col = cols.get(y);
        // }

        // Approach-3 Using TreeSet
        Map<Integer, TreeSet<Integer>> rowToCol = new HashMap<>();
        Map<Integer, TreeSet<Integer>> colToRow = new HashMap<>();
        for(int[] b : buildings){
            int x = b[0];
            int y = b[1];
            rowToCol.computeIfAbsent(x, k -> new TreeSet<>()).add(y);
            colToRow.computeIfAbsent(y, k -> new TreeSet<>()).add(x);
        }
        int covered = 0;
        for(int[] b : buildings){
            int x = b[0];
            int y = b[1];
            Integer left = rowToCol.get(x).lower(y);
            Integer right = rowToCol.get(x).higher(y);
            Integer above = colToRow.get(y).lower(x);
            Integer below = colToRow.get(y).higher(x);
            if(left != null && right != null && above != null && below != null){
                covered++;
            }
        }
        return covered;
    }
    public static void main(String[] args) {
        int n = 3;
        int[][] buildings = {{1,2},{2,2},{3,2},{2,1},{2,3}};
        System.out.println(countCoveredBuildings(n, buildings));
        int n2 = 3;
        int[][] buildings2 = {{1,1},{1,2},{2,1},{2,2}};
        System.err.println(countCoveredBuildings(n2, buildings2));
        int n3 = 5;
        int[][] buildings3 = {{1,3},{3,2},{3,3},{3,5},{5,3}};
        System.out.println(countCoveredBuildings(n3, buildings3));
    }
}
