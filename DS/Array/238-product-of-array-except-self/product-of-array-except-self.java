class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];

        // 1. LEFT PASS: Fill 'answer' with the product of all elements to the LEFT.
        // There are no elements to the left of the 0th index, so we start with 1.
        answer[0] = 1;
        for (int i = 1; i < n; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }

        // 2. RIGHT PASS: Multiply 'answer' by the product of all elements to the RIGHT.
        // We use a single variable 'right' to track this on the fly.
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            answer[i] = answer[i] * right; // Multiply by the right-side product
            right = right * nums[i];       // Update the right-side product for the next iteration
        }

        return answer;
    }
}

// class Solution {
//     public int[] productExceptSelf(int[] nums) {
//         int[] leftPass = new int[nums.length];
//         int[] rightPass = new int[nums.length];
//         leftPass[0]=nums[0];
//         rightPass[nums.length-1]=nums[nums.length-1];

//         for(int i=1, j=nums.length-2; i<nums.length && j>0; i++, j--){
//             leftPass[i]=leftPass[i-1]*nums[i];
//             rightPass[j]=rightPass[j+1]*nums[j];
//         }

//         int[] solution = new int[nums.length];
//         solution[0]=rightPass[1];
//         solution[nums.length-1]=leftPass[nums.length-2];

//         for(int i=1; i<nums.length-1; i++){
//             solution[i]=leftPass[i-1]*rightPass[i+1];
//         }

//         return solution;
//     }
// }