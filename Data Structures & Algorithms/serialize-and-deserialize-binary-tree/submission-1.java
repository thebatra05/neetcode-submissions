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
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        StringBuilder sb = new StringBuilder();

        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node == null) {
                sb.append("N,");
            } else {
                sb.append(node.val + ",");
                q.add(node.left);
                q.add(node.right);
            }
        }

        return sb.toString();
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


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        
        String[] dataArray = data.split(",");
        // for (String d : dataArray) System.out.print(d + " ");
        int idx = 0;
        if (dataArray[idx].equals("N")) return null;
        TreeNode root = new TreeNode(Integer.parseInt(dataArray[idx++]));
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (!dataArray[idx].equals("N")) {
                node.left = new TreeNode(Integer.parseInt(dataArray[idx]));
                q.add(node.left);
            }
            idx++;
            if (!dataArray[idx].equals("N")) {
                node.right = new TreeNode(Integer.parseInt(dataArray[idx]));
                q.add(node.right);
            }
            idx++;
        }
        
        return root;
    }
}
