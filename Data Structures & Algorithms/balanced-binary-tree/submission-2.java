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
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;

        Map<TreeNode, Pair<Integer, Boolean>> map = new HashMap<>();
        map.put(null, new Pair<>(0, true));
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();
            if (node.left != null && !map.containsKey(node.left)) {
                stack.push(node.left);
            } else if (node.right != null && !map.containsKey(node.right)) {
                stack.push(node.right);
            } else {
                stack.pop();
                Pair<Integer, Boolean> leftData = map.get(node.left);
                Pair<Integer, Boolean> rightData = map.get(node.right);

                Pair<Integer, Boolean> nodeData = new Pair<>(1 + Math.max(leftData.getKey(), rightData.getKey()), leftData.getValue() && rightData.getValue() && Math.abs(leftData.getKey() - rightData.getKey()) <= 1);
                map.put(node, nodeData);
            }
        }

        return map.get(root).getValue();
    }
}
