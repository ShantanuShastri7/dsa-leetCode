class TimeMap {
    HashMap<String, TreeSet<Pair<String, Integer>>> timestampMap;

    public TimeMap() {
        timestampMap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        timestampMap.putIfAbsent(key, new TreeSet<>(Comparator.comparingInt(Pair::getValue)));
        timestampMap.get(key).add(new Pair<>(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        TreeSet<Pair<String, Integer>> set = timestampMap.get(key);
        if (set == null) return "";

        Pair<String, Integer> dummy = new Pair<>("", timestamp);
        Pair<String, Integer> floor = set.floor(dummy); // O(log n)
        
        return floor != null ? floor.getKey() : "";
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */