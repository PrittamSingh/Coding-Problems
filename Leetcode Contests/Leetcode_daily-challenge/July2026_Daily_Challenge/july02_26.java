import java.util.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class july02_26 {
    public static boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int m = grid.size();
        int n = grid.get(0).size();

        int startHealth = health - grid.get(0).get(0);
        if (startHealth <= 0) return false;

        int[][] best = new int[m][n];
        for (int[] row : best) Arrays.fill(row, -1);

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0, startHealth});
        best[0][0] = startHealth;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];
            int h = cur[2];

            if (r == m - 1 && c == n - 1) {
                return true;
            }

            for (int k = 0; k < 4; k++) {
                int nr = r + dr[k];
                int nc = c + dc[k];

                if (nr >= 0 && nr < m && nc >= 0 && nc < n) {
                    int nh = h - grid.get(nr).get(nc);

                    if (nh > 0 && nh > best[nr][nc]) {
                        best[nr][nc] = nh;
                        q.offer(new int[]{nr, nc, nh});
                    }
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        List<List<Integer>> grid = new ArrayList<>();
        grid.add(Arrays.asList(0, 1, 0, 0, 0));
        grid.add(Arrays.asList(0, 1, 0,1, 0));
        grid.add(Arrays.asList(0, 0, 0, 1, 0));

        int health = 1;
        boolean canReach = findSafeWalk(grid, health);
        System.out.println(canReach);
    }
}
