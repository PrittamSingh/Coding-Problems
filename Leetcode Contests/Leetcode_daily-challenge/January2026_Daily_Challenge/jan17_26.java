public class jan17_26 {
    public static long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
        int n = bottomLeft.length; long maxArea = 0;
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                int left = Math.max(bottomLeft[i][0], bottomLeft[j][0]);
                int right = Math.min(topRight[i][0], topRight[j][0]);
                int top = Math.min(topRight[i][1], topRight[j][1]);
                int bottom = Math.max(bottomLeft[i][1], bottomLeft[j][1]);
                if(left < right && top > bottom){
                    int height = top - bottom; int width = right - left;
                    int side = Math.min(height, width);
                    maxArea = Math.max(maxArea, 1L * side * side);
                }   
            }
        }
        return maxArea;
    }
    public static void main(String[] args) {
        int[][] bottomLeft = {{1,1},{2,2},{3,1}}, topRight = {{3,3},{4,4},{6,6}};
        int[][] bottomLeft2 = {{1,1},{1,3},{1,5}}, topRight2 = {{5,5},{5,7},{5,9}};
        System.out.println(largestSquareArea(bottomLeft, topRight) + " " + largestSquareArea(bottomLeft2, topRight2));
    }
}
