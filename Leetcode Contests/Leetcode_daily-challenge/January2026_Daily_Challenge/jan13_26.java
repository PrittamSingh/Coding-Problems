public class jan13_26 {
    public static double separateSquares(int[][] squares) {
        double y = 0;
        double totalArea = 0;
        double min = Integer.MAX_VALUE;
        double max = Integer.MIN_VALUE;
        for(int[] square : squares){
            double len = square[2];
            totalArea += len * len;
            min = Math.min(min, square[1]);
            max = Math.max(max, square[1] + len);
        }
        double target = totalArea / 2;
        double low = min;
        double high = max;
        while(low < high){
            if(high - low < Math.pow(10, -5)){
                break;
            }
            double mid = (low + high) / 2;
            if(areaBelow(mid, squares) < target){
                low = mid;
            }
            else{
                y = mid;
                high = mid;
            }
        }
        return y;
    }
    public static double areaBelow(double mid, int[][] squares){
        double area = 0;
        for(int[] square : squares){
            double y = square[1];
            double len = square[2];
            if(mid >= y + len){
                area += len * len;
            }
            else if(mid > y && mid < y + len){
                area += len * (mid - y);
            }
        }
        return area;
    }
    public static void main(String[] args) {
        int[][] squares = {{0,0,1},{2,2,1}};
        int[][] squares2 = {{0,0,2},{1,1,1}};
        System.out.println(separateSquares(squares) + " " + separateSquares(squares2));
    }
}
