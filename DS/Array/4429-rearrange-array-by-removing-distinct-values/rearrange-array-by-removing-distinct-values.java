class Solution {
    public int[] rearrangeArray(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i: nums){
            if(!map.containsKey(i)){
                map.put(i, 1);
            }else{
                map.put(i, map.get(i)+1);
            }
        }

        List<Integer> res = new ArrayList<>();

        while(map.size() > 0){ 
            List<Integer> ans = new ArrayList<>(); 
            
            // Fix: Use an Iterator to safely remove items while looping
            Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
            
            while(iterator.hasNext()){ 
                Map.Entry<Integer, Integer> ma = iterator.next();
                Integer nu = ma.getKey(); 
                Integer nm = ma.getValue(); 
                
                ans.add(nu); 
                nm -= 1; 
                
                if(nm == 0){ 
                    iterator.remove(); // Safely removes the current element from the map
                } else {
                    ma.setValue(nm);   // Updates the map value
                }
            } 
            
            Collections.sort(ans); 
            res.addAll(ans); 
        } 

        int[] res2 = new int[res.size()];

        for(int i=0; i<res.size(); i++){
            res2[i]=res.get(i);
        }

        return res2;
    }
}