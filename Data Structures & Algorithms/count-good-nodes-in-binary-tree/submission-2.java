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
    private int count = 0;
    
    public int goodNodes(TreeNode root) {
        if (root == null) return count;

        Stack<Pair<TreeNode, Integer>> stack = new Stack<>();
        stack.add(new Pair<>(root, Integer.MIN_VALUE));   

        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> data = stack.pop();
            TreeNode node = data.getKey();
            int maxSoFar = data.getValue();
            if (node.val >= maxSoFar) {
                count += 1;
                maxSoFar = node.val;
            }
            if (node.left != null) stack.push(new Pair<>(node.left, maxSoFar));
            if (node.right != null) stack.push(new Pair<>(node.right, maxSoFar));
        }

        return count;
    }
}
