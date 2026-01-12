public class jan12_26 {
    public static int minTimeToVisitAllPoints(int[][] points) {
        // int n = points.length;
        // int x = points[0][0];
        // int y = points[0][1];
        // int time = 0;
        // for(int i = 1 ; i < n ; i++){
        //     int x1 = points[i][0];
        //     int y1 = points[i][1];

        //     int diffX = Math.abs(x1 - x);
        //     int diffY = Math.abs(y1 - y);
        //     time += Math.max(diffX, diffY);
        //     x = x1;
        //     y = y1;
            
        // }
        // return time;
        int ans = 0;
        for(int i = 0 ; i < points.length - 1 ; i++){
            int x = Math.abs(points[i][0] - points[i + 1][0]);
            int y = Math.abs(points[i][1] - points[i + 1][1]);
            ans += Math.max(x, y);
        }
        return ans;
    }
    public static void main(String[] args) {
        int[][] points = {{1,1},{3,4},{-1,0}};
        int[][] points2 = {{3,2},{-2,2}};
        System.out.println(minTimeToVisitAllPoints(points) + " " + minTimeToVisitAllPoints(points2));
    }
}
