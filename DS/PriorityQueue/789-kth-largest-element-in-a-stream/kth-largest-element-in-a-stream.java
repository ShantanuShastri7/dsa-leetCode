class KthLargest {
    int k;
    PriorityQueue<Integer> pr = new PriorityQueue<>();

    public KthLargest(int k, int[] nums) {
        this.k=k;
        for(int i=0;i<nums.length; i++){
            this.pr.offer(nums[i]);
            if(this.pr.size()>k) this.pr.poll();
        }
    }
    
    public int add(int val) {
        this.pr.offer(val);
        if(this.pr.size()>this.k){
            this.pr.poll();
        }

        return pr.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */