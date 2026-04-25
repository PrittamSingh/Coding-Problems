import java.util.Arrays;

public class april25_26 {
    // public int manhattan(int[] vec1, int[] vec2) {
    //     return Math.abs(vec1[0] - vec2[0]) + Math.abs(vec1[1] - vec2[1]);
    // }

    // public boolean solve(int[][] points, int k, int d, int start, List<Integer> chosen) {
    //     if (chosen.size() == k)
    //         return true;
        
    //     for (int i = start; i < points.length; i++) {
    //         boolean valid = true;
    //         for (int idx : chosen) {
    //             if (manhattan(points[i], points[idx]) < d) {
    //                 valid = false;
    //                 break;
    //             }
    //         }
    //         if (!valid)
    //             continue;
            
    //         chosen.add(i);
    //         if (solve(points, k, d, i + 1, chosen))
    //             return true;
    //         chosen.remove(chosen.size() - 1);
    //     }
    //     return false;
    // }

    // public int maxDistance(int side, int[][] points, int k) {
    //     int l = 0, r = 2 * side;
    //     int best = 0;
        
    //     while (l <= r) {
    //         int mid = (l + r) / 2;
    //         List<Integer> chosen = new ArrayList<>();
            
    //         if (solve(points, k, mid, 0, chosen)) {
    //             best = mid;
    //             l = mid + 1;
    //         } else {
    //             r = mid - 1;
    //         }
    //     }
    //     return best;
    // }




    static long get1D(int side, int x, int y) {
        if (y == 0) return x;
        if (x == side) return (long) side + y;
        if (y == side) return 3L * side - x;
        return 4L * side - y;
    }
    static boolean check(long[] doubled, int n, int k, int side, int mid) {
        long perimeter = 4L * side;
        for (int i = 0; i < n; i++) {
            int count = 1;
            int idx = i;
            long lastPos = doubled[idx];
            for (int j = 2; j <= k; j++) {
                long target = lastPos + mid;
                int nextIdx = lowerBound(doubled, idx + 1, i + n, target);
                if (nextIdx == i + n) break;
                idx = nextIdx;
                lastPos = doubled[idx];
                count++;
            }
            if (count == k && (doubled[i] + perimeter - lastPos >= mid)) {
                return true;
            }
        }
        return false;
    }
    static int lowerBound(long[] arr, int left, int right, long target) {
        int ans = right;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] >= target) {
                ans = mid;
                right = mid;
            } 
            else {
                left = mid + 1;
            }
        }
        return ans;
    }

    public static int maxDistance(int side, int[][] points, int k) {
        int n = points.length;
        long perimeter = 4L * side;
        long[] positions = new long[n];
        for (int i = 0; i < n; i++) {
            positions[i] = get1D(side, points[i][0], points[i][1]);
        }
        Arrays.sort(positions);
        long[] doubled = new long[2 * n];
        for (int i = 0; i < n; i++) {
            doubled[i] = positions[i];
            doubled[i + n] = positions[i] + perimeter;
        }
        int left = 0, right = 2 * side;
        int result = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (check(doubled, n, k, side, mid)) {
                result = mid;
                left = mid + 1;
            } 
            else {
                right = mid - 1;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int side = 2;
        int[][] points = {{0,2},{2,0},{2,2},{0,0}};
        int k = 4;
        System.out.println(maxDistance(side, points, k));
    }
}
