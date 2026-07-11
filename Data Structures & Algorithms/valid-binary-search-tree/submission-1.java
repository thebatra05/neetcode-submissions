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
    private boolean helper(TreeNode node, int minValue, int maxValue) {
        if (node == null) return true;
        if (node.val <= minValue || node.val >= maxValue) return false;

        return helper(node.left, minValue, node.val) && 
        helper(node.right, node.val, maxValue);
    }
    public boolean isValidBST(TreeNode root) {
        return helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
}
