import java.util.*;
 
public class jan06_25 {
    static public class TreeNode {
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
    public static int maxLevelSum(TreeNode root) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        int level = 1;
        int ans = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int cnt = q.size();
            sum = 0;
            for(int i = 0 ; i < cnt ; i++){
                TreeNode node = q.poll();
                sum += node.val;
                if(node.left != null){
                    q.add(node.left);
                }
                if(node.right != null){
                    q.add(node.right);
                }
            }
            if(max < sum){
                max = sum;
                ans = level;
            }
            level++;
        }
        return ans;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(7);
        root.right = new TreeNode(0);
        root.left.left = new TreeNode(7);
        root.left.right = new TreeNode(-8);

        System.out.println(maxLevelSum(root));

        TreeNode root2 = new TreeNode(989);

        root2.right = new TreeNode(10250);
        root2.right.left = new TreeNode(98693);
        root2.right.right = new TreeNode(-89388);
        root2.right.left.left = new TreeNode(-32127);

        System.out.println(maxLevelSum(root2));
    }
}
