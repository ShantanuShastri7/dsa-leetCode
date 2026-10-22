class Solution {
    int MOD = 1_000_000_007;
    public int sumCounts(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        SegmentTree st = new SegmentTree(nums.length);
        int res=0;

        for(int i=0; i<nums.length; i++){
            if(map.containsKey(nums[i])){
                st.update(1, 0, nums.length-1, map.get(nums[i])+1, i, 1);
                map.put(nums[i], i);
            }else{
                st.update(1, 0, nums.length-1, 0, i, 1);
                map.put(nums[i], i);
            }

            res = (int)((res + st.sumSq[1]) % MOD);
        }

        return (int)res;
    }

    class SegmentTree{
        long[] sumSq;
        long[] sum;
        long[] lazy;

        public SegmentTree(int size){
            this.sumSq = new long[4*size];
            this.sum = new long[4*size];
            this.lazy = new long[4*size];
        }

        private void pushUp(int node){
            this.sumSq[node] = (this.sumSq[2 * node] + this.sumSq[2 * node + 1]) % MOD;
            this.sum[node] = (this.sum[2 * node] + this.sum[2 * node + 1]) % MOD;
        }

        private void pushDown(int node, int start, int end){
            if (this.lazy[node] == 0) return;

            long v = this.lazy[node];
            int mid = start + (end - start) / 2;
            long leftLen = mid - start + 1;
            long rightLen = end - mid;

            // Apply lazy value 'v' to Left Child (2 * node)
            this.sumSq[2 * node] = (this.sumSq[2 * node] + 2 * v % MOD * this.sum[2 * node] % MOD + v * v % MOD * leftLen % MOD) % MOD;
            this.sum[2 * node] = (this.sum[2 * node] + v * leftLen % MOD) % MOD;
            this.lazy[2 * node] = (this.lazy[2 * node] + v) % MOD;

            // Apply lazy value 'v' to Right Child (2 * node + 1)
            this.sumSq[2 * node + 1] = (this.sumSq[2 * node + 1] + 2 * v % MOD * this.sum[2 * node + 1] % MOD + v * v % MOD * rightLen % MOD) % MOD;
            this.sum[2 * node + 1] = (this.sum[2 * node + 1] + v * rightLen % MOD) % MOD;
            this.lazy[2 * node + 1] = (this.lazy[2 * node + 1] + v) % MOD;

            // Reset parent lazy tag
            this.lazy[node] = 0;
        }

        public void update(int node, int start, int end, int L, int R, int val){
            if(L<=start && R>=end){
                int len = end-start+1;
                this.sumSq[node] += 2*val*this.sum[node] + val*val*len;
                this.sum[node] += len*val;
                this.lazy[node]+=1;
            }else if(L>end || R<start){
                return;
            } else{
                pushDown(node, start, end); 

                int mid = start + (end - start) / 2;
                update(2 * node, start, mid, L, R, val);
                update(2 * node + 1, mid + 1, end, L, R, val);
                pushUp(node);
                return;
            }
        }
    }
}