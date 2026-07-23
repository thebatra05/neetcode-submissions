class Node {
    int key;
    int value;
    Node prev;
    Node next;
    Node(int k, int v) {
        this.key = k;
        this.value = v;
        this.prev = null;
        this.next = null;
    }
}
class LRUCache {
    Map<Integer, Node> cache;
    Node left;
    Node right;
    int size;

    public LRUCache(int capacity) {
        cache = new HashMap<>();
        this.left = new Node(0, 0);
        this.right = new Node(0, 0);
        this.right.prev = this.left;
        this.left.next = this.right;
        this.size = capacity;
    }

    private void add(Node node) {
        Node prev = this.right.prev;
        this.right.prev = node;
        node.next = this.right;
        node.prev = prev;
        prev.next = node;
    }

    private void remove(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        next.prev = prev;
        prev.next = next;
    }
    
    public int get(int key) {
        if (!cache.containsKey(key)) return -1;

        Node node = cache.get(key);
        remove(node);
        add(node);

        return cache.get(key).value;
    }
    
    public void put(int key, int value) {
        if (cache.containsKey(key)) remove(cache.get(key));
              
        Node node = new Node(key, value);
        add(node);
        cache.put(key, node);
        if (cache.size() > size) {
            Node lru = this.left.next;
            remove(lru);
            cache.remove(lru.key);
        }
    }

    /*

        Map<Key, Node> 

        Left --- Right
        1. add to the right
        2. remove from left

        Node:
            key;
            value;
            prev;
            next;
               
    */
}
