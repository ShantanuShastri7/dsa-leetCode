class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        Map<Integer, Integer> nums2NextGreaterMap = new HashMap<>();

        for(int i=0; i<nums2.length; i++){
            boolean nextGreaterFound = false;
            for(int j=i+1; j<nums2.length; j++){
                if(nums2[j]>nums2[i]){
                    nextGreaterFound=true;
                    nums2NextGreaterMap.put(nums2[i], nums2[j]);
                    break;
                }
            }
            if(!nextGreaterFound) nums2NextGreaterMap.put(nums2[i], -1);
        }

        for(int i=0; i<nums1.length; i++){
            result[i]=nums2NextGreaterMap.get(nums1[i]);
        }

        return result;
    }
}