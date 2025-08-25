class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if(bloomDay.length<m*k) return -1;
        int result=-1;

        int i= Arrays.stream(bloomDay).min().getAsInt();
        int j= Arrays.stream(bloomDay).max().getAsInt();

        while(i<=j){
            int mid = (i+j)/2;
            int remain = canMakeBouquet(bloomDay, mid, m, k);
            if(remain<=0){
                result=mid;
                j=mid-1;
            } else{
                i=mid+1;
            }
        }
        return result;
    }

    private int canMakeBouquet(int[] bloomDay, int midDay, int required, int perBouquet){
        int count=0;

        for(int day : bloomDay){
            if(day<=midDay) count++;
            else count=0;

            if(count==perBouquet){
                required--;
                count=0;
            }
        }

        return required;
    }
}