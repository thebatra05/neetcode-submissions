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
    private int depth = 0;
    
    void helper(TreeNode node, int currDepth) {
        if (node == null) return;
        currDepth += 1;
        depth = Math.max(depth, currDepth);
        helper(node.left, currDepth);
        helper(node.right, currDepth);
    }
    public int maxDepth(TreeNode root) {
        helper(root, 0);

        return depth;    
    }
}
