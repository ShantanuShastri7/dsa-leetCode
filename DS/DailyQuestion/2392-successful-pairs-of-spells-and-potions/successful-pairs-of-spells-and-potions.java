class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int[] result = new int[spells.length];
        int n = potions.length;

        for(int i=0; i<spells.length; i++){
            int left=0; 
            int right=n-1;
            int res=-1;

            while(left<=right){
                int mid = (left+right)/2;

                if((long) potions[mid]*spells[i]< success){
                    left=mid+1;
                } else{
                    res=mid;
                    right=mid-1;
                }
            }
            if(res==-1) result[i]=0;
            else result[i]=n-res;
        }

        return result;
    }
}