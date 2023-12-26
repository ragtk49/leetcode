class MyHashMap {
    class Node{
        int key;
        int val;
        Node next;
        public Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }
    
    Node nodes[];
    public MyHashMap() {
        nodes = new Node[10000];
    }
    
    private int hashKey(int key){
        return Integer.hashCode(key) % 10000;
    }
    
    private Node findKey(int key, Node node){
        Node prev = null;
        Node curr = node;
        while(curr != null && curr.key != key ){
            prev = curr;
            curr = curr.next;
        }
        return prev;
        
        
    }
    
    public void put(int key, int value) {
        int hkey = hashKey(key);
        if(nodes[hkey] == null){
            nodes[hkey] = new Node(-1, -1);
        }
        Node prev = findKey(key, nodes[hkey]);
        if(prev.next == null){
            prev.next = new Node(key, value);
        }
        prev.next.val = value;
    }
    
    public int get(int key) {
        int hkey = hashKey(key);
        if(nodes[hkey] == null){
            return -1;
        }
        Node prev = findKey(key, nodes[hkey]);
        if(prev.next != null) return prev.next.val; 
        else{
            return -1;
        }
        
    }
    
    public void remove(int key) {
        int hkey = hashKey(key);
        if(nodes[hkey] == null) return;
        Node prev = findKey(key, nodes[hkey]);
        if(prev.next != null) prev.next = prev.next.next;
        else{
            return;
        }
        
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */