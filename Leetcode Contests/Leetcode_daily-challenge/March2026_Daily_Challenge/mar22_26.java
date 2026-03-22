public class mar22_26 {
    public static boolean findRotation(int[][] mat, int[][] target) {
        int n = mat.length;
        for(int count = 1 ; count <= 4 ; count++){
            boolean equal = true;
            for(int i = 0 ; i < n ; i++){
                for(int j = 0 ; j < n ; j++){
                    if(mat[i][j] != target[i][j]){
                        equal = false;
                        break;
                    }
                }
                if(!equal){
                    break;
                }
            }
            if(equal){
                return true;
            }
            rotate(mat);
        }
        return false;
    }
    public static void rotate(int[][] mat){
        int n = mat.length;
        //Transpose
        for(int i = 0 ; i < n ; i++){
            for(int j = i ; j < n ; j++){
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;  
            }
        }
        //Reverse Each Row
        for(int i = 0 ; i < n ; i++){
            int left = 0;
            int right = n - 1;
            while(left < right){
                int temp = mat[i][left];
                mat[i][left] = mat[i][right];
                mat[i][right] = temp;
                left++;
                right--;
            }
        }
    }
    public static void main(String[] args) {
        int[][] mat = {{0,1},{1,0}}, target = {{1,0},{0,1}};
        int[][] mat2 = {{0,1},{1,1}}, target2 = {{1,0},{0,1}};
        System.out.println(findRotation(mat, target) + " " + findRotation(mat2, target2));
    }
}
