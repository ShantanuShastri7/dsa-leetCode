class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length<=1) return nums.length;
        
        Set<Integer> set = new HashSet<>();

        for(int i : nums){
            set.add(i);
        }

        int largest = 1;
        Iterator<Integer> it = set.iterator();
        while(it.hasNext()){
            int num = it.next();

            if(set.contains(num-1)) continue;
            int newLargest=1;
            while(set.contains(num+1)){
                newLargest++;
                num=num+1;
            }

            if(newLargest>largest) largest=newLargest;
        }

        return largest;
    }
}