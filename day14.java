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

/**112. Path Sum
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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null)return false;
        targetSum -= root.val;
        if(root.left == null && root.right == null)return targetSum == 0;
        if(root.right != null){
            boolean right = hasPathSum(root.right, targetSum);
            if(right)return true;
        }
        if(root.left != null){
            boolean left = hasPathSum(root.left, targetSum);
            if(left)return true;
        }
        return false;
    }
}

/**113. Path Sum II
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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> path = new ArrayList<>();
        List<Integer> item = new ArrayList<>();
        if(root == null)return path;
        travel(root, targetSum, path, item);
        return path;
    }
    public void travel(TreeNode root, int targetSum, List<List<Integer>> path, List<Integer> item){
        item.add(root.val);
        targetSum -= root.val;
        if(root.left == null && root.right == null){
            if(targetSum == 0){
                path.add(new ArrayList<>(item));
            }
            return;
        }
        if(root.left != null){
            travel(root.left, targetSum, path, item);
            item.remove(item.size() - 1);
        }
        if(root.right != null){
            travel(root.right, targetSum, path, item);
            item.remove(item.size() - 1);
        }
    }
}