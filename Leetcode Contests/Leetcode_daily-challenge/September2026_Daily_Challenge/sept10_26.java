public class sept10_26 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    static int ans = 0;
    public static  int averageOfSubtree(TreeNode root) {
        dfs(root);
        return ans;
    }
    private static  int[] dfs(TreeNode node){
        if(node == null){
            return new int[]{0, 0};
        }
        int[] left = dfs(node.left);
        int[] right = dfs(node.right);
        int sum = left[0] + right[0] + node.val;
        int count = left[1] + right[1] + 1;
        int average = sum / count;
        if(node.val == average){
            ans++;
        }
        return new int[]{sum, count};
    }
    public static void main(String[] args) {
        sept10_26 obj = new sept10_26();

        TreeNode root = obj.new TreeNode(4);

        root.left = obj.new TreeNode(8);
        root.right = obj.new TreeNode(5);

        root.left.left = obj.new TreeNode(0);
        root.left.right = obj.new TreeNode(1);

        root.right.right = obj.new TreeNode(6);

        int result = averageOfSubtree(root);

        System.out.println(result);
    }
}
