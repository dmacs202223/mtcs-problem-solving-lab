class LRUCache {
    
    class Node {
        int key;
        int val;
        Node prev;
        Node next;
        
        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    HashMap<Integer, Node> hmap = new HashMap<>();
    Node head = new Node(0,0);
    Node tail = new Node(0,0);
    int _capacity;
    
    public LRUCache(int capacity) {        
        _capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(hmap.containsKey(key)) {
            Node node = hmap.get(key);
            remove(node);
            insert(node);
            return node.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(hmap.containsKey(key))
            remove(hmap.get(key));
        if(hmap.size() == _capacity)
            remove(tail.prev);
        Node new_node = new Node(key, value);
        insert(new_node);
    }
    
    public void remove(Node node) {
        hmap.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    public void insert(Node node) {
        hmap.put(node.key, node);
        Node headNext = head.next;
        node.prev = head;
        node.next = headNext;
        head.next = node;
        headNext.prev = node;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
