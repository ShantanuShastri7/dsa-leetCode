class LRUCache {
    HashMap<Integer, Integer> map;
    Queue<Integer> LRU;
    Integer capacity;
    public LRUCache(int capacity) {
        this.map = new HashMap<>();
        this.LRU = new LinkedList<>();
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if(this.map.containsKey(key)){
            Integer value = this.map.get(key);
            updateAndDeleteLRU(key);
            return value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        updateAndDeleteLRU(key);
        this.map.put(key, value);
    }

    private void updateAndDeleteLRU(Integer key){
        if(this.map.containsKey(key)){
            this.LRU.remove((Integer) key);
        }
        this.LRU.offer(key);
        while(LRU.size()>this.capacity){
            Integer keys = LRU.poll();
            this.map.remove(keys);
        }
    }
}

// class LRUCache {
//     private final int capacity;
//     private final HashMap<Integer, Integer> map = new HashMap<>();
//     private final LinkedList<Integer> cachePriority = new LinkedList<>();

//     public LRUCache(int capacity) {
//         this.capacity = capacity;
//     }

//     public int get(int key) {
//         if (!map.containsKey(key)) return -1;
//         priorityReset(key);
//         return map.get(key);
//     }

//     public void put(int key, int value) {
//         if (map.containsKey(key)) {
//             map.put(key, value);
//             priorityReset(key);
//             return;
//         }

//         if (map.size() >= capacity) {
//             deleteLRU();
//         }

//         map.put(key, value);
//         cachePriority.addFirst(key);
//     }

//     private void priorityReset(int key) {
//         cachePriority.remove((Integer) key);  
//         cachePriority.addFirst(key);          
//     }

//     private void deleteLRU() {
//         int leastUsed = cachePriority.removeLast(); 
//         map.remove(leastUsed);                       
//     }
// }
