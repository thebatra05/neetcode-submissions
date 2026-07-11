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

        Queue<Pair<TreeNode, Integer>> q = new LinkedList<>();
        q.add(new Pair<>(root, Integer.MIN_VALUE));   

        while (!q.isEmpty()) {
            Pair<TreeNode, Integer> data = q.poll();
            TreeNode node = data.getKey();
            int maxSoFar = data.getValue();
            if (node.val >= maxSoFar) {
                count += 1;
                maxSoFar = node.val;
            }
            if (node.left != null) q.add(new Pair<>(node.left, maxSoFar));
            if (node.right != null) q.add(new Pair<>(node.right, maxSoFar));
        }

        return count;
    }
}
