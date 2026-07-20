/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    Map<Node, Node> map = new HashMap<>();
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        
        Queue<Node> q = new LinkedList<>();
        map.put(node, new Node(node.val));
        q.add(node);

        while (!q.isEmpty()) {
            Node n = q.poll();
            if (n == null) continue;
            
            for (Node neigh : n.neighbors) {
                if (!map.containsKey(neigh)) {
                    map.put(neigh, new Node(neigh.val));
                    q.add(neigh);
                }
                map.get(n).neighbors.add(map.get(neigh));
            }

        }

        return map.get(node);
    }

    /*
        1 ----------- 2         1 
                     /
                    /
                   /
                  /
                 3
    */
}