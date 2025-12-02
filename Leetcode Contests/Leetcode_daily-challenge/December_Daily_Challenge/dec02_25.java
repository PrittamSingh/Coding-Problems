import java.util.HashMap;
import java.util.Map;

public class dec02_25 {
    public static int countTrapezoids(int[][] points) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int[] point : points){
            map.put(point[1], map.getOrDefault(point[1], 0) + 1);
        }
        int mod = 1000000007;
        long sum = 0;
        long ans = 0;
        for(int pointCount : map.values()){
            long edge = ((long)pointCount * (pointCount - 1)) / 2;
            ans = (ans + (sum * edge) % mod) % mod;
            sum = (sum + edge) % mod;
        }
        return (int)ans;
    }
    public static void main(String[] args) {
        int[][] points = {{1,0},{2,0},{3,0},{2,2},{3,2}};
        int[][] points2 = {{0,0},{1,0},{0,1},{2,1}};
        System.out.println(countTrapezoids(points) + " " + countTrapezoids(points2));
    }
}
