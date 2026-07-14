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
    int idx = 0;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "N";

        return root.val + "," + serialize(root.left) + "," + serialize(root.right);
    }

    /*
           1,2,N,N,3,4,N,N,5,N,N

        $2,N,N          $3,$4,N,N,$5,N,N
                        $4,N,N      $5,N,N

            
        1       
                idx = 1
      /
     2          idx = 2
    /
    null
    */
    private TreeNode deserializeHelper(String[] dataArray) {
        if (dataArray[idx].equals("N")) return null;

        TreeNode root = new TreeNode(Integer.parseInt(dataArray[idx++]));
        root.left = deserializeHelper(dataArray);
        idx++;
        root.right = deserializeHelper(dataArray);

        return root;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        
        String[] dataArray = data.split(",");

        for (String d : dataArray) System.out.print(d + " ");
        
        return deserializeHelper(dataArray);
    }
}
