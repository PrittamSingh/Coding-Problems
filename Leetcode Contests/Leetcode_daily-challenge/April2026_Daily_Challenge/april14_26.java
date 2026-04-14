import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class april14_26 {
    public static long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        Collections.sort(robot);
        Arrays.sort(factory, Comparator.comparingInt(a -> a[0]));
        int m = robot.size();
        List<Integer> positions = new ArrayList<>();
        for (int[] f : factory) {
            int pos = f[0];
            int limit = f[1];
            for (int j = 0; j < limit; j++) {
                positions.add(pos);
            }
        }
        int n = positions.size();
        long[][] memo = new long[m + 1][n + 1];
        for (long[] row : memo) {
            Arrays.fill(row, -1);
        }
        return solve(0, 0, robot, positions, memo);
    }
    private static long solve(int ri, int fi, List<Integer> robot, List<Integer> positions, long[][] memo) {
        if(ri >= robot.size()){
            return 0;
        }
        if(fi >= positions.size()){
            return (long) 1e12;
        }
        if(memo[ri][fi] != -1) {
            return memo[ri][fi];
        }
        long takeCurrentFactory = Math.abs(robot.get(ri) - positions.get(fi)) + solve(ri + 1, fi + 1, robot, positions, memo);
        long skip = solve(ri, fi + 1, robot, positions, memo);
        return memo[ri][fi] = Math.min(takeCurrentFactory, skip);
    }
    public static void main(String[] args) {
        List<Integer> robot = new ArrayList<>();
        robot.add(0);
        robot.add(4);
        robot.add(6);
        int[][] factory = {{2,2},{6,2}};
        System.out.println(minimumTotalDistance(robot, factory));
    }
}
