public class jan05_25 {
    public static long maxMatrixSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        long sum = 0;
        int count = 0;
        int minEle = Integer.MAX_VALUE;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(matrix[i][j] < 0){
                    count++;
                }
                minEle = Math.min(minEle, Math.abs(matrix[i][j]));
                sum += Math.abs(matrix[i][j]);
            }
        }
        if(count % 2 == 0){
            return sum;
        }
        return sum - (2 * minEle);
    }
    public static void main(String[] args) {
        int[][] matrix = {{1,-1},{-1,1}};
        int[][] matrix2 = {{1,2,3},{-1,-2,-3},{1,2,3}};
        System.out.println(maxMatrixSum(matrix) + " " + maxMatrixSum(matrix2));
    }
}
