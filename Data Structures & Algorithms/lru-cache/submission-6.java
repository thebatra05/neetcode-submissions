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
    int cap;
    Node left;
    Node right;
    public LRUCache(int capacity) {
        this.cache = new HashMap<>();
        this.cap = capacity;
        this.left = new Node(0, 0);
        this.right = new Node(0, 0);
        this.left.next = this.right;
        this.right.prev = this.left;
    }

    private void add(Node node) {
        Node prev = this.right.prev;
        node.next = this.right;
        node.prev = prev;
        prev.next = node;
        this.right.prev = node;
    }

    private void remove(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }
    
    public int get(int key) {
        if (!cache.containsKey(key)) return -1;

        Node node = cache.get(key);
        remove(node);
        add(node);

        return node.value;
    }
    
    public void put(int key, int value) {
        if (cache.containsKey(key)) remove(cache.get(key));

        Node node = new Node(key, value);
        add(node);
        cache.put(key, node);

        if (cache.size() > cap) {
            Node lru = this.left.next;
            remove(lru);
            cache.remove(lru.key);
        }
    }
}
