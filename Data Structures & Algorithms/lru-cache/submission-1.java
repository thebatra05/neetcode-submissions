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
    private int cap;
    private Map<Integer, Node> cache;
    private Node left;
    private Node right;

    public LRUCache(int capacity) {
        this.cap = capacity;
        cache = new HashMap<>();
        this.left = new Node(0, 0);
        this.right = new Node(0, 0);
        this.right.prev = this.left;
        this.left.next = this.right;
    }

    private void insert(Node node) {
        Node prev = this.right.prev;
        prev.next = node;
        node.prev = prev;
        this.right.prev = node;
        node.next = this.right;
    }

    private void remove(Node node) {
        Node next = node.next;
        Node prev = node.prev;
        prev.next = next;
        next.prev = prev;
    }
    
    public int get(int key) {
        if (!cache.containsKey(key)) return -1;
        
        Node n = cache.get(key);
        remove(n);
        insert(n);

        return cache.get(key).value;
    }
    
    public void put(int key, int value) {
        if (cache.containsKey(key)) remove(cache.get(key));

        Node node = new Node(key, value);
        cache.put(node.key, node);
        insert(node);

        if (cache.size() > cap) {
            Node lru = this.left.next;
            remove(lru);
            cache.remove(lru.key);
        }
    }
}
