class Solution {
    static int lcs(String s1, String s2) {
        int[][] mem = new int[s1.length()][s2.length()];
        
        for(int i=0; i<s1.length(); i++){
            Arrays.fill(mem[i], -1);
        }
        
        return helper(s1, s2, s1.length()-1, s2.length()-1, mem);
        
    }
    
    private static int helper(String one, String two, int sOne, int sTwo, int[][] mem){
        if(sOne<0 || sTwo<0){
            return 0;
        }
        
        if(mem[sOne][sTwo]!=-1) return mem[sOne][sTwo];
        
        int pick=0;
        
        if(one.charAt(sOne)==two.charAt(sTwo)){
            pick = 1+helper(one, two, sOne-1, sTwo-1, mem);
        }
        
        int notPick = Math.max(helper(one, two, sOne, sTwo-1, mem),
        helper(one, two, sOne-1, sTwo, mem));
        
        return mem[sOne][sTwo] = Math.max(notPick, pick);
    }
}
