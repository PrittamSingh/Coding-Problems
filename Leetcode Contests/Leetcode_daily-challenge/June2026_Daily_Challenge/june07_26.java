import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class june07_26 {
    public static class TreeNode {
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
    public static TreeNode createBinaryTree(int[][] descriptions) {
        HashMap<Integer, TreeNode> map = new HashMap<>();
        Set<Integer> children = new HashSet<>();
        for(int[] d : descriptions){
            int parent = d[0];
            int child = d[1];
            int isLeft = d[2];
            map.putIfAbsent(parent, new TreeNode(parent));
            map.putIfAbsent(child, new TreeNode(child));
            TreeNode parentNode = map.get(parent);
            TreeNode childNode = map.get(child);
            if(isLeft == 1){
                parentNode.left = childNode;
            }
            else{
                parentNode.right = childNode;
            }
            children.add(child);
        }
        for(int val : map.keySet()){
            if(!children.contains(val)){
                return map.get(val);
            }
        }
        return null;
    }
    public static void main(String[] args) {
        int[][] descriptions = {{20,15,1},{20,17,0},{50,20,1},{50,80,0},{80,19,1}};
        TreeNode root = createBinaryTree(descriptions);
        System.out.println(root.val); // Output: 50
    }
}
