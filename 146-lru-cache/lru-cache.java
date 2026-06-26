class LRUCache {

    HashMap<Integer, Node> map;
    Node head;
    Node tail;
    int capacity;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        this.capacity = capacity;
        head = new Node(-1, -1, null, null);
        tail = new Node(-1, -1, null, null);

        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;

        Node node = map.get(key);
       
        remove(node);
        insertLast(node);

        return node.value;
    }
    
    public void put(int key, int value) {
        if(capacity == 0) return;

        if(map.containsKey(key)){
            Node node = map.get(key);
            node.value = value;
            remove(node);
            insertLast(node);
            return;
        }

        if(map.size() == capacity){
            Node leastUsed = head.next;
            remove(leastUsed);
            map.remove(leastUsed.key);
        }

        Node node = new Node(key, value, null, null);
        insertLast(node);
        map.put(key, node);
    }

    private void remove(Node node){
        Node prevNode = node.prev;
        Node nextNode = node.next;

        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }

    private void insertLast(Node node){
        Node prevNode = tail.prev;

        prevNode.next = node;
        node.prev = prevNode;
        tail.prev = node;
        node.next = tail;
    }
}

class Node{
    int key;
    int value;
    Node prev;
    Node next;

    public Node(int k, int v, Node p, Node n){
        this.key = k;
        this.value = v;
        prev = p;
        next = n;
    }
}


/*

    (key, value) -> HashMap -> O(1) : get() & put()

    if(cap.isFull()){

    }

    # used : operation -> cnt + 1
        - Multuple key have same cnt (X)


    Recent usage : LinkedList
        
    [1,1] -> [2,2] -> [3,3] -> [4,4]


    1 HashMaps :  key -> node (key, value, prev, next)


    1) get(key): 
            value = map.get(key)
            reoder list -> put node at last
            return value == null ? -1 : value

    
    2) put(key, value):
            if(map.contiansKey(key)) node.val = value
            else bild node

            if(map.size() == cap):
                remove head 
                delete map.entry()

            reoder list -> put node at last
*/