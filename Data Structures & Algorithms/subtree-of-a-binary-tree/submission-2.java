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
    private String serialize(TreeNode node) {
        if (node == null) return "$#";

        return "$" + node.val + serialize(node.left) + serialize(node.right);
    }  
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (subRoot == null) return true;
        if (root == null) return false;

        String serializedRoot = serialize(root);
        String serializedSubRoot = serialize(subRoot);

        if (serializedRoot.contains(serializedSubRoot)) return true;

        return false;
    }


    /*

            1
           / \
          2   3     2
         / \       / \
        4   5     4   5
    */
}
