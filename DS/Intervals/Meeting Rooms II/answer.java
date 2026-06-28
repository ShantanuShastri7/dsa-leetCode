class Solution {
	public int minMeetingRooms(int[] start, int[] end) {
	    Arrays.sort(start);
	    Arrays.sort(end);
	    
	    int count=0;
	    int asn=0;
	    int i=0;
	    int j=0;
	    while(i<start.length && j<start.length){
	        if(start[i]<end[j]){
	            count++;
	            asn=Math.max(asn, count);
	            i++;
	        } else{
	            count--;
	            j++;
	        }
	    }
		
		return asn;
	}
}
