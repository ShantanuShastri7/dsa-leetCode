class Solution {
    public int majorityElement(int[] nums) {
        int el=-1; 
        int count=0; 

        for(int i : nums){
            if(count==0){
                el=i;
                count=1;
            } else if(i==el){
                count++;
            } else{
                count--;
            }
        }

        int newCount=0; 

        for(int i : nums){
            if(i==el){
                newCount++;
            }
        }

        if(newCount>nums.length/2) return el;

        return -1;
    }
}