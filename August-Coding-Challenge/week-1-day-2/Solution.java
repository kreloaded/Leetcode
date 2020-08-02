/*

Title: Design HashSet

Problem Statement: Design a HashSet without using any built-in hash table libraries.

To be specific, your design should include these functions:

add(value): Insert a value into the HashSet. 
contains(value) : Return whether the value exists in the HashSet or not.
remove(value): Remove a value in the HashSet. If the value does not 
	exist in the HashSet, do nothing.

Example:

MyHashSet hashSet = new MyHashSet();
hashSet.add(1);         
hashSet.add(2);         
hashSet.contains(1);    // returns true
hashSet.contains(3);    // returns false (not found)
hashSet.add(2);          
hashSet.contains(2);    // returns true
hashSet.remove(2);          
hashSet.contains(2);    // returns false (already removed)

Note:

All values will be in the range of [0, 1000000].
The number of operations will be in the range of [1, 10000].
Please do not use the built-in HashSet library.

*/

// Java solution using buckets

class MyHashSet {
    private List<Integer>[] bucket;
    private int capacity;
    private double loadFactor;
    private int count = 0;
    
    /** Initialize your data structure here. */
    public MyHashSet() {
        capacity = 1000;
        loadFactor = 0.75;
        bucket = new LinkedList[capacity];
    }
    
    public void add(int key) {
        if (contains(key))
            return;
        if (loadFactor * capacity == count) {
            count = 0;
            capacity *= 2; // double the capacity
            List<Integer>[] oldBucket = bucket;
            bucket = new LinkedList[capacity];
            for (int i = 0; i < oldBucket.length; i++) {
                List<Integer> list = oldBucket[i];
                if (list != null) {
                    for (int entry : list)
                        this.add(entry);
                }
            }
        }

        int hash = key % capacity;
        if (bucket[hash] == null)
            bucket[hash] = new LinkedList<>();
        bucket[hash].add(key);
        ++count;
    }
    
    public void remove(int key) {
        int hash = key % capacity;
        List<Integer> list = bucket[hash];
        if (list != null) {
            Iterator<Integer> iterator = list.iterator();
            while (iterator.hasNext()) {
                if (iterator.next() == key) {
                    iterator.remove();
                    --count;
                }
            }
        }
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int hash = key % capacity;
        List<Integer> list = bucket[hash];
        if (list != null) {
            for (int k : list)
                if (k == key)
                    return true;
        }
        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
 