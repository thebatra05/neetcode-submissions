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
    private Pair<Integer, Boolean> helper(TreeNode node) {
        if (node == null) return new Pair<>(0, true);

        Pair<Integer, Boolean> leftData = helper(node.left);
        Pair<Integer, Boolean> rightData = new Pair<>(0, false);
        if (leftData.getValue()) 
            rightData = helper(node.right);

        
        return new Pair<>(1 + Math.max(leftData.getKey(), rightData.getKey()), 
        leftData.getValue() && rightData.getValue() && Math.abs(leftData.getKey() - rightData.getKey()) <= 1);

    }
    public boolean isBalanced(TreeNode root) {
        return helper(root).getValue();
    }
}
