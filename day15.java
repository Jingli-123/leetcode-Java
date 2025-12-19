/**110. Balanced Binary Tree
 * Given a binary tree, determine if it is height-balanced.
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
        return getHeight(root) != -1;
    }
    public int getHeight(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftHeight = getHeight(root.left);
        if(leftHeight == -1)return -1;
        int rightHeight = getHeight(root.right);
        if(rightHeight == -1)return -1;
        if(Math.abs(leftHeight - rightHeight) > 1){
            return -1;
        }
        return Math.max(leftHeight, rightHeight) + 1;

    }
}
/**257. Binary Tree Paths
 * 
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        List<Integer> paths = new ArrayList<>();
        traversal(root, paths, res);
        return res;
    }
    public void traversal(TreeNode root, List<Integer> paths, List<String> res){
        paths.add(root.val);
        if(root.left == null && root.right == null){
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < paths.size()-1; i++){
                sb.append(paths.get(i)).append("->");
            }
            sb.append(paths.get(paths.size()-1));
            res.add(sb.toString());
            return;
        }
        if(root.left != null){
            traversal(root.left, paths, res);
            paths.remove(paths.size()-1);
        }
        if(root.right != null){
            traversal(root.right, paths, res);
            paths.remove(paths.size()-1);
        }
    }
}
/**404. Sum of Left Leaves
 * 
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        int sum = 0;
        if(root == null)return sum;
        List<Integer> paths = new ArrayList<>();
        left(root, paths);
        for(int i = 0; i < paths.size(); i++){
            sum+=paths.get(i);
        }
        return sum;
    }
    public void left(TreeNode root, List<Integer> paths){
        if(root.left == null && root.right==null)return;
        if(root.left != null && root.left.left == null && root.left.right == null){
            paths.add(root.left.val);
        }
        if(root.left != null && (root.left.left != null || root.left.right != null)){
            left(root.left, paths);
        }
        if(root.right != null){
            left(root.right, paths);
        }
    }
}