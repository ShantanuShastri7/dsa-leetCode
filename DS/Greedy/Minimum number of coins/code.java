import java.util.*;

class Solution {
    public int findMin(int n) {
        ArrayList<Integer> options = new ArrayList<>(Arrays.asList(10,5,2,1));
        
        int count=0;
        int i=0;
        
        while(n>0 && i<4){
            if(n>=options.get(i)){
                count+=n/options.get(i);
                n-=n/options.get(i)*options.get(i);
                i++;
            } else {
                i++;
            }
        }
        
        return count;
    }
}
