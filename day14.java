/**226. Invert Binary Tree
 * Given the root of a binary tree, invert the tree, and return its root.
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
    public TreeNode invertTree(TreeNode root) {
        if(root == null)return root;
        Deque<TreeNode> que = new LinkedList<>();
        que.offerLast(root);
        while(!que.isEmpty()){
            TreeNode poll = que.pollFirst();
            if(poll.left != null && poll.right != null){
                TreeNode temp = poll.left;
                poll.left = poll.right;
                poll.right = temp;
                que.offerLast(poll.left);
                que.offerLast(poll.right);
            }else if(poll.left != null && poll.right == null){
                poll.right = poll.left;
                poll.left = null;
                que.offerLast(poll.right);
            }else if(poll.right != null && poll.left == null){
                poll.left = poll.right;
                poll.right = null;
                que.offerLast(poll.left);
            }
        }
        return root;
    }
}
/**101. Symmetric Tree
 * Given the root of a binary tree, 
 * check whether it is a mirror of itself (i.e., symmetric around its center).
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
    public boolean isSymmetric(TreeNode root) {
        TreeNode left = root.left;
        TreeNode right = root.right;
        return compare(left, right);
    }

    public boolean compare(TreeNode left, TreeNode right){
        if(left == null && right != null){
            return false;
        }else if(left != null && right == null){
            return false;
        }else if(left == null && right == null){
            return true;
        }else if(left.val != right.val){
            return false;
        }else{
            boolean outside = compare(left.left, right.right);
            boolean inside = compare(left.right, right.left);
            return outside & inside;
        }
    }
}

