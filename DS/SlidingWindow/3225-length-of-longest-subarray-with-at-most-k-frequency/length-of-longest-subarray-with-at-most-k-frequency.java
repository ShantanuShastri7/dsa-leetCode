class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int l=0;
        int r=0;
        int res=0;
        
        while(r<nums.length){
            if(map.containsKey(nums[r]) && map.get(nums[r])<k){
                map.put(nums[r], map.get(nums[r])+1);
                res=Math.max(res, r-l+1);
                r++;
            } else if(map.containsKey(nums[r]) && map.get(nums[r])>=k){
                while(map.get(nums[r])>=k){
                    map.put(nums[l], map.get(nums[l])-1);
                    l++;
                }
            }else{
                map.put(nums[r], 1);
                res=Math.max(res, r-l+1);
                r++;
            }
        }

        return res;
    }
}