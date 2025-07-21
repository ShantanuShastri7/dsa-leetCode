class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] result = new int[nums.length];
        Arrays.fill(result, -1);
        Deque<Pair<Integer,Integer>> stack = new ArrayDeque<>();

        for(int i=0; i<2*nums.length; i++) {
            int index=i%nums.length;
            while(!stack.isEmpty() && nums[index]>stack.peek().getValue()){
                result[stack.pop().getKey()]=nums[index];
            }
            stack.push(new Pair<>(index, nums[index]));
        }

        return result;
    }
}