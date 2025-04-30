class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        Map<Integer, Integer> nums2NextGreaterMap = new HashMap<>();
        Deque<Integer> stack = new ArrayDeque<>();

        for(int num : nums2){
            while(!stack.isEmpty() && num>stack.peek()) {
                nums2NextGreaterMap.put(stack.pop(), num);
            }
            stack.push(num);
        }

        while(!stack.isEmpty()){
            nums2NextGreaterMap.put(stack.pop(), -1);
        }

        for(int i=0; i<nums1.length; i++){
            result[i]=nums2NextGreaterMap.get(nums1[i]);
        }

        return result;
    }
}