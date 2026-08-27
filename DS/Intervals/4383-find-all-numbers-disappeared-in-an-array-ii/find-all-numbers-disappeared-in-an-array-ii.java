class Solution {
    public List<List<Integer>> findDisappearedNumbers(int[] nums, int lower, int upper) {
        Arrays.sort(nums);

        ArrayList<List<Integer>> res = new ArrayList<>();

        if(nums[0]>upper || nums[nums.length-1]<lower) return new ArrayList<List<Integer>>(Arrays.asList(Arrays.asList(lower, upper)));

        int start = lower;
        int next=lower;

        for(int i=0; i<nums.length; i++){
            next=nums[i];

            if(start==next){
                start=start+1;
                continue;
            }else if(next<start || next>upper){
                continue;
            
            //next>start
            }else{
                res.add(new ArrayList<>(Arrays.asList(start, next-1)));
                start=next+1;
            }
        }

        if(start<=upper){
            res.add(new ArrayList<>(Arrays.asList(start, upper)));
        }

        return res;
    }
}