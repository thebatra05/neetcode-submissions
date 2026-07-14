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

        int leftSum = Math.max(0, dfs(node.left));
        int rightSum = Math.max(0, dfs(node.right));
        ans = Math.max(ans, leftSum + node.val + rightSum);

        return node.val + Math.max(leftSum, rightSum);
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
