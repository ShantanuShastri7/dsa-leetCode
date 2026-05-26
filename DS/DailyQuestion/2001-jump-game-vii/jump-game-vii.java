class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        if (s.charAt(s.length() - 1) == '1') return false;

        boolean[] dp = new boolean[s.length()];
        dp[0] = true;
        
        int activeReachable = 0;

        for (int i = 1; i < s.length(); i++) {
            // 1. ADD: Did a new index enter the front of our window?
            if (i - minJump >= 0 && dp[i - minJump]) {
                activeReachable++;
            }

            // 2. SUBTRACT: Did an old index fall out of the back of our window?
            if (i - maxJump - 1 >= 0 && dp[i - maxJump - 1]) {
                activeReachable--;
            }

            // 3. EVALUATE: Can we reach the current step?
            if (s.charAt(i) == '0' && activeReachable > 0) {
                dp[i] = true;
            }
        }

        return dp[s.length() - 1];
    }
}


// class Solution {
//     public boolean canReach(String s, int minJump, int maxJump) {
//         int[] memory = new int[s.length()];
//         Arrays.fill(memory, -1);

//         return helper(s, 0, minJump, maxJump, memory) == 1;
//     }

//     private int helper(String s, int index, int minJ, int maxJ, int[] memory) {
//         if (index == s.length() - 1) {
//             return s.charAt(index) == '0' ? 1 : 0;
//         }

//         if (memory[index] != -1) {
//             return memory[index];
//         }

//         for (int i = minJ; i <= maxJ; i++) {
//             int nextIndex = index + i;
            
//             if (nextIndex >= s.length()) {
//                 break; 
//             }

//             if (s.charAt(nextIndex) == '0') {
//                 if (helper(s, nextIndex, minJ, maxJ, memory) == 1) {
//                     memory[index] = 1;
//                     return 1;
//                 }
//             }
//         }
        
//         memory[index] = 0;
//         return 0;
//     }
// }

