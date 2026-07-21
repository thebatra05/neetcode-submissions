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
    public int rob(TreeNode root) {
        Pair<Integer, Integer> data = helper(root);
        return Math.max(data.getKey(), data.getValue());
    }
    Pair<Integer, Integer> helper(TreeNode node) {
        if (node == null) return new Pair<>(0, 0);

        Pair<Integer, Integer> leftData = helper(node.left);
        Pair<Integer, Integer> rightData = helper(node.right);

        int withRoot = node.val + leftData.getValue() + rightData.getValue(); 
        int withoutRoot = Math.max(rightData.getKey(), rightData.getValue()) + Math.max(leftData.getKey(), leftData.getValue());

        return new Pair<>(withRoot, withoutRoot);
    }
}