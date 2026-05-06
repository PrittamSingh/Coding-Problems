public class may06_26 {
    public static char[][] rotateTheBox(char[][] box) {
        int m = box.length;
        int n = box[0].length;
        char[][] result = new char[n][m];
        for(int i = 0; i < n; i++){
            for (int j = 0; j < m; j++) {
                result[i][j] = box[j][i];
            }
        }
        for(int i = 0; i < n; i++){
            reverseRow(result[i]);
        }
        for(int j = 0; j < m; j++){
            int spaceBottomRow = n - 1;
            for(int i = n - 1; i >= 0; i--){
                if(result[i][j] == '*'){
                    spaceBottomRow = i - 1;
                    continue;
                }
                if(result[i][j] == '#'){
                    result[i][j] = '.';
                    result[spaceBottomRow][j] = '#';
                    spaceBottomRow--;
                }
            }
        }
        return result;
    }
    private static void reverseRow(char[] row) {
        int left = 0, right = row.length - 1;
        while (left < right) {
            char temp = row[left];
            row[left] = row[right];
            row[right] = temp;
            left++;
            right--;
        }
    }
    public static void main(String[] args) {
        char[][] boxGrid = {{'#','.','#'}};
        char[][] ans = rotateTheBox(boxGrid);
        for(int i = 0 ; i < ans.length ; i++){
            for(int j = 0 ; j < ans[0].length ; j++){
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }
}
