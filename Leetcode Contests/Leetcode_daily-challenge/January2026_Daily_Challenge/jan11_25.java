import java.util.*;
public class jan11_25 {
    public static int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[] heights = new int[m];
        int maxArea = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(matrix[i][j] == '1'){
                    heights[j]++;
                }
                else{
                    heights[j] = 0;
                }
            }
            maxArea = Math.max(maxArea, solve(heights));
        }
        return maxArea;
    }
    public static int solve(int[] heights){
        int n = heights.length;
        int maxArea = 0;
        Stack<Integer> stk = new Stack<>();
        for(int i = 0 ; i <= n ; i++){
            int current = (i == n) ? 0 : heights[i];
            while(!stk.isEmpty() && current < heights[stk.peek()]){
                int height = heights[stk.pop()];
                int width = (stk.isEmpty()) ? i : i - stk.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stk.push(i);
        }
        return maxArea;
    }
    public static void main(String[] args) {
        char[][]  matrix = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        System.out.println(maximalRectangle(matrix));
    }
}
