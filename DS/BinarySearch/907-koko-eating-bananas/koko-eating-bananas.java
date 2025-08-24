import java.util.Arrays;
import java.util.OptionalInt;

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int i=0; 
        int j=Arrays.stream(piles).max().getAsInt();
        int result=0;

        while(i<=j){
            int mid=(i+j)/2;
            int hrs = timeRequired(piles, mid);

            if(hrs<=h){
                result=mid;
                j=mid-1;
            } else {
                i=mid+1;
            }
        }
        return result;
    }

    private int timeRequired(int[] piles, int perHr){
        int count=0;

        for(int pile : piles){
            count+=Math.ceil((double)((double)pile/(double)perHr));
        }
        return count;
    }
}