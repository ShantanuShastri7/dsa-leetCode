class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int greatestIndex =-1;
        int[] result = new int[nums.length-k+1];
        Deque<Integer> q = new ArrayDeque<>();

        for(int i=0; i<nums.length; i++){
            if(!q.isEmpty() && i>=q.peekFirst()+k){
                q.removeFirst();
            }

            while(!q.isEmpty() && nums[i]>=nums[q.peekLast()]){
                q.removeLast();
            }
            q.addLast(i);

            if(i>=k-1){
                result[i-k+1]=nums[q.peekFirst()];
            }
        }
        return result;   
    }
}