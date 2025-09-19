class SnapshotArray {
    private List<TreeMap<Integer, Integer>> records;
    private int snapId;

    public SnapshotArray(int length) {
        records = new ArrayList<>(length);
        for (int i = 0; i < length; i++) {
            TreeMap<Integer, Integer> map = new TreeMap<>();
            map.put(0, 0); // initial value 0 at snap_id = 0
            records.add(map);
        }
        snapId = 0;
    }

    public void set(int index, int val) {
        records.get(index).put(snapId, val); // record change for current snap
    }

    public int snap() {
        return snapId++; // just increment, O(1)
    }

    public int get(int index, int snap_id) {
        return records.get(index).floorEntry(snap_id).getValue();
    }
}