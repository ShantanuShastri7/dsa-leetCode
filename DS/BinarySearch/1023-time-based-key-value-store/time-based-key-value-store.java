class TimeMap {
    Map<String, TreeMap<Integer, String>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)){
            TreeMap<Integer, String> tMap = new TreeMap<>();
            tMap.put(timestamp, value);
            map.put(key,tMap);
        }else{
            TreeMap<Integer, String> tMap = map.get(key);
            tMap.put(timestamp, value);
        }
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)) return "";

        TreeMap<Integer, String> tMap = map.get(key);

        Integer k = tMap.floorKey(timestamp);

        if(k==null) return "";

        return tMap.get(k);
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */