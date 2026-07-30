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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "N,";

        return root.val + "," + serialize(root.left) + serialize(root.right);
    }

    /*
        0 1 2 3 4 5 6 7 8 9 10
        1 2 N N 3 4 N N 5 N N 
        
        1
       /
      2

    */

    private TreeNode helper(String[] dataList, int[] idx) {
        if (idx[0] == dataList.length || dataList[idx[0]].equals("N")) return null;
        
        TreeNode root = new TreeNode(Integer.valueOf(dataList[idx[0]]));
        idx[0] += 1;
        root.left = helper(dataList, idx);
        idx[0] += 1;
        root.right = helper(dataList, idx);

        return root;
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] dataList = data.split(",");
        int[] idx = new int[]{0};

        return helper(dataList, idx);
    }
}
