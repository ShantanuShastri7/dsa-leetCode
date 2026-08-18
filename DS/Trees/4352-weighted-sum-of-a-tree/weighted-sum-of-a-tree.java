class Solution {
    public long weightedSum(int[] parent, int[] nums) {
        int[] depth = new int[parent.length];
        Arrays.fill(depth, -1);
        int height=Integer.MIN_VALUE;

        for(int i=0; i<parent.length; i++){
            int d = helper(i, depth, parent);
            height=Math.max(height, d);
            depth[i]=d;
        }

        long res =0l;

        for(int i=0; i<nums.length; i++){
            res += (long)nums[i]*(height-depth[i]+1);
        }

        return res;

    }

    private int helper(int node, int[] depth, int[] parent){
        if(parent[node]==-1) return 1;

        if(depth[node]==-1){
            return depth[node]=1+helper(parent[node], depth, parent);
        }else {
            return depth[node];
        }
    }
}