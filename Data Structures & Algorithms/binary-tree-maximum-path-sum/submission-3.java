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
    private int ans = Integer.MIN_VALUE;
    
    private int dfs(TreeNode node) {
        if (node == null) return 0;

        int leftSum = dfs(node.left);
        int rightSum = dfs(node.right);
        ans = Math.max(ans, Math.max(node.val, leftSum + node.val + rightSum));
        ans = Math.max(ans, Math.max(leftSum + node.val, rightSum + node.val));

        return Math.max(0, Math.max(leftSum + node.val, rightSum + node.val));
    }

    public int maxPathSum(TreeNode root) {
        dfs(root);

        return ans;    
    }

    /*
            -15
            / \
          10   20
              /  \
             15   5
            / 
           -5
           

    */
}
