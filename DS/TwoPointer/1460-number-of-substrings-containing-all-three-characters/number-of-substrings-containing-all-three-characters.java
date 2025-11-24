class Solution {
    public int numberOfSubstrings(String s) {
        int[] lastAdded = new int[3];
        Arrays.fill(lastAdded, -1);
        int result=0;
        int right=0;

        while(right<s.length()){
            Character c = s.charAt(right);
            lastAdded[c-'a']=right;

            if(lastAdded[0]!=-1 && lastAdded[1]!=-1 && lastAdded[2]!=-1){
                int last = Math.min(lastAdded[0], Math.min(lastAdded[1], lastAdded[2]));

                result+=last+1;
            }
            right++;
        }

        return result;
    }
}