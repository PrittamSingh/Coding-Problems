import java.util.Stack;

public class MaximalRectangle {
    public static int maximalRectangle(char[][] matrix) {
        int maxArea = 0;
        int cols = matrix[0].length;
        int[] heights = new int[cols];

        for(int i = 0 ; i < matrix.length ; i++){
            for(int j = 0 ; j < cols ; j++){
                if(matrix[i][j] == '1') heights[j]++;
                else heights[j] = 0;
            }
            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }
        return maxArea;
    }
    public static int largestRectangleArea(int[] heights){
        int maxArea = 0;
        int n = heights.length;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0 ; i <= n ; i++){
            int h = (i == n ? 0 : heights[i]);
            while(!stack.isEmpty() && h < heights[stack.peek()]){
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }
        return maxArea;
    }
    public static void main(String args[]){
        char[][] matrix = {{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
        System.out.println(maximalRectangle(matrix));
    }
}
