class MyHashSet {
    int mod = 1000001;
    int buckets[];

    public MyHashSet() {
        buckets = new int[mod+1];
        Arrays.fill(buckets, -1);
    }
    
    public void add(int key) {
        int hash = getHash(key);
        buckets[hash] = key;
    }
    
    public void remove(int key) {
        int hash = getHash(key);
        
        if(buckets[hash] == -1){
            return;
        }

        buckets[hash] = -1;
    }
    
    public boolean contains(int key) {
        int hash = getHash(key);
        
        if(buckets[hash] != -1){
            return true;
        }

        return false;
    }

    private int getHash(int key){
        return key % mod;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */