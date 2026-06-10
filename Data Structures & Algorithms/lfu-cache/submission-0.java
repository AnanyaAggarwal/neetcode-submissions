public class Node {
    int key;
    int val;
    int freq;
    Node next;
    Node prev;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
        this.freq = 1;
    }

    public Node(int key, int val, int freq, Node prev,
    Node next) {
        this.key = key;
        this.val = val;
        this.freq = freq;
        this.prev = prev;
        this.next = next;
    }
}

public class FrequencyList {
    Node dummyHead, dummyTail;
    int size;

    public FrequencyList() {
        dummyHead = new Node(0, 0);
        dummyTail = new Node(0, 0);
        dummyHead.next = dummyTail;
        dummyTail.prev = dummyHead;
        size = 0;
    }

    // add recently used node
    public void addToHead(Node node) {
        Node temp = dummyHead.next;
        temp.prev = node;
        node.next = temp;
        dummyHead.next = node;
        node.prev = dummyHead;
        size++;
    }

    // remove node from some Nth position
    public void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.prev = null;
        node.next = null;
        size--; 
    }

    // remove least recently used node
    public Node removeFromTail() {
        if (size == 0) {
            return null;
        }
        Node temp = dummyTail.prev;
        removeNode(temp);
        return temp;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
class LFUCache {
    private HashMap<Integer, Node> keyToNodeMap;
    private HashMap<Integer, FrequencyList> freqToListMap;
    int minFreq;
    int capacity;

    public LFUCache(int capacity) {
        keyToNodeMap = new HashMap<>();
        freqToListMap = new HashMap<>();
        minFreq = 0;
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if (capacity == 0 || !keyToNodeMap.containsKey(key)) {
            return -1;
        }
        Node node = keyToNodeMap.get(key);
        updateFreqAndFreqList(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if (keyToNodeMap.containsKey(key)) {
            // update value
            Node node = keyToNodeMap.get(key);
            node.val = value;
            updateFreqAndFreqList(node);
        } else {
            // check current size
            int currCapacity = keyToNodeMap.size();
            if (currCapacity == capacity) {
                // evict min freq used key
                FrequencyList minFreqList = freqToListMap.get(minFreq);
                Node removedNode = minFreqList.removeFromTail();
                keyToNodeMap.remove(removedNode.key);
            }
            // add the new key-value pair in cache
            Node newNode = new Node(key, value);
            keyToNodeMap.put(key, newNode);
            FrequencyList freqList = freqToListMap.computeIfAbsent(newNode.freq, k -> new FrequencyList());
            freqList.addToHead(newNode);
            minFreq = 1;
        }
    }

    private void updateFreqAndFreqList(Node node) {
        int oldFreq = node.freq;
        FrequencyList oldList = freqToListMap.get(node.freq);
        oldList.removeNode(node);

        int newFreq = node.freq + 1;
        FrequencyList newList = freqToListMap.computeIfAbsent(newFreq, k -> new FrequencyList());
        newList.addToHead(node);
        node.freq = newFreq;

        if (oldList.isEmpty() && oldFreq == minFreq) {
            minFreq++;
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */