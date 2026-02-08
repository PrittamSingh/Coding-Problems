import java.util.*;

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
public class feb08_26 {
    public static boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        boolean b1 = isBalanced(root.left);
        boolean b2 = isBalanced(root.right);
        if(Math.abs(height(root.left) - height(root.right)) > 1){
            return false;
        }
        return b1 && b2;
    }
    public static int height(TreeNode root){
        if(root == null) return 0;
        int l = height(root.left);
        int r = height(root.right);
        return Math.max(l, r) + 1;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.err.println(isBalanced(root));

        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(2);

        root1.left.left = new TreeNode(3);
        root1.left.right = new TreeNode(3);

        root1.left.left.left = new TreeNode(4);
        root1.left.left.right = new TreeNode(4);
        System.err.println(isBalanced(root1));
    }
}
