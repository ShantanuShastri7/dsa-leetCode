class TimeMap {
    HashMap<String, TreeSet<Pair<String, Integer>>> timestampMap;

    public TimeMap() {
        timestampMap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!timestampMap.containsKey(key)){
            timestampMap.put(key, new TreeSet<>((a,b)->{
                return b.getValue()-a.getValue();
            }));

            timestampMap.get(key).add(new Pair<>(value, timestamp));
        } else {
            timestampMap.get(key).add(new Pair<>(value, timestamp));
        }
    }
    
    public String get(String key, int timestamp) {
        TreeSet<Pair<String, Integer>> set = timestampMap.get(key);
        if(set==null) return "";
        
        Iterator<Pair<String, Integer>> iterator = set.iterator();

        while(iterator.hasNext()){
            Pair<String, Integer> value = iterator.next();
            if(value.getValue()<=timestamp) return value.getKey();
        }
        return "";
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */