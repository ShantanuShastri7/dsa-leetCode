class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length%groupSize!=0) return false;

        TreeMap<Integer, Integer> map = new TreeMap<>();

        for(int i : hand){
            if(map.containsKey(i)){
                map.put(i, map.get(i)+1);
            }else{
                map.put(i, 1);
            }
        }

        int n = hand.length/groupSize;

        while(n>0){
            int smallestKey = map.firstKey();
            int freq = map.get(smallestKey);
            if(freq==1){
                map.remove(smallestKey);
            }else{
                map.put(smallestKey, freq-1);
            }
            int largestInGroup = smallestKey+groupSize-1;
            for(int i=smallestKey+1; i<=largestInGroup; i++){
                if(!map.containsKey(i)) return false;
                int nextFreq = map.get(i);
                if(nextFreq==1){
                    map.remove(i);
                }else{
                    map.put(i, nextFreq-1);
                }
            }
            n--;
        }

        return true;
    }
}