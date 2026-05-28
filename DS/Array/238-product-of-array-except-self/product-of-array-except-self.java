class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] leftPass = new int[nums.length];
        int[] rightPass = new int[nums.length];
        leftPass[0]=nums[0];
        rightPass[nums.length-1]=nums[nums.length-1];

        for(int i=1, j=nums.length-2; i<nums.length && j>0; i++, j--){
            leftPass[i]=leftPass[i-1]*nums[i];
            rightPass[j]=rightPass[j+1]*nums[j];
        }

        int[] solution = new int[nums.length];
        solution[0]=rightPass[1];
        solution[nums.length-1]=leftPass[nums.length-2];

        for(int i=1; i<nums.length-1; i++){
            solution[i]=leftPass[i-1]*rightPass[i+1];
        }

        return solution;
    }
}