/**530. Minimum Absolute Difference in BST
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
    TreeNode pre;
    int result = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        if(root == null)return 0;
        travel(root);
        return result;
    }
    public void travel(TreeNode root){
        if(root == null)return;
        travel(root.left);
        if(pre != null){
            result = Math.min(result, root.val - pre.val);
        }
        pre = root;
        travel(root.right);
    }
}
/**501. Find Mode in Binary Search Tree
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
    ArrayList<Integer> list;
    int maxCount;
    int count;
    TreeNode pre;
    public int[] findMode(TreeNode root) {
        list = new ArrayList<>();
        maxCount = 0;
        count = 0;
        pre = null;
        travel(root);
        int[] res = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            res[i] = list.get(i);
        }
        return res;
    }
    public void travel(TreeNode root){
        if(root == null)return;
        travel(root.left);
        if(pre == null || pre.val != root.val){
            count = 1;
        }else{
            count++;
        }
        if(count > maxCount){
            list.clear();
            list.add(root.val);
            maxCount = count;
        }else if(count == maxCount){
            list.add(root.val);
        }
        pre = root;
        travel(root.right);
    }
}
/**236. Lowest Common Ancestor of a Binary Tree
 * 
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q)return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left == null && right == null)return null;
        if(left == null && right != null){
            return right;
        }else if(left != null && right == null){
            return left;
        }else{
            return root;
        }
    }
}
/**235. Lowest Common Ancestor of a Binary Search Tree
 * 
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root.val > p.val && root.val > q.val){
            return lowestCommonAncestor(root.left, p, q);
        }
        if(root.val < p.val && root.val < q.val){
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;
    }
}
/**701. Insert into a Binary Search Tree
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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null)return new TreeNode(val);
        if(root.val < val){
            root.right = insertIntoBST(root.right, val);
        }else if(root.val > val){
            root.left = insertIntoBST(root.left, val);
        }
        return root;
    }
}