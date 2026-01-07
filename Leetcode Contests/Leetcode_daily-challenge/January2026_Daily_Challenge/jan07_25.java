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
public class jan07_25 {
    static int MOD = 1000000007;
    static long max = Long.MIN_VALUE;
    public static int maxProduct(TreeNode root) {
        long sum = totalSum(root);
        dfs(root, sum);
        return (int) (max % MOD);
    }
    public static long dfs(TreeNode root, long sum){
        if(root == null) return 0;
        long left = dfs(root.left, sum);
        long right = dfs(root.right, sum);
        long currSum = left + right + root.val;
        max = Math.max(max, (sum - currSum) * currSum);
        return currSum;
    }
    public static long totalSum(TreeNode root){
        if(root == null) return 0;
        long left = totalSum(root.left);
        long right = totalSum(root.right);
        return left + right + root.val;
    }
    public static void main(String[] args) {
        TreeNode root1 =
            new TreeNode(1,
                new TreeNode(2,
                    new TreeNode(4),
                    new TreeNode(5)),
                new TreeNode(3,
                    new TreeNode(6),
                    null));

        max = Long.MIN_VALUE;
        System.out.println(maxProduct(root1));

        TreeNode root2 =
            new TreeNode(1,
                null,
                new TreeNode(2,
                    new TreeNode(3),
                    new TreeNode(4,
                        new TreeNode(5),
                        new TreeNode(6))
                    ));

        max = Long.MIN_VALUE;
        System.out.println(maxProduct(root2));
    }
}
