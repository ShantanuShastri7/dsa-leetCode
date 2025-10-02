class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int ele1=-1;
        int ele2=-1;
        int count1=0;
        int count2=0;

        for(int i: nums){
            if(count1==0 && i!=ele2){
                count1=1;
                ele1=i;
            } else if(count2==0 && i!=ele1){
                count2=1;
                ele2=i;
            } else if(ele1==i){
                count1++;
            } else if(ele2==i){
                count2++;
            } else{
                count1--;
                count2--;
            }
        }

        int ct1=0; 
        int ct2=0;

        for(int i : nums){
            if(i==ele1){
                ct1++;
            } else if(i==ele2){
                ct2++;
            }
        }

        ArrayList<Integer> result = new ArrayList<>();

        if(ct1>nums.length/3) result.add(ele1);
        if(ct2>nums.length/3) result.add(ele2);

        return result;
    }
}