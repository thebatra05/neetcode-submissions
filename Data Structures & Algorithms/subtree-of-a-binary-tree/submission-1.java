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
    private boolean helper(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) return true;
        if (node1 == null || node2 == null || node1.val != node2.val) return false;

        return helper(node1.left, node2.left) && helper(node1.right, node2.right);
    }  
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) return true;
        if (root == null || subRoot == null) return false;
        boolean result = false;
        if (root.val == subRoot.val) result = helper(root, subRoot);
        

        return result || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }


    /*

            1
           / \
          2   3     2
         / \       / \
        4   5     4   5
    */
}
