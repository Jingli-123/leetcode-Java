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
/**637. Average of Levels in Binary Tree
 * https://leetcode.com/problems/average-of-levels-in-binary-tree/description/
 * Given the root of a binary tree, return the average value of the nodes on each 
 * level in the form of an array. Answers within 10-5 of the actual answer will be accepted.
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
    public List<List<Integer>> list = new ArrayList<List<Integer>>();
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> list = new ArrayList<Double>();
        Deque<TreeNode> que = new LinkedList<>();
        if(root == null){
            return list;
        }
        que.offerLast(root);
        while(!que.isEmpty()){
            int levelsize = que.size();
            double sum = 0.0;
            for(int i = 0; i < levelsize; i++){
                TreeNode poll = que.pollFirst();
                sum += poll.val;
                if(poll.left != null){
                    que.addLast(poll.left);
                }
                if(poll.right != null){
                    que.addLast(poll.right);
                }
            }
            list.add(sum/levelsize);
        }
        return list;
    }

    /**429. N-ary Tree Level Order Traversal
     * 
     */
    /*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> list = new ArrayList<>();
        Deque<Node> que = new LinkedList<>();
        if(root == null)return list;
        que.addLast(root);
        while(!que.isEmpty()){
            int level = que.size();
            List<Integer> levellist = new ArrayList<>();
            for(int i = 0; i < level; i++){
                Node poll = que.pollFirst();
                levellist.add(poll.val);
                List<Node> children = poll.children;
                if(children == null || children.size() == 0){
                    continue;
                }
                for(Node child : children){
                    if (child != null) {
                        que.offerLast(child);
                    }
                }
            }
            list.add(levellist);
        }
        return list;
    }
}

/**515. Find Largest Value in Each Tree Row
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
    public List<Integer> largestValues(TreeNode root) {
        if(root == null){
            return Collections.emptyList();
        }
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> que = new LinkedList<>();
        if(root == null)return list;
        que.offerLast(root);
        while(!que.isEmpty()){
            int level = que.size();
            int max = Integer.MIN_VALUE;
            for(int i = 0; i < level; i++){
                TreeNode poll = que.pollFirst();
                max = Math.max(max, poll.val);
                if (poll.left != null) que.offerLast(poll.left);
                if (poll.right != null) que.offerLast(poll.right);
            }
            list.add(max);
            
        }
        return list;
    }
}
/**116. Populating Next Right Pointers in Each Node
 * You are given a perfect binary tree where all leaves are on the 
 * same level, and every parent has two children. The binary tree has 
 * the following definition:

struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}
Populate each next pointer to point to its next right node. If there 
is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.
 */
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        Deque<Node> que = new LinkedList<>();
        if(root == null)return root;
        que.offerLast(root);
        while(!que.isEmpty()){
            int level = que.size();
            for(int i = 0; i < level; i++){
                Node poll = que.pollFirst();
                if(i != level - 1){
                    poll.next = que.peekFirst();
                }else{
                    poll.next = null;
                }
                if(poll.left != null)que.offerLast(poll.left);
                if(poll.right != null)que.offerLast(poll.right);
            }
        }
        return root;
    }
}
/**117. Populating Next Right Pointers in Each Node II
 * 
 */
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        Deque<Node> que = new LinkedList<>();
        if(root == null)return root;
        que.offerLast(root);
        while(!que.isEmpty()){
            int level = que.size();
            for(int i = 0; i < level; i++){
                Node poll = que.pollFirst();
                if(i != level - 1){
                    poll.next = que.peekFirst();
                }else{
                    poll.next = null;
                }
                if(poll.left != null)que.offerLast(poll.left);
                if(poll.right != null)que.offerLast(poll.right);
            }
        }
        return root;
    }
}
/**104. Maximum Depth of Binary Tree
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
    public int maxDepth(TreeNode root) {
        if(root == null)return 0;
        Deque<TreeNode> que = new LinkedList<>();
        int deep = 0;
        que.offerLast(root);
        while(!que.isEmpty()){
            deep++;
            int size = que.size();
            for(int i = 0; i < size; i++){
                TreeNode poll = que.pollFirst();
                if(poll.left!=null)que.offerLast(poll.left);
                if(poll.right!=null)que.offerLast(poll.right);
            }

        }
        return deep;
    }
}
/**111. Minimum Depth of Binary Tree
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
    public int minDepth(TreeNode root) {
        if(root == null)return 0;
        Deque<TreeNode> que = new LinkedList<>();
        que.offerLast(root);
        int deep = 0;
        while(!que.isEmpty()){
            deep++;
            int size = que.size();
            for(int i = 0; i < size; i++){
                TreeNode poll = que.pollFirst();
                if(poll.left == null && poll.right == null){
                    return deep;
                }
                if(poll.left!=null)que.offerLast(poll.left);
                if(poll.right!=null)que.offerLast(poll.right);
            }
        }
        return deep;
    }
}