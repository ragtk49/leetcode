class MyHashSet {
    
    private boolean hashSet[][];
    private int buckets;
    private int bucketValues;

    public MyHashSet() {
        buckets = 1000;
        bucketValues = 1000;
        hashSet = new boolean[buckets][];
    }
    
    private int bucket(int key){
        return key % 1000;
    }
    
    private int bucketValues(int key){
        return key / 1000;
    }
    
    public void add(int key) {
        int bucket = bucket(key);
        int bucketValue = bucketValues(key);
        if(hashSet[bucket] == null){
            if(bucket == 0){
                hashSet[bucket] = new boolean[bucketValues + 1];
            }
            else{
                hashSet[bucket] = new boolean[bucketValues];
            }
        }
        hashSet[bucket][bucketValue] = true;
    }
    
    public void remove(int key) {
        int bucket = bucket(key);
        int bucketValue = bucketValues(key);
        if(hashSet[bucket] == null) return;
        hashSet[bucket][bucketValue] = false;
    }
    
    public boolean contains(int key) {
        int bucket = bucket(key);
        int bucketValue = bucketValues(key);
        if(hashSet[bucket] == null) return false;
        return hashSet[bucket][bucketValue];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */