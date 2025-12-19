/**654. Maximum Binary Tree
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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums, 0, nums.length);
    }
    public TreeNode build(int[] nums, int left, int right){
        if(right - left < 1)return null;
        if(right - left == 1)return new TreeNode(nums[left]);
        int maxIdx = left;
        int max = nums[maxIdx];
        for(int i = left + 1; i < right; i++){
            if(nums[i] > max){
                max = nums[i];
                maxIdx = i;
            }
        }
        TreeNode root = new TreeNode(max);
        root.left = build(nums, left, maxIdx);
        root.right = build(nums, maxIdx+1, right);
        return root;
    }
}
/**617. Merge Two Binary Trees
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
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1 == null)return root2;
        if(root2 == null)return root1;
        root1.val += root2.val;
        root1.left = mergeTrees(root1.left, root2.left);
        root1.right = mergeTrees(root1.right, root2.right);
        return root1;
    }
}