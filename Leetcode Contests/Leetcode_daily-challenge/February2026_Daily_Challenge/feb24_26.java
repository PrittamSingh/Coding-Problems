public class feb24_26 {
    public static int solve(TreeNode root, int val){
        if(root == null){
            return 0;
        }
        val = (2 * val) + root.val;
        if(root.left == null && root.right == null){
            return val;
        }
        return solve(root.left, val) + solve(root.right, val);
    }
    public static int sumRootToLeaf(TreeNode root) {
        return solve(root, 0);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);

        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(1);

        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(1);

        System.out.println(sumRootToLeaf(root));
    }
}
