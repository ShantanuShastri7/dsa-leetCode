class Solution {
    public int minimumCost(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        int res = nums[0];

        for(int i=1; i<nums.length; i++){
            pq.offer(nums[i]);

            if(pq.size()>2) pq.poll();
        }

        while(!pq.isEmpty()){
            res+=pq.poll();
        }

        return res;
    }
}