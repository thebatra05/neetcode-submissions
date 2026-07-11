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
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;

        Stack<Pair<TreeNode, int[]>> stack = new Stack<>();
        stack.add(new Pair<>(root, new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE}));

        while (!stack.isEmpty()) {
            Pair<TreeNode, int[]> data = stack.pop();
            TreeNode node = data.getKey();
            int minValue = data.getValue()[0];
            int maxValue = data.getValue()[1];
            if (node.val <= minValue || node.val >= maxValue) return false;
            if (node.left != null) stack.add(new Pair<>(node.left, new int[]{minValue, node.val}));
            if (node.right != null) stack.add(new Pair<>(node.right, new int[]{node.val, maxValue}));
        }

        return true;
    }
}
