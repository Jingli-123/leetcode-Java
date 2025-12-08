/**102. Binary Tree Level Order Traversal
 * https://leetcode.com/problems/binary-tree-level-order-traversal/description/
 * Given the root of a binary tree, return the level order traversal of its nodes' 
 * values. (i.e., from left to right, level by level).
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
    public List<List<Integer>> result = new ArrayList<List<Integer>>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        int level = 0;
        level(root, level);
        return result;
    }
    public void level(TreeNode root, int level){
        if(root == null) return;
        level++;
        if(result.size() < level){
            List<Integer> item = new ArrayList<Integer>();
            result.add(item);
        }
        result.get(level - 1).add(root.val);
        level(root.left, level);
        level(root.right, level);
    }
}

/**107. Binary Tree Level Order Traversal II
 * https://leetcode.com/problems/binary-tree-level-order-traversal-ii/description/
 * Given the root of a binary tree, return the bottom-up level order traversal of 
 * its nodes' values. (i.e., from left to right, level by level from leaf to root).
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
    public List<List<Integer>> result = new ArrayList<List<Integer>>();
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        int level = 0;
        level(root, level);
        Collections.reverse(result);
        return result;
    }
    public void level(TreeNode root, int level){
        if(root == null)return;
        level++;
        
        if(result.size()<level){
            List<Integer> item = new ArrayList<Integer>();
            result.add(item);
        }
        level(root.left, level);
        level(root.right, level);
        result.get(level - 1).add(root.val);
    }
}

/**199. Binary Tree Right Side View
 * https://leetcode.com/problems/binary-tree-right-side-view/description/
 * Given the root of a binary tree, imagine yourself standing on the right 
 * side of it, return the values of the nodes you can see ordered from top to bottom.
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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        Deque<TreeNode> que = new LinkedList<>();
        if(root == null)return result;
        que.offerLast(root);
        while(!que.isEmpty()){
            int level = que.size();
            for(int i = 0; i < level; i++){
                TreeNode poll = que.pollFirst();
                if(poll.left != null){
                    que.addLast(poll.left);
                }
                if(poll.right != null){
                    que.addLast(poll.right);
                }
                if(i == level -1){
                    result.add(poll.val);
                }
            }
        }
        return result;
        
    }
}