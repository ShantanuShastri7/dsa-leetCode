class LRUCache {
    private final int capacity;
    private final HashMap<Integer, Integer> map = new HashMap<>();
    private final LinkedList<Integer> cachePriority = new LinkedList<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        priorityReset(key);
        return map.get(key);
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            map.put(key, value);
            priorityReset(key);
            return;
        }

        if (map.size() >= capacity) {
            deleteLRU();
        }

        map.put(key, value);
        cachePriority.addFirst(key);
    }

    private void priorityReset(int key) {
        cachePriority.remove((Integer) key);  // Safe remove
        cachePriority.addFirst(key);          // Most recently used
    }

    private void deleteLRU() {
        int leastUsed = cachePriority.removeLast();  // Remove from list
        map.remove(leastUsed);                       // Remove from map
    }
}
