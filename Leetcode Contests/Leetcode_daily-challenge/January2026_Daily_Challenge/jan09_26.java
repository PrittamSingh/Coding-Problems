import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
public class jan09_26 {
    static class Pair{
        TreeNode node;
        int dist;
        Pair(TreeNode node, int dist){
            this.node = node;
            this.dist = dist;
        }
    }
    public static TreeNode subtreeWithAllDeepest(TreeNode root){
        Pair p = solve(root, 0);
        return p.node;
    }
    public static Pair solve(TreeNode root, int d){
        if(root == null) return new Pair(null, d);
        Pair l = solve(root.left, d + 1);
        Pair r = solve(root.right, d + 1);
        if(l.dist == r.dist){
            return new Pair(root, l.dist);
        }
        else{
            return l.dist > r.dist ? l : r;
        }
    }
    // public TreeNode subtreeWithAllDeepest(TreeNode root) {
    //     int l = height(root.left);
    //     int r = height(root.right);
    //     if(l == r) return root;
    //     TreeNode node;
    //     if(l > r){
    //         node = subtreeWithAllDeepest(root.left);
    //     }
    //     else{
    //         node = subtreeWithAllDeepest(root.right);
    //     }
    //     return node;
    // }
    // public int height(TreeNode root){
    //     if(root == null) return 0;
    //     int l = height(root.left);
    //     int r = height(root.right);
    //     return Math.max(l, r) + 1;
    // }
    public static void main(String[] args) {
        TreeNode root =
            new TreeNode(3,
                new TreeNode(5,
                    new TreeNode(6),
                    new TreeNode(2,
                        new TreeNode(7),
                        new TreeNode(4))),
                new TreeNode(1,
                    new TreeNode(0),
                    new TreeNode(8))
            );
        System.out.println(subtreeWithAllDeepest(root).val);
    }
}
