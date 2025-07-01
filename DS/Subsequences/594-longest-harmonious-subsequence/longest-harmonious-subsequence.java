import java.util.*;

class Solution {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int maxLen = 0;

        for (int key : map.keySet()) {
            if (map.containsKey(key + 1)) {
                int len = map.get(key) + map.get(key + 1);
                maxLen = Math.max(maxLen, len);
            }
        }

        return maxLen;
    }
}


//Tried using recursion, but TLE : )


// class Solution {
//     public int findLHS(int[] nums) {
//         ArrayList<Integer> current = new ArrayList<>();
//         return helper(nums, 0, current);
//     }

//     private int helper(int[] nums, int index, ArrayList<Integer> current){
//         if(index==nums.length){
//             if(!current.isEmpty() && (Collections.max(current)-Collections.min(current)==1)){
//                 return current.size();
//             }
//             return 0;
//         }

//         current.add(nums[index]);
//         int pick = helper(nums, index+1, current);

//         current.remove(current.size()-1);
//         int notPick = helper(nums, index+1, current);

//         return Math.max(pick, notPick);
//     }
// }