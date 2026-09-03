class Solution {
    public boolean uniformArray(int[] nums1) {
        int smallestOdd = Integer.MAX_VALUE;
        int smallestEven = Integer.MAX_VALUE;

        for(int i : nums1){
            if(i%2==0) smallestEven = Math.min(smallestEven, i);
            else smallestOdd = Math.min(smallestOdd, i);
        }

        boolean oddPresent = smallestOdd!=Integer.MAX_VALUE;
        boolean evenPresent = smallestEven!=Integer.MAX_VALUE;
        boolean evenPossible = true;
        boolean oddPossible = true;

        for(int i : nums1){
            if(i%2==0) continue;
            else{
                if(smallestOdd>=i) {
                    System.out.print("num:" +i+"\n");
                    evenPossible=false;
                    break;
                }
            }
        }

        for(int i : nums1){
            if(i%2!=0) continue;
            else{
                if(smallestOdd>=i) {
                    System.out.print("num:" +i+"\n");
                    oddPossible=false;
                    break;
                }
            }
        }

        return evenPossible || oddPossible;
    }
}